package game;

/**
 * "Interface" for a WinChecker. Children should implement this, so that you can have
 * different types of win checkers, such as "BruteForceChecker", "SmartChecker", etc.
 *
 * @author Mark
 */
public abstract class WinChecker {
    /**
     * Local variable for methods to access.
     */
    protected TicTacToeBoard tictactoewindow;

    /**
     * Children should call "super" to initialize private TicTacToeWindow
     *
     * @param board The board that is being checked for wins
     */
    public WinChecker(TicTacToeBoard board) {
        tictactoewindow = board;
    }

    /**
     * Checks for a win condition.
     * This method should be implemented in child classes, and should
     * call the methods below (getValue(), reset()) which will be passed onto
     * the TicTacToeWindow to handle.
     */
    public abstract int check();
}
