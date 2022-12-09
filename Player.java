import javax.swing.*;
import java.awt.*;

public class Player {
    private Pawn pawn;
    private Rook rook;
    private Bishop bishop;
    private Knight knight;
    private Queen queen;
    private King king;

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

    private class Rook {
        private ImageIcon rook;

        public Rook(String color) {
            if (color.equals("white"))
                this.rook = new ImageIcon("chesspieces/white_rook.png");
            else if (color.equals("black"))
                this.rook = new ImageIcon("chesspieces/black_rook.png");

        }
    }

    private class Bishop {
        private ImageIcon bishop;

        public Bishop(String color) {
            if (color.equals("white"))
                this.bishop = new ImageIcon("chesspieces/white_bishop.png");
            else if (color.equals("black"))
                this.bishop = new ImageIcon("chesspieces/black_bishop.png");

        }
    }

    private class Knight {
        private ImageIcon knight;

        public Knight(String color) {
            if (color.equals("white"))
                this.knight = new ImageIcon("chesspieces/white_knight.png");
            else if (color.equals("black"))
                this.knight = new ImageIcon("chesspieces/black_knight.png");

        }
    }

    private class King {
        private ImageIcon king;

        public King(String color) {
            if (color.equals("white"))
                this.king = new ImageIcon("chesspieces/white_king.png");
            else if (color.equals("black"))
                this.king = new ImageIcon("chesspieces/black_king.png");

        }
    }

    private class Queen {
        private ImageIcon queen;

        public Queen(String color) {
            if (color.equals("white"))
                this.queen = new ImageIcon("chesspieces/white_queen.png");
            else if (color.equals("black"))
                this.queen = new ImageIcon("chesspieces/black_queen.png");

        }
    }

    public Player(String color) {
        this.pawn = new Pawn(color);
        this.knight = new Knight(color);
        this.rook = new Rook(color);
        this.bishop = new Bishop(color);
        this.queen = new Queen(color);
        this.king = new King(color);
    }


    public static void main(String[] args) {
        // Create a Frame
        JFrame frame = new JFrame("Chess Board");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // array of buttons
        Board board = new Board();
        JButton[][] buttons = board.buttons();

        Player white = new Player("white");
        Player black = new Player("black");

        // set up white players
        for (int i = 0; i < 8; i++) {
            buttons[1][i].setIcon(white.pawn.pawn);
        }

        buttons[0][0].setIcon(white.rook.rook);
        buttons[0][7].setIcon(white.rook.rook);

        buttons[0][1].setIcon(white.knight.knight);
        buttons[0][6].setIcon(white.knight.knight);

        buttons[0][2].setIcon(white.bishop.bishop);
        buttons[0][5].setIcon(white.bishop.bishop);

        buttons[0][3].setIcon(white.queen.queen);
        buttons[0][4].setIcon(white.king.king);
        // set up
        for (int i = 0; i < 8; i++) {
            buttons[6][i].setIcon(black.pawn.pawn);
        }

        buttons[7][0].setIcon(black.rook.rook);
        buttons[7][7].setIcon(black.rook.rook);

        buttons[7][1].setIcon(black.knight.knight);
        buttons[7][6].setIcon(black.knight.knight);

        buttons[7][2].setIcon(black.bishop.bishop);
        buttons[7][5].setIcon(black.bishop.bishop);

        buttons[7][3].setIcon(black.queen.queen);
        buttons[7][4].setIcon(black.king.king);

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
