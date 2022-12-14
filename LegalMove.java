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
        this.isLegalMove = isDifferentColor() && checkPawn();
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

    private boolean checkPawn() {
        if (buttons[curR][curC].toString().contains("pawn")) {
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

        }

        return false;

    }

    public static void main(String[] args) {

    }

}
