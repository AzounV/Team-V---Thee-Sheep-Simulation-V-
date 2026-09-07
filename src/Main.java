import java.awt.*;
import java.awt.event.*;
public class Main extends Frame{
    public Main() {
        init();
    }
    public void init() {
        add(new Board(640, 480));
        setResizable(false);
        setTitle("Sheep Simulation");
        pack();
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        setVisible(true);
    }
    public static void main(String [] args) {
        Frame main = new Main();
        System.out.println("Hello, world! but sheep");
    }
}
