import java.awt.*;
import java.util.List;

public class Wolf extends Animal {
    public Wolf() {
        super("Wolf", 1.5, 3.0, 8, null);
        this.colour = Color.gray;
    }
    public Wolf(String name, float speed, float perception, int lifeSpan, Animal[] parents)
    {
        super(name, speed, perception, lifeSpan, parents);
        this.colour = Color.gray;
        entityType = Board.Ent.wolf;

    }  

    @Override
    public Entity LookForFood() {
        List<Entity> allSheep = Board.entities.get(Board.Ent.sheep.get());

        Entity closest = null;

        double closestDist = 99999;
        for (Entity sheep : allSheep) {

            double dist = this.pos.dist(sheep.pos) ;
            if(dist < this.perception && dist < closestDist)
            {
                closest = sheep;
                closestDist = dist;
            }
        }

        if(closest != null)
        {
            // System.out.println("Closest sheep @ " + closest.pos);
        }else{
            // System.out.println("No sheep in range");
        }
        return closest;
    }

    
    public void EatSheep(Entity entity) {
        if (entity instanceof Sheep) {
            EatFood(entity);
        }
    }
    
    @Override
    public void Reproduce() {
        
    }
/*
    public void Die() {
        KillEntity();
    }
*/

}
