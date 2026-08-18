import java.awt.*;
public abstract class Entity extends Panel {
    public Position pos;

    public double nutrition = 0.3; //How much this entity fills a creatures hunger when eaten


    public void KillEntity()
    {
        //Death logic
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(pos.getX(), pos.getY(), 10, 10);
    }

    public void drawEntity() {
        repaint();
    }
}
