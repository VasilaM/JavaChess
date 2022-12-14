import javax.swing.*;

public class Player {
    private Pawn pawn;
    private Rook rook;
    private Bishop bishop;
    private Knight knight;
    private Queen queen;
    private King king;
    private JButton[][] buttons;
    private String color;
    private boolean playerTurn;


    // Pawn class
    private class Pawn {
        private ImageIcon pawn;

        private Pawn(String color) {
            if (color.equals("white"))
                this.pawn = new ImageIcon("chesspieces/white_pawn.png", "white pawn");
            else if (color.equals("black"))
                this.pawn = new ImageIcon("chesspieces/black_pawn.png", "black pawn");

        }
    }

    private class Rook {
        private ImageIcon rook;

        private Rook(String color) {
            if (color.equals("white"))
                this.rook = new ImageIcon("chesspieces/white_rook.png", "white rook");
            else if (color.equals("black"))
                this.rook = new ImageIcon("chesspieces/black_rook.png", "black rook");

        }
    }

    private class Bishop {
        private ImageIcon bishop;

        private Bishop(String color) {
            if (color.equals("white"))
                this.bishop = new ImageIcon("chesspieces/white_bishop.png", "white bishop");
            else if (color.equals("black"))
                this.bishop = new ImageIcon("chesspieces/black_bishop.png", "black bishop");
        }
    }

    private class Knight {
        private ImageIcon knight;

        private Knight(String color) {
            if (color.equals("white"))
                this.knight = new ImageIcon("chesspieces/white_knight.png", "white knight");
            else if (color.equals("black"))
                this.knight = new ImageIcon("chesspieces/black_knight.png", "black knight");

        }
    }

    private class King {
        ImageIcon king;

        private King(String color) {
            if (color.equals("white"))
                this.king = new ImageIcon("chesspieces/white_king.png", "white king");
            else if (color.equals("black"))
                this.king = new ImageIcon("chesspieces/black_king.png", "black king");

        }
    }

    private class Queen {
        ImageIcon queen;

        private Queen(String color) {
            if (color.equals("white"))
                this.queen = new ImageIcon("chesspieces/white_queen.png", "white queen");
            else if (color.equals("black"))
                this.queen = new ImageIcon("chesspieces/black_queen.png", "black queen");

        }
    }

    public Player(String color, boolean playerTurn) {
        this.pawn = new Pawn(color);
        this.knight = new Knight(color);
        this.rook = new Rook(color);
        this.bishop = new Bishop(color);
        this.queen = new Queen(color);
        this.king = new King(color);
        this.playerTurn = playerTurn;
        this.color = color;
    }

    public void setPlayerTurn(boolean playerTurn) {
        this.playerTurn = playerTurn;
    }

    public boolean getPlayerTurn() {
        return this.playerTurn;
    }

    public ImageIcon getPawn() {
        return this.pawn.pawn;
    }

    public ImageIcon getRook() {
        return this.rook.rook;
    }

    public ImageIcon getBishop() {
        return this.bishop.bishop;
    }

    public ImageIcon getKnight() {
        return this.knight.knight;
    }

    public ImageIcon getQueen() {
        return this.queen.queen;
    }

    public ImageIcon getKing() {
        return this.king.king;
    }


    public static void main(String[] args) {
    }
}
