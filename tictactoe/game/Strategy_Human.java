package game;

/**
 * Dummy class used as a filler for a Human Player.
 * Will not actually have its own strategy.
 * This class may be eliminated later, but not sure yet.
 *
 * @author Mark
 */
public class Strategy_Human extends Strategy {

    /**
     * Initializes its tictactoe window, but this class doesn'tictactoewindow do anything with it.
     *
     * @param window
     */
    Strategy_Human(TicTacToeWindow window) {
        super(window);
    }

    /**
     * Does nothing for now.
     */
    public void strategyHook() {
        // for now lets do nothing, this class is just a filler
        x = -1;
        y = -1;
    }

    /**
     * Does nothing.
     */
    public void cleanupHook() {
        // nothing
    }
}
