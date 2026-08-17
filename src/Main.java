import java.awt.*;
import java.awt.event.*;
public class Main {
    public static void main(String [] args) {
        Frame board = new Board(640, 480);
        System.out.println("Hello, world! but sheep");

        board.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

        board.setVisible(true);
    }
}
