package game;

/**
 * Sorts an array of scores.
 *
 * @author Mark
 * @author Dallas
 */
public class HighScoresBubbleSort {

    /**
     * Static method sorts an array of scores.
     *
     * @param x array of scores to be sorted
     */
    public static void bubbleSort(Scores[] x) {
        int n = x.length;
        for (int pass = 1; pass < n; pass++) {  // count how many times

            // This next loop becomes shorter and shorter
            for (int i = 0; i < n - pass; i++) {
                // sort based on score value
                if (x[i].getScore() > x[i + 1].getScore()) {
                    // exchange elements
                    Scores temp = x[i];
                    x[i] = x[i + 1];
                    x[i + 1] = temp;
                }
            }
        }
    }
}
