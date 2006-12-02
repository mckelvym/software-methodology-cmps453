// Class    : CMPS 453
// Section  : 001

package game;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Main window for tic tac toe.
 * This will handle all the user interfaces and interactions.
 *
 * @author Mark
 */

public class TicTacToeWindow extends JFrame {

    /**
     * Since we are using a serializable object, this needs to be here.
     */
    static final long serialVersionUID = 7526472295622776147L;
    /**
     * These variables deal with the window attributes
     */
    static private String Title;
    static private int screenWidth;
    static private int screenHeight;
    static private int windowWidth;
    static private int windowHeight;
    static private Dimension dimension;
    /**
     * Keep track of available playing modes;
     */
    private final String gameModes[] = {"human", "cpuEasy", "cpuNovice", "cpuMedium", "cpuIntermediate", "cpuHard"};
    /**
     * Handles High Scores and File IO
     */
    FileAndScoresHandler highscoresHandler;
    /**
     * Used for random turn decisions.
     */
    java.util.Random rand = new java.util.Random();
    /**
     * Enable/Disable the use of the turn dialog.
     */
    private boolean turnDialogsOn = false;
    /**
     * Keep track of whose turn it is.
     */
    private boolean isPlayerOnesTurn = false;
    /**
     * Keeps track of consecutive wins.
     */
    private int playerwins = 0;
    /**
     * Filename to high scores.
     */
    private String highscoresFilename = "files/highscores.list";
    /**
     * Playing type of vs. opponent
     */
    private Strategy strategy;
    /**
     * What type of game is being played?
     * "human" is human vs human
     * "cpueasy" is human vs cpueasy
     */
    private String gameMode;
    /**
     * Keeps track of the players piece, where it be an "x" or "o" or something other
     */
    private String playerPieces[] = new String[2];
    /**
     * visible state of the board
     */
    private JButtonJR grid[][];
    /**
     * keeps track of the state of the board
     * 0 represents a piece not used
     * 1 represents a piece is used by player 1
     * 2 represents a piece is used by player 2
     */
    private TicTacToeBoard state;
    /**
     * Checks if there has been a win or not.
     */
    private WinChecker winchecker;

    /**
     * Public constructor handles initialization of window by centering it on the screen,
     * adds a menubar to itself, adds its buttons, and transfers control to the "play" method.
     *
     * @param title
     */
    public TicTacToeWindow(String title) {
        // create a new JFrame (window) with the parameterized title
        super(Title = title);

        // gets the dimensions of the current screen

        // grab a dimension object
        dimension = this.getToolkit().getScreenSize();

        // find the screen width and the screen height
        screenWidth = (int) (dimension.getWidth());
        screenHeight = (int) (dimension.getHeight());

        // set the window size variables according to the screen size (half of it)
        windowWidth = screenWidth / 2;
        windowHeight = screenHeight / 2;

        // set the size of this window proportional to the screen size
        this.setSize(windowWidth, windowHeight);

        // centers the window on the screen
        this.setLocation((int) ((screenWidth - windowWidth) / 2), (int) ((screenHeight - windowHeight) / 2));

        // allow resize of the window?
        this.setResizable(false);

        // make the window always on top? (throws an exception that we need to catch)
        try {
            this.setAlwaysOnTop(false);
        } catch (Exception e) {
            // don'tictactoewindow do anything
        }

        // adds an observer that will be notified when the window is closing
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.out.println("\n - " + Title + " closing..");
                System.exit(0);
            }
        });

        // initialize the board buttons and tictactoe board
        initialize();
        addMenuBar();
        addButtons();

        // give some default initialization to the strategy,
        strategy = new Strategy_Human(this);
        gameMode = "human";
        setPlayerPiece("x", 1);
        setPlayerPiece("o", 2);

        highscoresHandler = new FileAndScoresHandler(highscoresFilename);
        highscoresHandler.readFile();

        // Prompts the user for game type
        showGameModeDialog();
        // prompt for player piece
        if (JOptionPane.showConfirmDialog(this, "Use default X and O?", "Go with default?", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
            showPlayerPiecesDialog();
        }

        setWinChecker(0);
        toggleTurn();

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                close();
            }
        });
    }

    /**
     * Saves the high scores list and closes the program.
     */
    public void close() {
        saveScores();
        dispose();
        System.exit(0);
    }

    /**
     * adds a menubar to this window
     */
    private void addMenuBar() {
        JMenuBar menubar = new JMenuBar();

		// create an "options" dropdown
        JMenu menu_options = new JMenu("Options");
        // create buttons for the "options" dropdown
        JMenuItem menu_options_pieces = new JMenuItem("Change Pieces");
        JMenuItem menu_options_reset = new JMenuItem("Reset");
        JMenuItem menu_options_exit = new JMenuItem("Exit");
        // build "options" dropdown
        menu_options.add(menu_options_pieces);
        menu_options.addSeparator();
        menu_options.add(menu_options_reset);
        menu_options.add(menu_options_exit);

        // create a "cpu difficulty" dropdown
        JMenu menu_difficulty = new JMenu("Difficulty");
        // create buttons for this dropdown
        JMenuItem menu_difficulty_dialog = new JMenuItem("Choose Difficulty");
        // build dropdown
        menu_difficulty.add(menu_difficulty_dialog);

        // create a "dialogs" dropdown
        JMenu menu_dialogs = new JMenu("Dialogs");
        // create buttons for this dropdown
        JMenuItem menu_dialogs_turn = new JMenuItem("Toggle Turn Dialog on/off");
        // build dropdown
        menu_dialogs.add(menu_dialogs_turn);

        // create a "highscores" dropdown
        JMenu menu_scores = new JMenu("High Scores");
        // create buttons for this dropdown
        JMenuItem menu_scores_filename = new JMenuItem("Change Scores File..");
        JMenuItem menu_scores_show = new JMenuItem("See High Scores");
        // build dropdown
        menu_scores.add(menu_scores_filename);
        menu_scores.add(menu_scores_show);

        // add dropdowns to menubar
        menubar.add(menu_options);
        menubar.add(menu_difficulty);
        menubar.add(menu_dialogs);
        menubar.add(menu_scores);

        // set the menubar for this window
        this.setJMenuBar(menubar);

        // add observers to the dropdown buttons

        // allow changing of character pieces
        menu_options_pieces.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showPlayerPiecesDialog();
            }
        });

        // if the reset button is pressed, handle it here
        menu_options_reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveScores();
                reset();
            }
        });

        // if the exit button is pressed, handle it here
        menu_options_exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                highscoresHandler.writeFile();
                System.exit(0);
            }
        });

        // when the user changes the difficulty, we need to change our strategy
        menu_difficulty_dialog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveScores();
                reset();
                showGameModeDialog();
            }
        });

        // when the user changes the difficulty, we need to change our strategy
        menu_dialogs_turn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                turnDialogsOn = !turnDialogsOn;
            }
        });

        // handle a new high scores file
        menu_scores_filename.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showFileNameDialog();
            }
        });

        // handle a new high scores file
        menu_scores_show.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showHighScores();
            }
        });
    }

    /**
     * Allows the computer strategy to display a visual result of how long
     * it will take to determine a new move.
     *
     * @param lengthOfTask
     */
    public void showProgress(int lengthOfTask) {
        new ProgressWindow(this, "Calculating Move..", lengthOfTask).setVisible(true);
    }

    /**
     * Shows a notification when the user wins.
     *
     * @param player         - which player won.
     * @param isActuallyLoss - true if is a loss against the cpu, (shows a different notification)
     */
    private void showCelebration(int player, boolean isActuallyLoss) {
        if (!isActuallyLoss) {
            new Celebration(this, "Winner!", "Player " + player + " pwn3d! (WIN TOTAL: " + playerwins + ")", "files/win.jpg").setVisible(true);
        } else {
            new Celebration(this, "Loser!", "Player " + player + " was pwn3d! (YOU LOSE)", "files/win.jpg").setVisible(true);
        }
    }

    /**
     * Shows a window with high scores to the user.
     */
    private void showHighScores() {
        new HighScoresWindow(this, highscoresHandler.getScoreNames(), highscoresHandler.getScoreValues()).setVisible(true);
    }

    /**
     * Prompts the user to input a new filename for the high scores file.
     */
    private void showFileNameDialog() {
        String fname;
        boolean keepgoing = true;
        do {
            fname = JOptionPane.showInputDialog(this, "Specify highscores filename: ");
            if (fname == null || !fname.equals(""))
                keepgoing = false;
        } while (keepgoing);

        if (fname != null && !fname.equals("")) {
            highscoresFilename = fname;
            highscoresHandler = new FileAndScoresHandler(highscoresFilename);
            highscoresHandler.readFile();
        }

    }

    /**
     * Gives the user a list of options to choose from for game mode type.
     */
    private void showGameModeDialog() {
        new GameModeDialog(this, "Please Choose Game Type", gameModes).setVisible(true);
    }

    /**
     * Allows the user to change their pieces from the default ones.
     */
    private void showPlayerPiecesDialog() {
        String p1;
        String p2;
        boolean keepgoing = true;
        do {
            p1 = JOptionPane.showInputDialog(this, "Player 1 piece?");
            p2 = JOptionPane.showInputDialog(this, "Player 2 piece?");
            if (p1 == null || p2 == null || !p1.equals(p2) && !p1.equals("") && !p2.equals(""))
                keepgoing = false;
        } while (keepgoing);

        if (p1 != null)
            setPlayerPiece(p1.substring(0, 1), 1);
        if (p2 != null)
            setPlayerPiece(p2.substring(0, 1), 2);
    }

    /**
     * Notify player "player" that it is their turn.
     * This displays an "ok" dialog that notifies the user of their turn.
     *
     * @param player - the player whose turn it is, 1 or 2
     */
    private void showTurnDialog(int player) {
        if ((player == 1 || player == 2) && !(player == 2 && isHumanVsCPU())) {
            JOptionPane.showMessageDialog(this, "Player " + player + " is it your turn.", "Player " + player, player);
        }
    }

    /**
     * adds the buttons to the window
     */
    private void addButtons() {
        this.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.add(grid[i][j]);
            }
        }
    }

    /**
     * handles initialization of the board, this shouldn'tictactoewindow be called directly
     */
    private void initializeButtons() {
        grid = new JButtonJR[3][3];
        Color fore, back;

        if (System.getProperty("os.name").equals("Mac OS X")) {
            fore = Color.BLACK;
            back = Color.WHITE;
        } else {
            back = Color.BLACK;
            fore = Color.WHITE;
        }


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = new JButtonJR(this, i, j);
                grid[i][j].setBackground(back);
                grid[i][j].setForeground(fore);
                grid[i][j].setFont(new Font("Verdana", Font.PLAIN, 22));
            }
        }
    }

    /**
     * handles initialization of the board and the buttons
     */
    private void initialize() {
        state = TicTacToeBoard.getInstance();
        state.reset();
        initializeButtons();
    }

    /**
     * This is a handler for outside classes such as a wincondition checker,
     * it allows easy resetting of the board.
     */
    public void reset() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j].reset();
            }
        }
        state.reset();
        // resets the strategies
        setStrategy(gameMode);
    }

    /**
     * returns the state of the x,y "grid"
     * remember, both and y should be between 0 and 2 inclusive
     * a value of 0 means the piece is not used
     * a value of 1 means it is used by player 1
     * a value of 2 means it is used by player 2
     *
     * @param x
     * @param y
     * @return
     */
    public int getState(int x, int y) {
        return state.getVal(x, y);
    }

    /**
     * set the state of a grid location
     * remember, both x and y should be between 0 and 2 inclusive
     * remember, player should be one or two
     * for state values
     * a value of 0 means it is not used
     * a value of 1 means it is used by player 1
     * a value of 2 means it is used by player 2
     *
     * @param x
     * @param y
     * @param player
     */
    public void setState(int x, int y, int player) {
        if ((player == 1 && isPlayerOnesTurn) || (player == 2 && !isPlayerOnesTurn)) {
            state.setVal(x, y, player);
            grid[x][y].setText(getPlayerPiece(player));
            checkWin();
            toggleTurn();
            tryComputerTurn();
        }

    }

    /**
     * Toggle the turn.
     */
    private void toggleTurn() {
        isPlayerOnesTurn = !isPlayerOnesTurn;
        if (turnDialogsOn) {
            showTurnDialog(getPlayerTurn());
        }
    }

    /**
     * Try to produce a computer move, if it is the computer's turn.
     */
    private void tryComputerTurn() {
        if (isHumanVsCPU() && getPlayerTurn() == 2) {
            strategy.makeMove();
        }
    }

    /**
     * here is where we can set different strategies according to a name
     *
     * @param strategyName
     */
    public void setStrategy(String strategyName) {
        //strategyName = strategyName.toLowerCase();

        if (strategyName.equals(gameModes[0])) {
            strategy = new Strategy_Human(this);
        } else if (strategyName.equals(gameModes[1])) {
            strategy = new Strategy_CPUEasy(this);
        } else if (strategyName.equals(gameModes[2])) {
            strategy = new Strategy_CPUNovice(this);
        } else if (strategyName.equals(gameModes[3])) {
            strategy = new Strategy_CPUMedium(this);
        } else if (strategyName.equals(gameModes[4])) {
            strategy = new Strategy_CPUIntermediate(this);
        } else if (strategyName.equals(gameModes[5])) {
            strategy = new Strategy_CPUHard(this);
        }
        gameMode = strategyName;
    }

    /**
     * Allow changing of the WinChecker
     */
    private void setWinChecker(int whichone) {
        switch (whichone) {
            case 0:
                winchecker = new BruteForceChecker(state);
                break;
            default:
                winchecker = new BruteForceChecker(state);
                break;
        }
    }

    /**
     * little helper function to return the "piece" of a certain player
     *
     * @param player
     * @return
     */
    private String getPlayerPiece(int player) {
        if (player == 1 || player == 2) {
            return playerPieces[player - 1];
        } else {
            return "";
        }
    }

    /**
     * little helper function to set the "piece" of a certain player
     */
    private void setPlayerPiece(String piece, int player) {
        if (player == 1 || player == 2) {
            playerPieces[player - 1] = piece;
        }
    }

    /**
     * Find out whose turn it is
     *
     * @return 1 or 2, depending on whose turn it is.
     */
    public int getPlayerTurn() {
        if (isPlayerOnesTurn)
            return 1;
        else
            return 2;
    }

    /**
     * Returns what type of gameplay this is.
     * If it is human vs cpu, true is returned.
     * False is returned otherwise.
     *
     * @return
     */
    public boolean isHumanVsCPU() {
        return gameMode != gameModes[0];
    }

    /**
     * Checks for a win using the winchecker.
     */
    private void checkWin() {
        int win = winchecker.check();

        if (win != 0 && win != -1) {
            updateScore(win);
            reset();
        } else if (win == -1) {
            JOptionPane.showMessageDialog(this, "No winner!");
            reset();
        }
    }

    /**
     * Notifies the user of the winner of a game, updates the player's
     * score if applicable.
     *
     * @param winner
     */
    private void updateScore(int winner) {
        // update player's score if vs cpu
        if (isHumanVsCPU() && winner == 1) {
            playerwins++;
            showCelebration(winner, false);
        }
        // else check if we need to add this to the high scores list
        else if (isHumanVsCPU() && winner == 2) {
            showCelebration(winner, true);
            saveScores();
        } else {
            showCelebration(winner, false);
        }
    }

    /**
     * Checks if a player's score is in the high scores list,
     * if it is, the player enters their name and the scores are updated.
     */
    private void saveScores() {
        if (highscoresHandler.isScoreInList(playerwins)) {
            // get the winner's name
            String name = JOptionPane.showInputDialog(this, "What is your name?");
            if (name != null && !name.equals("")) {
                highscoresHandler.add(name, playerwins);
                highscoresHandler.writeFile();
            }
        }
        playerwins = 0;
    }
}
