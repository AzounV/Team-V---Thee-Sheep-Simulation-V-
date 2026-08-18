import java.awt.*;
public abstract class Entity {
    public Position pos;

    public double nutrition = 0.3; //How much this entity fills a creatures hunger when eaten

    public Entity() {
    }

    public void KillEntity()
    {
        //Death logic
    }

    public void drawEntity(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(pos.getX(), pos.getY(), 40,40);
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " " + pos;
    }
}
