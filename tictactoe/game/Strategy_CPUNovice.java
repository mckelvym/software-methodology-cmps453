package game;

//import game.Strategy_CPUMedium.MoveListStruct;

public class Strategy_CPUNovice extends Strategy {

    /**
     * An extension to the computer strategy.
     * This one tries for the side positions first, then center,
     * then middle corners.
     * Mark also added a "delay" while the computer thinks.
     *
     * @author Dallas, Mark
     */
    private int moveNum = 0;
    private MoveListStruct moveList[];
    /**
     * Call the super constructor, initializes its own tictactoe window to operate on
     *
     * @param window
     */
    Strategy_CPUNovice(TicTacToeWindow window) {
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
        moveList[0].yValue = 0;

        moveList[1].xValue = 0;
        moveList[1].yValue = 1;

        moveList[2].xValue = 1;
        moveList[2].yValue = 1;

        moveList[3].xValue = 2;
        moveList[3].yValue = 1;

        moveList[4].xValue = 1;
        moveList[4].yValue = 1;

        moveList[5].xValue = 0;
        moveList[5].yValue = 2;

        moveList[6].xValue = 2;
        moveList[6].yValue = 0;

        moveList[7].xValue = 2;
        moveList[7].yValue = 2;

        moveList[8].xValue = 0;
        moveList[8].yValue = 0;

    }

    /**
     * this is a class that acts like a struct for the move list
     */
    private class MoveListStruct {
        public int xValue;
        public int yValue;
    }
}
