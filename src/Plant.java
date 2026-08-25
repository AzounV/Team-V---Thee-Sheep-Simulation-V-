
import java.awt.Color;



public abstract class Plant extends Entity {
    
    public String name = "Plant";

    public Color pColour = Color.orange; 
    


    public Plant(String name, Color colour)
    {
        this.name = name;
        this.pColour = colour;

    }


}