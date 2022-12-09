import javax.swing.*;
import java.awt.*;

public class Board {


    public static void main(String[] args) {
        // Create a Frame
        JFrame frame = new JFrame("Chess Board");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create an array of buttons
        

        // create 8 x 8 container
        Container container = frame.getContentPane();
        container.setLayout(new GridLayout(8, 8));

        // add and color buttons as squares on the chess board
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JButton button = new JButton();
                button.setOpaque(true);
                button.setBorderPainted(false);
                button.setBorder(null);
                if ((i + j) % 2 == 0) {
                    button.setBackground(Color.LIGHT_GRAY);
                } else {
                    button.setBackground(Color.DARK_GRAY);
                }
                container.add(button);
            }
        }

        //Display the window.
        frame.setSize(1000, 1000);
        frame.setVisible(true);
    }
}


