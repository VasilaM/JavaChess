import javax.swing.*;

public class Checks {
//    JButton[][] buttons;
//
//    public Checks(JButton[][] buttons) {
//        this.buttons = new JButton[8][8];
//
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                this.buttons[i][j] = buttons[i][j];
//            }
//        }
//    }


    public static void pawnPromotion(JButton[][] buttons, int tarR, int tarC) {
        if (buttons[tarR][tarC].toString().contains("pawn")) {
            if (buttons[tarR][tarC].toString().contains("black")) {
                Player black = new Player("black", false);
                if (tarR == 0) {
                    String[] options = {"bishop", "knight", "rook", "queen"};
                    int result = JOptionPane.showOptionDialog(null, "Which piece would you like to promote " +
                                    "your pawn to?", "Pawn Promotion", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                            null, options, options[0]);
                    switch (result) {
                        case 0:
                            buttons[tarR][tarC].setIcon(black.getBishop());
                            break;
                        case 1:
                            buttons[tarR][tarC].setIcon(black.getKnight());
                            break;
                        case 2:
                            buttons[tarR][tarC].setIcon(black.getRook());
                            break;
                        case 3:
                            buttons[tarR][tarC].setIcon(black.getQueen());
                            break;
                    }

                }
            }
            if (buttons[tarR][tarC].toString().contains("white")) {
                Player white = new Player("white", false);
                if (tarR == 7) {
                    String[] options = {"bishop", "knight", "rook", "queen"};
                    int result = JOptionPane.showOptionDialog(null, "Which piece would you like to promote " +
                                    "your pawn to?", "Pawn Promotion", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                            null, options, options[0]);
                    switch (result) {
                        case 0:
                            buttons[tarR][tarC].setIcon(white.getBishop());
                            break;
                        case 1:
                            buttons[tarR][tarC].setIcon(white.getKnight());
                            break;
                        case 2:
                            buttons[tarR][tarC].setIcon(white.getRook());
                            break;
                        case 3:
                            buttons[tarR][tarC].setIcon(white.getQueen());
                            break;
                    }

                }
            }
        }
    }


    public static void main(String[] args) {

    }
}
