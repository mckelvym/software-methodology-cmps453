package game;

/**
 * <h2> Brute Force Win Checker</h2>
 * <br>
 * The Brute Force Win Checker checks every possible combination of a tic tac toe board to see if there is a win.
 */
public class BruteForceChecker extends WinChecker {
    public BruteForceChecker(TicTacToeBoard tictactoeboard) {
        super(tictactoeboard);
    }

    public int check() {
        int whowon = 0;
        int tempwin;
        int i, j;

        //Test rows
        for (i = 0; i < 3; i++) {
            tempwin = tictactoewindow.getVal(i, 0);
            if ((tictactoewindow.getVal(i, 1) == tempwin) && (tictactoewindow.getVal(i, 2) == tempwin)) {
                whowon = tempwin;
            }
        }

        //Test Columns
        if (whowon == 0) {
            for (j = 0; j < 3; j++) {
                tempwin = tictactoewindow.getVal(0, j);
                if ((tictactoewindow.getVal(1, j) == tempwin) && (tictactoewindow.getVal(2, j) == tempwin)) {
                    whowon = tempwin;
                }
            }
        }

        //Test One Diagonal
        if (whowon == 0) {
            tempwin = tictactoewindow.getVal(0, 0);
            if ((tictactoewindow.getVal(1, 1) == tempwin) && (tictactoewindow.getVal(2, 2) == tempwin)) {
                whowon = tempwin;
            }
        }

        //Test Other Diagonal
        if (whowon == 0) {
            tempwin = tictactoewindow.getVal(0, 2);
            if ((tictactoewindow.getVal(1, 1) == tempwin) && (tictactoewindow.getVal(2, 0) == tempwin)) {
                whowon = tempwin;
            }
        }

        //Test if the board is full
        if (whowon == 0) {
            boolean boardfull = true;
            for (i = 0; i < 3; i++) {
                for (j = 0; j < 3; j++) {
                    if (tictactoewindow.getVal(i, j) == 0)
                        boardfull = false;
                }
            }
            if (boardfull)
                whowon = -1;
        }

        return whowon;
    }
}
