import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public abstract class Animal extends Entity{

 

    public String name = "Background Character";

    public double hunger = 0.5; //Range from 1.0 (Creature full), (0.0) Creature dies)

    public double speed = 1.0; //Tiles moved

    public double perception = 2.0; //Range of which creature can see

    public int age = 0; // Increase by 1 every generation

    public int lifeSpan = 5;//Every generation after this, flip coin to see if survives

    public Color colour = Color.white;

    protected static double hungerToReproduce = 0.75; //Will look for a mate if hunger above this level;

    private ArrayList<Animal> children = new ArrayList<Animal>();
    private Animal[] parents = new Animal[2];

    private Entity targetEntity = null;

  
    


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

    //Moves animal towards destination, returns true if it is at the destination already with buffer.
    public boolean Move(Position destination)
    {
        int buffer = 5;
        Position direction = pos.dir(destination);
        if(Math.abs(direction.getX()) <= buffer && Math.abs(direction.getY()) == buffer){return true;}
        if(Math.abs(direction.getX()) > Math.abs(direction.getY()))
        {
            pos.setX((int)(pos.getX() + speed* Math.signum(direction.getX())));
        }else{
            pos.setY((int)(pos.getY() + speed* Math.signum(direction.getY())));
        }
        return false;
    }


    public void AnimalBehaviour()
    {
        hunger -= 0.001;
        if(hunger < hungerToReproduce && targetEntity == null)
        {
            this.targetEntity = LookForFood();
            
        }
        if(hunger < 0)
        {
            hunger = 0;
        }
        System.out.println("Hunger " + hunger);
        
        if(targetEntity != null)
        {
            if(Move(targetEntity.pos))
            {
                EatFood(targetEntity);
            }
        }else{
            //Roam Randomly
            //Thinking about whether or not it should walk to a randomly selected point, or each frame just choose a different direction. OptionA would be prefered. 
        }

        
        
        
    }
    
    public Entity LookForFood()
    {
        //System.out.println("This is the base look for food function, should not be called");
        return null;
    }

    
    public void EatFood(Entity entity)
    {
       
        hunger += entity.nutrition;
        
        if(hunger > 1.0)
        {
            hunger = 1.0;
        }
        System.out.println("Creature eaten worth "+ entity.nutrition + " nutrition. Total hunger now: " + hunger);
        entity.KillEntity();
        targetEntity = null;

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
