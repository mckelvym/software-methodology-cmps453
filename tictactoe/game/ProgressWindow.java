package game;

import java.awt.Dimension;
import javax.swing.*;

/**
 * Displays the progress of the computer's calculation.
 *
 * @author Mark
 */
public class ProgressWindow extends JDialog implements Runnable {

    /**
     * Since we are using a serializable object, this needs to be here.
     */
    static final long serialVersionUID = 7526472295622776147L;
    /**
     * These variables deal with the window attributes
     */
    static private int screenWidth;
    static private int screenHeight;
    static private int windowWidth = 145;
    static private int windowHeight = 50;
    static private Dimension dimension;
    /**
     * Sleep time for the current thread.
     */
    private int sleepLength = 10;
    /**
     * Current value of the progress bar
     */
    private int value = 0;
    /**
     * Maximum value of the progress bar
     */
    private int maxValue = 0;
    /**
     * Progress bar to show the current progress of the operation.
     */
    private JProgressBar progressBar;

    public ProgressWindow(JFrame parent, String title, int lengthOfTask) {
        super(parent, title, true);

        maxValue = lengthOfTask;
        // gets the dimensions of the current screen

        // grab a dimension object
        dimension = this.getToolkit().getScreenSize();

        // find the screen width and the screen height
        screenWidth = (int) (dimension.getWidth());
        screenHeight = (int) (dimension.getHeight());

        // set the size of this window proportional to the screen size
        this.setSize(windowWidth, windowHeight);

        // centers the window on the screen
        this.setLocation((int) ((screenWidth - windowWidth) / 2), (int) ((screenHeight - windowHeight) / 2));

        // allow resize of the window?
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        // create a new progress bar with the specified maximum value.
        addProgressBar(maxValue);

        // start a new thread so that this progress bar can continuously update itself
        new Thread(this).start();
    }

    /**
     * Creates a new progress bar, gives it an initial value of 0 and
     * a specified maxValue, adds the progress bar to this dialog.
     *
     * @param maxValue
     */
    private void addProgressBar(int maxValue) {
        progressBar = new JProgressBar();
        progressBar.setIndeterminate(false);
        progressBar.setBorderPainted(true);
        progressBar.setMaximum(maxValue);
        progressBar.setValue(value);
        JPanel panel = new JPanel();
        panel.add(progressBar);
        this.add(panel);
    }

    /**
     * This is for the thread to update itself over some interval
     */
    public void run() {
        // counts from the smallest value to the highest value
        while (value < (maxValue - 1)) {
            try {
                // sleeps for a certain amount of time before updating again
                Thread.sleep(sleepLength);
            } catch (InterruptedException ie) {
                // do nothing
            }
            // increments its current value by the sleep length.
            value += sleepLength;
            // update the progress bar to show how much we've completed
            progressBar.setValue(value);
        }
        // dispose of this dialog when the operation is complete
        close();
    }

    /**
     * Disposes of this dialog.
     */
    private void close() {
        dispose();
    }
}
