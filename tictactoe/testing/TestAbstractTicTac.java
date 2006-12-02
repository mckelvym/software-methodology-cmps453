package testing;

import game.TicTacToeBoard;
import junit.framework.TestCase;

public class TestAbstractTicTac extends TestCase {
    TicTacToeBoard board;


    public void testSingleton() {
        board = TicTacToeBoard.getInstance();
        board.setVal(0, 0, 1);
        board = TicTacToeBoard.getInstance();
        assertEquals(1, board.getVal(0, 0));
    }

    public void testSetMethod() {
        board = TicTacToeBoard.getInstance();
        board.reset();
        board.setVal(1, 1, 2);
        assertEquals(2, board.getVal(1, 1));
    }

    public void testGetMethod() {
        board = TicTacToeBoard.getInstance();
        board.reset();
        board.setVal(2, 2, 1);
        assertEquals(1, board.getVal(2, 2));
    }

    public void testReset() {
        boolean tester = true;
        board = TicTacToeBoard.getInstance();
        board.setVal(1, 1, 1);
        board.reset();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if ((board.getVal(i, j)) != 0) {
                    tester = false;
                }
            }
        }
        assertTrue(tester);
    }

}
