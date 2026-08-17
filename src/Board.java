import java.awt.*;
import java.awt.event.*;

import javax.swing.Timer;

public class Board extends Frame implements ActionListener {
    private int bWidth;
    private int bHeight;
    private Timer timer;

    public Board(int bWidth, int bHeight) {
        this.bWidth = bWidth;
        this.bHeight = bHeight;
        
        init();
    }

    private void init() {
        setSize(bWidth, bHeight);
        setTitle("Sheep Simulation");
        setLocationRelativeTo(null);
        setLayout(null);
        setBackground(Color.BLACK);
        timer = new Timer(10, this);
        timer.start();
    }

    public int c = 0;
    @Override
    public void actionPerformed(ActionEvent e) {
        c++;
        if (c > 255) {
            c = 0;
        }
        setBackground(new Color(c, c, c));
    }
}
