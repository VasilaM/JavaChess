import javax.swing.*;
import java.awt.*;

public class Player {
    private Pawn pawn;

    // Pawn class
    private class Pawn {
        private ImageIcon pawn1;

        public Pawn() {
            this.pawn1 = new ImageIcon("chesspieces/white_pawn.svg");
        }
    }

    public Player() {
        this.pawn = new Pawn();
    }


    public static void main(String[] args) {
        // Create a Frame
        JFrame frame = new JFrame("Chess Board");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // array of buttons
        Board board = new Board();
        JButton[][] buttons = board.buttons();

        Player player = new Player();
        Pawn pawn = player.pawn;

        for (int i = 0; i < 8; i++) {
            buttons[1][i].setIcon(pawn.pawn1);
        }

        // create 8 x 8 container
        Container container = frame.getContentPane();
        container.setLayout(new GridLayout(8, 8));

        // add and color buttons as squares on the chess board
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                container.add(buttons[i][j]);
            }
        }

        //Display the window.
        frame.setSize(1000, 1000);
        frame.setVisible(true);
    }
}
