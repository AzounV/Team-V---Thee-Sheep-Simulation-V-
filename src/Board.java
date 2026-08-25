import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;

public class Board extends Frame implements ActionListener {
    private int bWidth; // Board width
    private int bHeight; // Board height
    private Timer timer;
    private List<Entity> entities;

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

        entities = new ArrayList<>();
        entities.add(new Wolf());
        entities.add(new Sheep("Mary", 10, 3, 5, new Animal[]{null, null}));
        entities.add(new Flower());
        for (Entity ent : entities) {
            ent.pos = new Position((int)(Math.random() * (bWidth / 40)) * 40, (int)(Math.random() * (bHeight / 40)) * 40);
            System.out.println(ent);
        }

        timer = new Timer(10, this);
        timer.start();
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Entity ent : entities) {
            ent.drawEntity(g);
        }
    }
    @Override
    // After the timer finishes do this
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
