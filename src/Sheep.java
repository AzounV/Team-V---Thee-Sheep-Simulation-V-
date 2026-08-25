import java.util.ArrayList;
public class Sheep extends Animal{

    Flower targetFlower = null;

    public Sheep(String name, float speed, float perception, int lifeSpan, Animal[] parents)
    {
        super(name, speed, perception, lifeSpan, parents);
    }   

    @Override
    public Entity LookForFood()
    {
        //tempo just to allow for logic development. Replace with proper entity database at some point
        ArrayList<Flower> allFlowers = new ArrayList<Flower>();

        Flower closest = null;
        double closestDist = 99999;
        for (Flower flower : allFlowers) {

            double dist = this.pos.dist(flower.pos) ;
            if(dist < this.perception && dist < closestDist)
            {
                closest = flower;
                closestDist = dist;
            }
        }
        
        return closest;


        
    }


}