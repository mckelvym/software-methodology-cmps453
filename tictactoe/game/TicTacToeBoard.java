package game;

/**
 * <h2>Abstract Tic Tac Toe Class</h2>
 * <br><br>
 * The AbstractTicTac class is an abstract class to represent any Tic Tac Toe board.<br>
 * This class uses a 0 to represent an empty space on the board, a 1 to represent one player, and a 2 to represent another player.<br>
 * Any other input will not be accepted.<br>
 * Also, this represents the board with two numbers.  The first number is the row number and the second number is the column number.<br>
 * Effectively, the range of values is from 0 to 2 for each column and each row<br>
 *
 *
 * <pre>     0    1    2
 * 0 [   ][   ][   ]
 * 1 [   ][   ][   ]
 * 2 [   ][   ][   ]
 *
 * </pre>
 */

public class TicTacToeBoard {
    /**
     * The single instance of the Tic Tac Toe class
     */
    private static TicTacToeBoard tictac = null;
    /**
     * The board variable is an int array used to represent a tic tac toe board.
     */
    private int board[];

    /**
     * This is the constructor that initializes the class.  This effectively sets the board to an empty one that has not been played on.
     */
    private TicTacToeBoard() {
        board = new int[9];
        reset();
    }

    /**
     * This function checks to see if the Tic Tac Toe class has been initiated yet.  It returns only a single instance of this class.
     *
     * @return The single instance of this class
     */
    public static TicTacToeBoard getInstance() {
        if (tictac == null) {
            tictac = new TicTacToeBoard();
        }
        return tictac;
    }

    /**
     * This function sets the approriate row and column to the specified value.
     *
     * @param x   The row of the tile to be set.
     * @param y   The column of the tile to be set.
     * @param val The value to be set.
     */
    public void setVal(int x, int y, int val) {
        if ((x >= 0 && x < 3) && (y >= 0 && y < 3)) {
            int relVal = x * 3 + y;
            if (board[relVal] == 0 && (val == 1 || val == 2)) {
                board[relVal] = val;
            }
        }
    }

    /**
     * This function returns the value at the specified tile on the board.
     *
     * @param x The row of the tile to be set.
     * @param y The column of the tile to be set.
     * @return The value at the specified row and column.  Will return 10 if address is out of bounds.
     */
    public int getVal(int x, int y) {
        if ((x >= 0 && x < 3) && (y >= 0 && y < 3)) {
            return board[x * 3 + y];
        } else {
            return 10;
        }
    }

    /**
     * This function resets the board to it's initial state.  This makes the board as if no one has placed a mark on it yet.
     */
    public void reset() {
        for (int i = 0; i < 9; i++) {
            board[i] = 0;
        }
    }
}
