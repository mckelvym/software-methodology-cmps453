package game;

/**
 * An extension to the computer strategy.
 * This one just picks a random location and plays it.
 * I've also added a "delay" while the computer thinks.
 *
 * @author Mark
 */
public class Strategy_CPUEasy extends Strategy {

    /**
     * Call the super constructor, initializes its own tictactoe window to operate on
     *
     * @param window
     */
    Strategy_CPUEasy(TicTacToeWindow window) {
        super(window);
    }

    /**
     * Makes a random move on the playing board in a location that is available.
     */
    public void strategyHook() {
        java.util.Random rand = new java.util.Random();
        x = rand.nextInt(3);
        y = rand.nextInt(3);
    }

    /**
     * Does nothing.
     */
    public void cleanupHook() {
        // nothing
    }
}
