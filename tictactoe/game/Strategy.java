package game;

// Class    : CMPS 453
// Section  : 001

/**
 * Base abstract class for the computer playing strategy.
 * Provides a way to check if a move is valid and also provides a way to make a new move
 */
public abstract class Strategy {

    /**
     * This is the location that will be played.
     */
    protected int x = -1, y = -1;
    /**
     * Protected data member that methods can operate on
     */
    protected TicTacToeWindow tictactoewindow = null;
    /**
     * Max delay time
     */
    private int maxtime = 2000;
    /**
     * Min delay time
     */
    private int mintime = 100;

    /**
     * Children implementing this class should call the "super"
     * constructor so that methods can operate on a TicTacToeWindow
     *
     * @param window
     */
    public Strategy(TicTacToeWindow window) {
        tictactoewindow = window;
    }

    /**
     * Provides a way to see if a position on the board is available for a "move"
     *
     * @param x - a position on the board horizontally, a location from 1 to 3 (inclusive)
     * @param y - a position on the board vertically, a location from 1 to 3 (inclusive)
     * @return
     */
    public boolean isValidMove(int x, int y) {
        if (x >= 1 && x <= 3 && y >= 1 && y <= 3)
            return tictactoewindow.getState(x - 1, y - 1) == 0;
        else return false;
    }

    /**
     * Each algorithm will have its own way to "make a move"
     * and also used "isValidMove" to check whether the position is valid
     */
    public void makeMove() {
        // calculate a delay for this algorithm to "calculate" a new move.
        int delay = (new java.util.Random()).nextInt(maxtime - mintime) + mintime;
        // variable to loop until a move has been made
        boolean moveMade = false;


        System.out.println("Calculating move...");
        while (!moveMade) {
            // the method that is implementing this should set values to x,y
            strategyHook();
            if (isValidMove(x + 1, y + 1)) {
                // tell the progress window to stall for us.
                tictactoewindow.showProgress(delay);
                // update our move.
                tictactoewindow.setState(x, y, 2);
                moveMade = true;
            }
        }
        cleanupHook();
        System.out.println("Done!");

    }

    /**
     * This is a hook for the makeMove method.
     * The method that is implementing this should set "x" and "y"
     */
    public abstract void strategyHook();

    /**
     * This is also a hook for the makeMove method
     * This is for any other tidy work that needs to be done.
     */
    public abstract void cleanupHook();

}
