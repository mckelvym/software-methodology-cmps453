package testing;

import game.FileAndScoresHandler;
import junit.framework.TestCase;

public class TestFileScoreHandler extends TestCase {
    FileAndScoresHandler handler;

    public void testGetNames() {
        handler = new FileAndScoresHandler("files/testscores");
        handler.readFile();
        assertEquals(handler.getScoreNames()[0], "gongonzabar");
    }

    public void testGetValues() {
        handler = new FileAndScoresHandler("files/testscores");
        handler.readFile();
        assertEquals(handler.getScoreValues()[0], 5);
    }

    public void testGetScores() {
        handler = new FileAndScoresHandler("files/testscores");
        handler.readFile();
        assertEquals(handler.getScores()[7].getName(), "Zelda");
    }

    public void testInList() {
        handler = new FileAndScoresHandler("files/testscores");
        handler.readFile();
        assertTrue(handler.isScoreInList(1986));
    }

    public void testNotInList() {
        handler = new FileAndScoresHandler("files/testscores");
        handler.readFile();
        assertFalse(handler.isScoreInList(-314159));
    }

    public void testSort() {
        handler = new FileAndScoresHandler("files/testscores");
        handler.readFile();
        handler.sort();
        assertEquals(handler.getScoreNames()[9], "Zelda");
    }

    public void testAdd() {
        handler = new FileAndScoresHandler("files/testscores");
        handler.readFile();
        handler.sort();
        handler.add("Bilbo Baggins", 314159);
        assertEquals(handler.getScoreNames()[9], "Bilbo Baggins");
    }

    public void testAddButNot() {
        handler = new FileAndScoresHandler("files/testscores");
        handler.readFile();
        handler.sort();
        handler.add("Bilbo Baggins", -314159);
        assertEquals(handler.getScoreValues()[0], 1);
    }

    public void testScoresLength() {
        handler = new FileAndScoresHandler("files/testscores");
        handler.readFile();
        assertEquals(10, handler.getScoresLength());
    }

    public void testSameScoresLength() {
        handler = new FileAndScoresHandler("files/testscores");
        handler.readFile();
        handler.add("Billy Corgan", 256);
        assertEquals(10, handler.getScoresLength());
    }
}
