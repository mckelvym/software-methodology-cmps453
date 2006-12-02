// $Id: HighScoresWindow.java,v 1.1.1.1 2008-02-24 02:15:54 mark Exp $
package game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class shows the high scores list.
 *
 * @author Mark
 */
public class HighScoresWindow extends JDialog {

    /**
     * Since we are using a serializable object, this needs to be here.
     */
    static final long serialVersionUID = 7526472295622776147L;
    /**
     * These variables deal with the window attributes
     */
    static private int screenWidth;
    static private int screenHeight;
    static private int windowWidth = 200;
    static private int windowHeight = 220;
    static private Dimension dimension;

    HighScoresWindow(JFrame parent, String[] names, int[] scores) {
        super(parent, "HIGHEST SCORES", true);

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

        if (names.length == scores.length) {
            String[] list = new String[names.length];
            for (int i = 0; i < list.length; i++) {
                list[i] = scores[list.length - i - 1] + " --- " + names[list.length - i - 1];
            }
            JList jList = new JList(list);
            jList.setFont(new Font("Verdana", Font.BOLD, 12));
            jList.setBackground(Color.BLACK);
            jList.setForeground(Color.BLUE);

            this.getContentPane().add(jList);

            // currently there is no mouse support
            jList.addMouseListener(new MouseListener() {
                public void mousePressed(MouseEvent e) {
                }

                public void mouseReleased(MouseEvent e) {
                }

                public void mouseClicked(MouseEvent e) {
                }

                public void mouseExited(MouseEvent e) {
                }

                public void mouseEntered(MouseEvent e) {
                }
            });
        }
    }
}
