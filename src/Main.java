import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Main extends JFrame{
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
    }
    public static void main(String [] args) {
        Frame main = new Main();
        main.setVisible(true);
        System.out.println("Hello, world! but sheep");
    }
}
