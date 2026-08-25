import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public abstract class Animal extends Entity{

 

    public String name = "Background Character";

    public double hunger = 1.0; //Range from 1.0 (Creature full), (0.0) Creature dies)

    public double speed = 1.0; //Tiles moved

    public double perception = 2.0; //Range of which creature can see

    public int age = 0; // Increase by 1 every generation

    public int lifeSpan = 5;//Every generation after this, flip coin to see if survives

    public Color colour = Color.white;

    protected static double hungerToReproduce = 0.75; //Will look for a mate if hunger above this level;

    private ArrayList<Animal> children = new ArrayList<Animal>();
    private Animal[] parents = new Animal[2];
    


    public Animal()
    {
        
    }

    public Animal(String name, double speed, double perception, int lifeSpan, Animal[] parents)
    {
        this.name = name;
        this.speed = speed;
        this.perception = perception;
        this.lifeSpan = lifeSpan;
        this.parents = parents;
    }

    public void Move()
    {

    }

    
    public void LookForFood()
    {

    }

    
    public void EatFood(Entity entity)
    {
        hunger += entity.nutrition;
        if(hunger > 1.0)
        {
            hunger = 1.0;
        }

    }

    public void Reproduce() 
    {
        
    }

    @Override
    public void drawEntity(Graphics g) {
        g.setColor(colour);
        g.fillRect(pos.getX(), pos.getY(), 40,40);
    }
}
