import java.awt.Color;

public class Flower extends Plant {

    Color fColour;
    public Flower()
    {
        int randomR = ((int) Math.random())*5;
        int randomG = ((int) Math.random())*5;
        int randomB = ((int) Math.random())*5;

        fColour = new Color(randomR, randomG, randomB);
        this.name = "Flower";
    }
}