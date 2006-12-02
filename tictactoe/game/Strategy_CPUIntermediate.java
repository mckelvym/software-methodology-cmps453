package game;


public class Strategy_CPUIntermediate extends Strategy {


    /**
     * An extension to the computer strategy.
     * This one tries looks at a move in advance before selecting position
     * the middle position first, then corners,
     * then side positions.
     * <p>
     * Mark also added a "delay" while the computer thinks.
     *
     * @author Dallas, Mark
     */
    public int moveNum = 0;
    public int tempX = 1;
    public int tempY = 1;
    public int tablearray[] = new int[9];

    /**
     * Call the super constructor, initializes its own tictactoe window to operate on
     *
     * @param window
     */
    Strategy_CPUIntermediate(TicTacToeWindow window) {
        super(window);
    }

    /**
     * Makes a move based on list of desired moves.
     */
    public void strategyHook() {
        moveList();
        x = tempX;
        y = tempY;
    }

    /**
     * Resets the move number to 0.
     */
    public void cleanupHook() {
        moveNum = 0;
    }

    public void moveList() {
        int square = 0;

        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                tablearray[square] = tictactoewindow.getState(i, j);  // loads the table array with each square's status
                square++;                              // each time moveList() is called
            }
        }

        if (moveNum == 0) {
            if (tablearray[4] == 1) {
                tempX = 0;
                tempY = 0;
            } else {
                tempX = 1;
                tempY = 1;
            }
        }

        if (moveNum == 1) {
            if (tablearray[0] == 1) {
                tempX = 2;
                tempY = 2;
            } else {
                tempX = 0;
                tempY = 0;
            }
        }

        if (moveNum == 2) {
            if (tablearray[8] == 1) {
                tempX = 2;
                tempY = 0;
            } else {
                tempX = 2;
                tempY = 2;
            }
        }

        if (moveNum == 3) {
            if (tablearray[2] == 1) {
                tempX = 0;
                tempY = 2;
            } else {
                tempX = 2;
                tempY = 0;
            }
        }

        if (moveNum == 4) {
            if (tablearray[6] == 1) {
                tempX = 1;
                tempY = 2;
            } else {
                tempX = 0;
                tempY = 2;
            }
        }
        if (moveNum == 5) {
            if (tablearray[7] == 1) {
                tempX = 1;
                tempY = 0;
            } else {
                tempX = 1;
                tempY = 2;
            }
        }
        if (moveNum == 6) {
            if (tablearray[1] == 1) {
                tempX = 0;
                tempY = 1;
            } else {
                tempX = 1;
                tempY = 0;
            }
        }
        if (moveNum == 7) {
            if (tablearray[3] == 1) {
                tempX = 2;
                tempY = 1;
            } else {
                tempX = 0;
                tempY = 1;
            }
        }
        if (moveNum == 8) {
            if (tablearray[5] == 1) {
                tempX = 1;
                tempY = 1;
            } else {
                tempX = 2;
                tempY = 1;
            }
        }

        moveNum++;
    }
}
