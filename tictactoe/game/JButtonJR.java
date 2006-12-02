package game;

import java.awt.event.*;
import javax.swing.*;

public class JButtonJR extends JButton implements ActionListener {

    /**
     * Since we are using a serializable object, this needs to be here.
     */
    static final long serialVersionUID = 7526472295622776147L;
    JButtonJR me;
    /**
     * Keep track of which button this is.
     */
    private int x, y;
    /**
     * So we know who our parent is.
     */
    private TicTacToeWindow tictactoewindow;

    JButtonJR(TicTacToeWindow parent, int x, int y) {
        tictactoewindow = parent;
        this.x = x;
        this.y = y;
        this.addActionListener(this);
        me = this;
    }

    /**
     * Handles what action to do whenever an ActionEvent occurs on this piece.
     */
    public void actionPerformed(ActionEvent e) {
        if (me.getText().equals("")) {
            if (tictactoewindow.getPlayerTurn() == 1) {
                tictactoewindow.setState(x, y, 1);
            } else if (tictactoewindow.getPlayerTurn() == 2 && !tictactoewindow.isHumanVsCPU()) {
                tictactoewindow.setState(x, y, 2);
            }
        }
    }

    public void reset() {
        setText("");
    }


}
