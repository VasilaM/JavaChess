import javax.swing.*;
import java.awt.*;

public class Board {


    public static void main(String[] args) {
        // Create a Frame
        JFrame frame = new JFrame("Chess Board");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create an array of buttons
        JButton[][] buttons = new JButton[8][8];

        // create 8 x 8 container
        Container container = frame.getContentPane();
        container.setLayout(new GridLayout(8, 8));

        // add and color buttons as squares on the chess board
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setOpaque(true);
                buttons[i][j].setBorderPainted(false);
                buttons[i][j].setBorder(null);
                if ((i + j) % 2 == 0) {
                    buttons[i][j].setBackground(Color.DARK_GRAY);
                } else {
                    buttons[i][j].setBackground(Color.LIGHT_GRAY);
                }
                container.add(buttons[i][j]);
            }
        }

        //Display the window.
        frame.setSize(1000, 1000);
        frame.setVisible(true);
    }
}


