import javax.swing.*;
import java.awt.*;

public class Player {
    private Pawn whitePawn;
    private Pawn blackPawn;

    // Pawn class
    private class Pawn {
        private ImageIcon pawn;

        public Pawn(String color) {
            if (color.equals("white"))
                this.pawn = new ImageIcon("chesspieces/white_pawn.png");
            else if (color.equals("black"))
                this.pawn = new ImageIcon("chesspieces/black_pawn.png");

        }
    }

    public Player() {
        this.whitePawn = new Pawn("white");
        this.blackPawn = new Pawn("black");
    }


    public static void main(String[] args) {
        // Create a Frame
        JFrame frame = new JFrame("Chess Board");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // array of buttons
        Board board = new Board();
        JButton[][] buttons = board.buttons();

        Player player = new Player();
        Pawn blackPawn1 = player.blackPawn;
        Pawn whitePawn1 = player.whitePawn;

        for (int i = 0; i < 8; i++) {
            buttons[6][i].setIcon(blackPawn1.pawn);
        }
        for (int i = 0; i < 8; i++) {
            buttons[1][i].setIcon(whitePawn1.pawn);
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
