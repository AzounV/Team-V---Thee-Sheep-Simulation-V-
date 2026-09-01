import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;

public class Board extends Frame implements ActionListener {
    private int bWidth; // Board width
    private int bHeight; // Board height
    private Timer timer;
    public static List<List<Entity>> entities;

    public Board(int bWidth, int bHeight) {
        this.bWidth = bWidth;
        this.bHeight = bHeight;
        
        init();
    }

    //Initialise the board
    private void init() {
        setSize(bWidth, bHeight + 100);
        setTitle("Sheep Simulation");
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setBackground(Color.BLACK);

        entities = new ArrayList<>();
        entities.add(new ArrayList<>());
        entities.add(new ArrayList<>());
        entities.add(new ArrayList<>());
        entities.add(new ArrayList<>());
        entities.get(Ent.sheep.get()).add(new Sheep("Mary", 1, 1000, 5, new Animal[]{null, null}));
        entities.get(Ent.wolf.get()).add(new Wolf());
        for(int i =0; i < 20; i ++)
        {
            entities.get(Ent.flower.get()).add(new Flower());
        }
        entities.get(Ent.flower.get()).add(new Flower());
        entities.get(Ent.grass.get()).add(new Grass());
        for (List<Entity> list : entities) {
            for (Entity ent : list) {
                ent.pos = Position.genRand(bWidth, bHeight, 0, 100, 40);
                System.out.println(ent);
            }
        }

        timer = new Timer(10, this);
        timer.start();
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.gray);
        g.fillRect(0, 0, bWidth, 100);
        for (List<Entity> list : entities) {
            for (Entity ent : list) {
                ent.drawEntity(g);
                if(ent instanceof Animal)
                {
                    Animal animal = (Animal)ent;
                    animal.AnimalBehaviour();
                    if (tic % 100 == 0) {
                        System.out.println(animal + " Hunger " + animal.hunger);
                    }
                }
            }
        }
        drawGrid(g);
        drawCounts(g);
    }

    private void drawGrid(Graphics g) {
        g.setColor(Color.white);
        for (int i = 40; i < bWidth; i += 40) {
            g.drawLine(i, 100, i, bHeight + 100);
        }
        for (int i = 100; i < bHeight + 100; i += 40) {
            g.drawLine(0, i, bWidth, i);
        }
    }

    Font medium = new Font("Helvetica", Font.PLAIN, 16);
    private void drawCounts(Graphics g) {
        g.setFont(medium);
        FontMetrics metrics = g.getFontMetrics();
        int yPos =  15 + ((100 - metrics.getHeight()) / 2) + metrics.getAscent();
        int nextX = bWidth / 16;
        g.drawString("Sheep: " + entities.get(Ent.sheep.get()).size(), nextX, yPos);
        nextX += bWidth / 4;
        g.drawString("Wolves: " + entities.get(Ent.wolf.get()).size(), nextX, yPos);
        nextX += bWidth / 4;
        g.drawString("Flowers: " + entities.get(Ent.flower.get()).size(), nextX, yPos);
        nextX += bWidth / 4;
        g.drawString("Grass: " + entities.get(Ent.grass.get()).size(), nextX, yPos);
    }

    private int tic = 1;
    private int nextSpawn = 300;
    @Override
    // After the timer finishes do this
    public void actionPerformed(ActionEvent e) {
        if (tic >= nextSpawn) {
            Flower newFlower = new Flower();
            newFlower.pos = Position.genRand(bWidth, bHeight, 0, 100, 40);
            entities.get(Ent.flower.get()).add(newFlower);
            System.out.println("New flower added: " + newFlower);
            nextSpawn = tic + (int)(Math.random() * 300 + 200);
        }
        repaint();
        tic++;
    }

    public enum Ent {
        sheep(0), wolf(1), flower(2), grass(3);

        private final int index;
        
        private Ent(int index) {
            this.index = index;
        }

        public int get() {
            return index;
        }
    }
}
