import javax.swing.*;

public class LegalMove {
    private boolean isLegalMove;
    private int curR;
    private int curC;
    private int tarR;
    private int tarC;
    private JButton[][] buttons;

    public LegalMove(JButton[][] buttons) {
        this.isLegalMove = false;
        this.buttons = new JButton[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.buttons[i][j] = buttons[i][j];
            }
        }
    }

    public void setPositions(int i, int j, int curR, int curC) {
        this.curC = curC;
        this.curR = curR;
        this.tarR = i;
        this.tarC = j;
    }

    public boolean getLegalMove() {
        this.isLegalMove = isDifferentColor() && checkPiece();
        return isLegalMove;
    }

    private boolean isDifferentColor() {
        // this may be ugly, but it's the only way we know it works
        if ((buttons[curR][curC].getIcon() != null) && (buttons[tarR][tarC].getIcon() != null)) {
            return !(((buttons[curR][curC].getIcon().toString().contains("black"))
                    && (buttons[tarR][tarC].getIcon().toString().contains("black")))
                    || ((buttons[curR][curC].getIcon().toString().contains("white"))
                    && (buttons[tarR][tarC].getIcon().toString().contains("white"))));
        }
        return true;

    }

    private boolean checkPiece() {
        if (buttons[curR][curC].toString().contains("pawn")) {
            return checkPawn();
        } else if (buttons[curR][curC].toString().contains("knight")) {
            return checkKnight();
        } else if (buttons[curR][curC].toString().contains("rook")) {
            return checkRook();
        } else if (buttons[curR][curC].toString().contains("bishop")) {
            return checkBishop();
        } else if (buttons[curR][curC].toString().contains("queen")) {
            return checkBishop() || checkRook();
        } else if (buttons[curR][curC].toString().contains("king")) {
            return checkKing();
        }
        return false;
    }

    private boolean checkPawn() {

        if (buttons[curR][curC].getIcon().toString().contains("white")) {

            if ((tarC == curC)) {
                return (((curR == 1) && (tarR == 3) && (buttons[2][tarC].getIcon() == null || buttons[3][tarC].getIcon() == null)) ||
                        ((tarR == curR + 1) && (buttons[tarR][tarC].getIcon() == null)));
            }

            if ((Math.abs(tarC - curC) == 1)) {
                return ((buttons[tarR][tarC].getIcon() != null) && (tarR == curR + 1));
            }


        } else {
            if ((tarC == curC)) {
                return ((curR == 6) && (tarR == 4) && (buttons[5][curC].getIcon() == null || buttons[4][curC].getIcon() == null)) ||
                        ((tarR == curR - 1) && (buttons[tarR][curC].getIcon() == null));
            }

            if ((Math.abs(tarC - curC) == 1)) {
                return ((buttons[tarR][tarC].getIcon() != null) && (tarR == curR - 1));
            }
        }


        return false;

    }

    private boolean checkKnight() {
        return (Math.abs(tarC - curC) == 2 && (Math.abs(tarR - curR) == 1)) ||
                (Math.abs(tarC - curC) == 1 && (Math.abs(tarR - curR) == 2));
    }

    private boolean checkRook() {
        if (tarC == curC) {
            if (tarR > curR) {
                for (int i = curR + 1; i < tarR; i++) {
                    if ((buttons[i][tarC].getIcon() != null)) {
                        return false;
                    }
                }
            } else if (tarR < curR) {
                for (int i = curR - 1; i > tarR; i--) {
                    if ((buttons[i][tarC].getIcon() != null)) {
                        return false;
                    }

                }
            }
            return true;
        }
        if (tarR == curR) {
            if (tarC > curC) {
                for (int i = curC + 1; i < tarC; i++) {
                    if ((buttons[tarR][i].getIcon() != null)) {
                        return false;
                    }
                }
            } else {
                for (int i = curC - 1; i > tarC; i--) {
                    if ((buttons[tarR][i].getIcon() != null)) {
                        return false;
                    }

                }
            }
            return true;
        }
        return false;
    }

    private boolean checkBishop() {
        if (Math.abs(tarC - curC) == Math.abs(tarR - curR)) {
            if (tarR > curR && tarC > curC) {
                int i = curR + 1;
                int j = curC + 1;
                while (i < tarR) {
                    if ((buttons[i][j].getIcon() != null)) {
                        return false;
                    }
                    i++;
                    j++;
                }

            } else if (tarR < curR && tarC > curC) {
                int i = curR - 1;
                int j = curC + 1;
                while (i > tarR) {
                    if ((buttons[i][j].getIcon() != null)) {
                        return false;
                    }
                    i--;
                    j++;
                }

            } else if (tarR > curR && tarC < curC) {
                int i = curR + 1;
                int j = curC - 1;
                while (i < tarR) {
                    if ((buttons[i][j].getIcon() != null)) {
                        return false;
                    }
                    i++;
                    j--;
                }

            } else if (tarR < curR && tarC < curC) {
                int i = curR - 1;
                int j = curC - 1;
                while (i > tarR) {
                    if ((buttons[i][j].getIcon() != null)) {
                        return false;
                    }
                    i--;
                    j--;
                }

            }
            return true;

        }
        return false;
    }

    private boolean checkKing() {
        return Math.abs(tarR - curR) <= 1 && Math.abs(tarC - curC) <= 1;
    }

    public static void main(String[] args) {

    }

}
