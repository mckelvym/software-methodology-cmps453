package game;

import java.io.*;

/**
 * Handles the file reading and writing for score keeping
 *
 * @author Mark
 * @author Dallas
 */
public class FileAndScoresHandler {

    private int scoresLength = 10;
    private Scores allscores[] = new Scores[scoresLength];
    private String filename;
    private BufferedReader reader;
    private PrintWriter writer;

    /**
     * Creates a new FileHandler for the specified filename.
     *
     * @param fname
     */
    public FileAndScoresHandler(String fname) {
        filename = fname;
    }

    /**
     * Reads scores from the file and stores them locally.
     */
    public void readFile() {
        String name, score;

        // open file for reading
        try {
            reader = new BufferedReader(new FileReader(filename));
        } catch (Exception e) {
            reader = null;
            System.out.println("File " + filename + " not found.");
            System.out.println("Trying to create it...");
            try {
                writer = new PrintWriter(new FileWriter(filename));
            } catch (IOException another) {
                System.out.println("Unsuccessful at creating file");
            } finally {
                System.out.println("Success!");
            }
            try {
                reader = new BufferedReader(new FileReader(filename));
            } catch (Exception lastone) {
                System.out.println("Giving Up...");
            }
        }

        // read data from the file
        for (int i = 0; i < scoresLength; i++) {
            try {
                // if everything is ok, create a new score and add it to the array
                if (reader != null) {
                    name = reader.readLine();
                    score = reader.readLine();

                    allscores[i] = new Scores(name, Integer.parseInt(score));
                }
                // otherwise just put dummy values there
                else {
                    allscores[i] = new Scores("-", 0);
                }
            } catch (Exception e) {
                System.out.println("File " + filename + " contains format error(s), compensating.");
                allscores[i] = new Scores("-", 0);
            }
        }

        // close file for reading
        try {
            reader.close();
        } catch (IOException e) {
            System.out.println("File " + filename + " couldn'tictactoewindow be closed.");
        }
        sort();
    }

    /**
     * Writes scores to file.
     */
    public void writeFile() {
        // open file for writing
        try {
            writer = new PrintWriter(new FileWriter(filename));
        } catch (IOException e) {
            System.out.println("Couldn't open file for writing.");
            writer = null;
        }

        for (int i = 0; i < scoresLength; i++) {
            try {
                if (writer != null) {
                    writer.println(allscores[i].getName());
                    writer.println(allscores[i].getScore());
                }
            } catch (Exception e) {
                System.out.println("Unable to write to file " + filename);
            }
        }

        // close file for writing
        writer.close();
    }

    /**
     * Sorts the score list
     */
    public void sort() {
        HighScoresBubbleSort.bubbleSort(allscores);
    }

    /**
     * Get all the scores.
     *
     * @return
     */
    public Scores[] getScores() {
        return allscores;
    }

    /**
     * Get how many scores are being stored.
     *
     * @return
     */
    public int getScoresLength() {
        return scoresLength;
    }

    /**
     * Get the list of names of the high scorers.
     *
     * @return
     */
    public String[] getScoreNames() {
        String[] names = new String[scoresLength];
        for (int i = 0; i < scoresLength; i++) {
            names[i] = allscores[i].getName();
        }
        return names;
    }

    /**
     * Get the list of scores of the high scorers.
     *
     * @return
     */
    public int[] getScoreValues() {
        int[] scores = new int[scoresLength];
        for (int i = 0; i < scoresLength; i++) {
            scores[i] = allscores[i].getScore();
        }
        return scores;
    }

    /**
     * Check if a score is in the top list.
     *
     * @return
     */
    public boolean isScoreInList(int score) {
        return (score > allscores[0].getScore());
    }

    /**
     * Add a new high score to the list.
     *
     * @param name
     * @param score
     */
    public void add(String name, int score) {
        Scores newscore = new Scores(name, score);
        if (score > allscores[0].getScore()) {
            allscores[0] = newscore;
            sort();
        }
    }


}
