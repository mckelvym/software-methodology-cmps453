package testing;

import game.Scores;
import game.HighScoresBubbleSort;
import fit.ActionFixture;

public class TestScoreSort extends ActionFixture {
    Scores scores[];
    int i = 0;
    String scorename;
    int scorevalue;

    public void setUp() {
        scores = new Scores[11];
    }

    public void name(String inpname) {
        scorename = inpname;
    }

    public void score(int inpscore) {
        scorevalue = inpscore;
        scores[i] = new Scores(scorename, scorevalue);
        i++;
    }

    public void sort() {
        HighScoresBubbleSort.bubbleSort(scores);
    }

    public String onTop() {
        return scores[0].getName();
    }

    public String onBottom() {
        return scores[i - 1].getName();
    }

}
