import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicReference;

public class Game {
    public static void main(String[] args) {
        // Create a Frame
        JFrame frame = new JFrame("Chess Board");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // array of buttons
        Board board = new Board();
        JButton[][] buttons = board.buttons();

        Player white = new Player("white", true);
        Player black = new Player("black", false);


        // set up white players
        for (int i = 0; i < 8; i++) {
            buttons[1][i].setIcon(white.getPawn());
        }

        buttons[0][0].setIcon(white.getRook());
        buttons[0][7].setIcon(white.getRook());

        buttons[0][1].setIcon(white.getKnight());
        buttons[0][6].setIcon(white.getKnight());

        buttons[0][2].setIcon(white.getBishop());
        buttons[0][5].setIcon(white.getBishop());

        buttons[0][3].setIcon(white.getQueen());
        buttons[0][4].setIcon(white.getKing());

        // set up
        for (int i = 0; i < 8; i++) {
            buttons[6][i].setIcon(black.getPawn());
        }

        buttons[7][0].setIcon(black.getRook());
        buttons[7][7].setIcon(black.getRook());

        buttons[7][1].setIcon(black.getKnight());
        buttons[7][6].setIcon(black.getKnight());

        buttons[7][2].setIcon(black.getBishop());
        buttons[7][5].setIcon(black.getBishop());

        buttons[7][3].setIcon(black.getQueen());
        buttons[7][4].setIcon(black.getKing());

        // create 8 x 8 container
        Container container = frame.getContentPane();
        container.setLayout(new GridLayout(8, 8));

        AtomicReference<Integer> curR = new AtomicReference<>();
        AtomicReference<Integer> curC = new AtomicReference<>();
        AtomicReference<Boolean> selected = new AtomicReference<>(false);

        ActionListener listener = e -> {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (e.getSource() == buttons[i][j]) {
                        if (!(selected.get())) {
                            curR.set(i);
                            curC.set(j);
                            buttons[i][j].setSelected(true);
                            selected.set(true);
                        } else {
                            buttons[i][j].setIcon(buttons[curR.get()][curC.get()].getIcon());
                            buttons[curR.get()][curC.get()].setIcon(null);
                            selected.set(false);
                        }
                    }
                }
            }
        };


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

