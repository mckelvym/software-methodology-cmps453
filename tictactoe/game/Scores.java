
package game;

/**
 * Keeps track of user scores for a high scores list.
 *
 * @author Mark
 */
public class Scores {

    /**
     * Data members for pseudo-struct Scores
     */
    private String name = null; // <- holds name of player (String)
    private int score;          // <- holds score high score of player (int)

    /**
     * Constructor for Scores class sets data members equal to appropriate parameters
     *
     * @param aName
     * @param aScore
     */
    public Scores(String aName, int aScore) {
        name = aName;
        score = aScore;
    }

    /**
     * Function group to return values of a particular High Scores
     */
    public String getName() {
        return name;             // Name of High Scorer (Sting)
    }

    /**
     * Function group to set new  values of a particular High Scores
     */
    public void setName(String aName) {    // Name of High Scorer
        name = aName;
    }

    public int getScore() {         // Score of High Scorer (int)
        return score;
    }

    public void setScore(int aScore) {   // Score of High Scorer
        score = aScore;
    }
}
