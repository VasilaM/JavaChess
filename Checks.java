import javax.swing.*;

// Make checks
public class Checks {

    // Check if king is captured (modified implementation of chess)
    public static void isKingCaptured(JButton[][] buttons, int curR, int curC, int tarR, int tarC) {
        String color;
        if (buttons[curR][curC].toString().contains("black"))
            color = "Black";
        else
            color = "White";

        // Option given to start new game if king is captured, current game closes
        if (buttons[tarR][tarC].toString().contains("king")) {
            String[] options = {"Close Game"};
            int result = JOptionPane.showOptionDialog(null, "Congratulations! " + color + " has won!",
                    "Game Over!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options, options[0]);
            if (result == 0) {
                System.exit(1);
            }
        }

    }

    // Check if pawn needs to be promoted
    public static void pawnPromotion(JButton[][] buttons, int curR, int curC, int tarR) {

        if (buttons[curR][curC].toString().contains("pawn")) {
            // Case for black pawn
            if (buttons[curR][curC].toString().contains("black")) {
                Player black = new Player("black", false);
                if (tarR == 0) {

                    // Display dialogue to inquire about promotion. This part of the code was partially informed by
                    // https://stackoverflow.com/questions/1257420/making-a-joptionpane-with-4-options
                    String[] options = {"bishop", "knight", "rook", "queen"};
                    int result = JOptionPane.showOptionDialog(null, "Which piece would you like to promote " +
                                    "your pawn to?", "Pawn Promotion", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                            null, options, options[0]);
                    switch (result) {
                        case 0:
                            buttons[curR][curC].setIcon(black.getBishop());
                            break;
                        case 1:
                            buttons[curR][curC].setIcon(black.getKnight());
                            break;
                        case 2:
                            buttons[curR][curC].setIcon(black.getRook());
                            break;
                        case 3:
                            buttons[curR][curC].setIcon(black.getQueen());
                            break;
                    }

                }
            }

            // Case for white pawn
            if (buttons[curR][curC].toString().contains("white")) {
                Player white = new Player("white", false);
                if (tarR == 7) {

                    // Display dialogue to inquire about promotion
                    String[] options = {"bishop", "knight", "rook", "queen"};
                    int result = JOptionPane.showOptionDialog(null, "Which piece would you like to promote " +
                                    "your pawn to?", "Pawn Promotion", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                            null, options, options[0]);
                    switch (result) {
                        case 0:
                            buttons[curR][curC].setIcon(white.getBishop());
                            break;
                        case 1:
                            buttons[curR][curC].setIcon(white.getKnight());
                            break;
                        case 2:
                            buttons[curR][curC].setIcon(white.getRook());
                            break;
                        case 3:
                            buttons[curR][curC].setIcon(white.getQueen());
                            break;
                    }

                }
            }
        }
    }

    // No main needed. Tested in Game
}
