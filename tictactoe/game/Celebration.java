package game;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Celebration extends JDialog {

    /**
     * Since we are using a serializable object, this needs to be here.
     */
    static final long serialVersionUID = 7526472295622776147L;
    /**
     * These variables deal with the window attributes
     */
    static private int screenWidth;
    static private int screenHeight;
    static private int windowWidth = 500;
    static private int windowHeight = 515;
    static private Dimension dimension;
    private String message;
    private String imagefilename;

    Celebration(JFrame parent, String title, String message, String imagefilename) {
        super(parent, title, true);

        this.message = message;
        this.imagefilename = imagefilename;

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

        setupLayout();
    }

    private void setupLayout() {
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        setLayout(gridbag);

        JLabel msg = new JLabel(message);
        msg.setFont(new Font("Verdana", Font.BOLD, 20));
        msg.setForeground(new Color(0.0f, 0.0f, 0.5f));
        ImageIcon image = new ImageIcon(this.getToolkit().getImage(imagefilename));
        JLabel imagelabel = new JLabel(image);
        JButton ok = new JButton("OK");

        c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridheight = 3;
        c.weightx = 1.0;

        c.weighty = 1.0;
        gridbag.setConstraints(msg, c);
        add(msg);

        c.weighty = 5.0;
        gridbag.setConstraints(imagelabel, c);
        add(imagelabel);

        c.weighty = 1.0;
        gridbag.setConstraints(ok, c);
        add(ok);

        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });
    }

    private void close() {
        dispose();
    }
}
