package testing;

import fit.ActionFixture;

public class WinCheckTest extends ActionFixture {
    private game.TicTacToeBoard tttb;
    private game.WinChecker checker;
    private int x;
    private int y;
    private int val;

    public void setUp() {
        tttb = game.TicTacToeBoard.getInstance();
        checker = new game.BruteForceChecker(tttb);
        tttb.reset();
    }

    public void insertx(int a) {
        x = a;
    }

    public void inserty(int a) {
        y = a;
    }

    public void insertv(int a) {
        val = a;
        tttb.setVal(x, y, val);
    }

    public int win() {
        return checker.check();
    }
}
