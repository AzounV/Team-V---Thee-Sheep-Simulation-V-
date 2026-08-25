
import java.awt.Color;
import java.awt.Graphics;



public class Flower extends Plant {

    Color fColour;
    public Flower()
    {
        int randomR = ((int) Math.random())*5;
        int randomG = ((int) Math.random())*5;
        int randomB = ((int) Math.random())*5;

        fColour = new Color(randomR, randomG, randomB);
        super("Flower");
    }

    @Override
    public void drawEntity(Graphics g) {
        g.setColor(fColour);
        g.fillOval(pos.getX(), pos.getY(), 40,40);
    }
}