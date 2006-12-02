package game;

/**
 * An extension to the computer strategy.
 * This one tries for the middle position first, then corners,
 * then middle positions.
 * I've also added a "delay" while the computer thinks.
 *
 * @author Gavin, Mark
 */
public class Strategy_CPUMedium extends Strategy {

    private int moveNum = 0;
    private MoveListStruct moveList[];
    /**
     * Call the super constructor, initializes its own tictactoe window to operate on
     *
     * @param window
     */
    Strategy_CPUMedium(TicTacToeWindow window) {
        super(window);
        initMoveList();
    }

    /**
     * Makes a move based on list of desired moves.
     */
    public void strategyHook() {
        x = moveList[moveNum].xValue;
        y = moveList[moveNum].yValue;
        moveNum++;
    }

    /**
     * Resets the move number to 0.
     */
    public void cleanupHook() {
        moveNum = 0;
    }

    public void initMoveList() {
        moveList = new MoveListStruct[9];

        for (int i = 0; i < 9; i++) {
            moveList[i] = new MoveListStruct();
        }
        moveList[0].xValue = 1;
        moveList[0].yValue = 1;

        moveList[1].xValue = 0;
        moveList[1].yValue = 0;

        moveList[2].xValue = 2;
        moveList[2].yValue = 0;

        moveList[3].xValue = 0;
        moveList[3].yValue = 2;

        moveList[4].xValue = 2;
        moveList[4].yValue = 2;

        moveList[5].xValue = 1;
        moveList[5].yValue = 0;

        moveList[6].xValue = 0;
        moveList[6].yValue = 2;

        moveList[7].xValue = 1;
        moveList[7].yValue = 2;

        moveList[8].xValue = 2;
        moveList[8].yValue = 2;
    }

    /**
     * this is a class that acts like a struct for the move list
     */
    private class MoveListStruct {
        public int xValue;
        public int yValue;
    }
}
