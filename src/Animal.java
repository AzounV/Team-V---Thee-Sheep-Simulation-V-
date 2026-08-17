public abstract class Animal{

 

    public String name = "Background Character";

    public double hunger = 1.0; //Range from 1.0 (Creature full), (0.0) Creature dies)

    public double speed; 

    public double perception; //Range of which creature can see

    public int age = 0; // Increase by 1 every generation

    public int lifeSpan = 5;//Every generation after this, flip coin to see if survives

    protected static double hungerToReproduce = 0.75; //Will look for a mate if hunger above this level;

    private List<Animal> children = new List<Animal>();
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
    public void LookForFood()
    {

    }

    public void EatFood()
    {

    }
}