import java.util.ArrayList;
public class Sheep extends Animal{



    public Sheep(String name, float speed, float perception, int lifeSpan, Animal[] parents)
    {
        super(name, speed, perception, lifeSpan, parents);
    }   

    @Override
    public void LookForFood()
    {
        //tempo just to allow for logic development. Replace with proper entity database at some point
        ArrayList<Entity> allFlowers = new ArrayList<Entity>();

        Entity closest = null;
        double closestDist = 99999;
        for (Entity entity : allFlowers) {

            double dist = this.pos.dist(entity.pos) ;
            if(dist < this.perception && dist < closestDist)
            {
                closest = entity;
                closestDist = dist;
            }
        }
        
        if(closest != null)
        {
            //Move to flower
        }else{
            //roam randomly 
        }


        
    }

    @Override
    public void Move()
    {

    }
}