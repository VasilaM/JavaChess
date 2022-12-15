import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// Create chess board
public class Board {
    // Construct buttons array
    public JButton[][] buttons() {
        JButton[][] buttons = new JButton[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setOpaque(true);
                buttons[i][j].setBorderPainted(false);
                buttons[i][j].setBorder(null);
                int finalI = i;
                int finalJ = j;
                buttons[i][j].addActionListener(e -> buttons[finalI][finalJ].setSelected(true));
                if ((i + j) % 2 == 0) {
                    buttons[i][j].setBackground(Color.LIGHT_GRAY);
                } else {
                    buttons[i][j].setBackground(Color.WHITE);
                }
            }
        }

        return buttons;
    }


    // Use to test
    public static void main(String[] args) {
        // Create a Frame
        JFrame frame = new JFrame("Chess Board");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener listener = e -> {
            if (e.getSource() instanceof JButton) {
                System.out.println("something");
            }
        };

        // Create an array of buttons
        Board board = new Board();
        JButton[][] buttons = board.buttons();

        // create 8 x 8 container
        Container container = frame.getContentPane();
        container.setLayout(new GridLayout(8, 8));

        // add and color buttons as squares on the chess board
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                buttons[i][j].addActionListener(listener);
                container.add(buttons[i][j]);
            }
        }

        //Display the window.
        frame.setSize(1000, 1000);
        frame.setVisible(true);
    }
}


