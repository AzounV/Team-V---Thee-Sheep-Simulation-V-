import java.awt.*;
import java.awt.event.*;
public class Main {
    public static void main(String [] args) {
        Frame frame = new Frame();
        System.out.println("Hello, world! but sheep");

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

        frame.setSize(640, 480);
        frame.setTitle("Sheep Simulation");
        frame.setBackground(Color.BLACK);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
