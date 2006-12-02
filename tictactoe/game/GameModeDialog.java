package game;

import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;

/**
 * This is a class to allow the user to choose what type of gameplay they want.
 *
 * @author Mark
 */
public class GameModeDialog extends JDialog {

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
    static private int windowHeight = 200;
    static private Dimension dimension;
    /**
     * A list of options for the user to choose from.
     */
    private String[] myoptions;
    /**
     * A gui list of all the options
     */
    private JList list;
    /**
     * Parent window, so this dialog can update the gameMode when it closes.
     */
    private TicTacToeWindow myparent;

    GameModeDialog(TicTacToeWindow parent, String title, String[] options) {
        super(parent, title, true);

        myparent = parent;
        myoptions = options;

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

        // make the window always on top? (throws an exception that we need to catch)
        try {
            this.setAlwaysOnTop(false);
        } catch (Exception e) {
            // don'tictactoewindow do anything
        }

        String[] newoptions = new String[myoptions.length];
        for (int i = 0; i < myoptions.length; i++) {
            newoptions[i] = "vs " + myoptions[i];
        }
        list = new JList(newoptions);

        this.getContentPane().add(list);

        list.addMouseListener(new MouseListener() {
            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == list) {
                    myparent.setStrategy(myoptions[list.getSelectedIndex()]);
                    closeMe();
                }
            }

            public void mouseExited(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }
        });

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                myparent.close();
            }
        });
    }

    private void closeMe() {
        myparent.setVisible(true);
        this.dispose();
    }
}
