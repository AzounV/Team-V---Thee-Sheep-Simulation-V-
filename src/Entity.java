import java.awt.*;
public abstract class Entity {
    public Position pos;
    protected Board.Ent entityType;

    public double nutrition = 0.3; //How much this entity fills a creatures hunger when eaten



    public void KillEntity()
    {
        //Death logic
        
        Board.entities.get(entityType.get()).remove(this);
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
