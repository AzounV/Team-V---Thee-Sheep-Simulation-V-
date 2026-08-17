import java.awt.*;
import java.awt.event.*;

import javax.swing.Timer;

public class Board extends Frame implements ActionListener {
    private int bWidth; // Board width
    private int bHeight; // Board height
    private Timer timer;

    public Board(int bWidth, int bHeight) {
        this.bWidth = bWidth;
        this.bHeight = bHeight;
        
        init();
    }

    //Initialise the board
    private void init() {
        setSize(bWidth, bHeight);
        setTitle("Sheep Simulation");
        setLocationRelativeTo(null);
        setLayout(null);
        setBackground(Color.BLACK);
        timer = new Timer(10, this);
        timer.start();
    }

    private int c = 0;
    private boolean reverse = false;
    @Override
    // After the timer finishes do this
    public void actionPerformed(ActionEvent e) {
        if (!reverse) {
            c++;
        }
        else { 
            c--;
        }
        if (c >= 255 || c <= 0) {
            reverse = !reverse;
        }
        setBackground(new Color(c, c, c));
    }
}
