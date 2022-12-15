import javax.swing.*;

// Defines player object and wrapper classes for pieces
public class Player {
    private final Pawn pawn; // Pawn object
    private final Rook rook; // Rook object
    private final Bishop bishop; // Bishop object
    private final Knight knight; // Knight object
    private final Queen queen; // Queen object
    private final King king; // King object
    private boolean playerTurn; // Player turn object


    // Pawn class
    // ImageIcon implementation informed by https://docs.oracle.com/javase/7/docs/api/javax/swing/ImageIcon.html
    private static class Pawn {
        private ImageIcon pawn;

        private Pawn(String color) {
            if (color.equals("white"))
                this.pawn = new ImageIcon("chesspieces/white_pawn.png", "white pawn");
            else if (color.equals("black"))
                this.pawn = new ImageIcon("chesspieces/black_pawn.png", "black pawn");

        }
    }

    // Rook class
    private static class Rook {
        private ImageIcon rook;

        private Rook(String color) {
            if (color.equals("white"))
                this.rook = new ImageIcon("chesspieces/white_rook.png", "white rook");
            else if (color.equals("black"))
                this.rook = new ImageIcon("chesspieces/black_rook.png", "black rook");

        }
    }

    // Bishop class
    private static class Bishop {
        private ImageIcon bishop;

        private Bishop(String color) {
            if (color.equals("white"))
                this.bishop = new ImageIcon("chesspieces/white_bishop.png", "white bishop");
            else if (color.equals("black"))
                this.bishop = new ImageIcon("chesspieces/black_bishop.png", "black bishop");
        }
    }

    // Knight class
    private static class Knight {
        private ImageIcon knight;

        private Knight(String color) {
            if (color.equals("white"))
                this.knight = new ImageIcon("chesspieces/white_knight.png", "white knight");
            else if (color.equals("black"))
                this.knight = new ImageIcon("chesspieces/black_knight.png", "black knight");

        }
    }

    // King class
    private static class King {
        ImageIcon king;

        private King(String color) {
            if (color.equals("white"))
                this.king = new ImageIcon("chesspieces/white_king.png", "white king");
            else if (color.equals("black"))
                this.king = new ImageIcon("chesspieces/black_king.png", "black king");

        }
    }

    // Queen class
    private static class Queen {
        ImageIcon queen;

        private Queen(String color) {
            if (color.equals("white"))
                this.queen = new ImageIcon("chesspieces/white_queen.png", "white queen");
            else if (color.equals("black"))
                this.queen = new ImageIcon("chesspieces/black_queen.png", "black queen");

        }
    }

    // Player object
    public Player(String color, boolean playerTurn) {
        this.pawn = new Pawn(color);
        this.knight = new Knight(color);
        this.rook = new Rook(color);
        this.bishop = new Bishop(color);
        this.queen = new Queen(color);
        this.king = new King(color);
        this.playerTurn = playerTurn;
    }

    // Setter method for player's turn
    public void setPlayerTurn(boolean playerTurn) {
        this.playerTurn = playerTurn;
    }

    // Getter method for player's turn
    public boolean getPlayerTurn() {
        return this.playerTurn;
    }

    // Getter method for pawn
    public ImageIcon getPawn() {
        return this.pawn.pawn;
    }

    // Getter method for rook
    public ImageIcon getRook() {
        return this.rook.rook;
    }

    // Getter method for bishop
    public ImageIcon getBishop() {
        return this.bishop.bishop;
    }

    // Getter method for knight
    public ImageIcon getKnight() {
        return this.knight.knight;
    }

    // Getter method for queen
    public ImageIcon getQueen() {
        return this.queen.queen;
    }

    // Getter method for king
    public ImageIcon getKing() {
        return this.king.king;
    }

    // No main method needed in wrapper class. Tested in Game.
}
