import java.awt.*;

public class Wolf extends Animal {
    public Wolf() {
        super("Wolf", 1.5, 3.0, 8, null);
        this.colour = Color.gray;
    }

    @Override
    public void Move() {
        
    }

    @Override
    public void LookForFood() {
        
    }

    /*
    public void EatSheep(Entity entity) {
        if (entity instanceof Sheep) {
            EatFood(entity);
        }
    }
    
    @Override
    public void Reproduce() {
        
    }

    public void Die() {
        KillEntity();
    }
    */
}