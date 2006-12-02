package testing;

import junit.framework.TestCase;
import game.Scores;

public class TestScores extends TestCase {
    Scores score;

    public void testConstructor() {
        score = new Scores("Yusef", 745);
        assertEquals("Yusef", score.getName());
    }

    public void testSetScore() {
        score = new Scores("Yusef", 745);
        score.setScore(1568);
        assertEquals(1568, score.getScore());
    }

    public void testSetName() {
        score = new Scores("Yusef", 745);
        score.setName("Harvey Dent");
        assertEquals("Harvey Dent", score.getName());
    }

}
