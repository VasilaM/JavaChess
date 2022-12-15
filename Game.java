import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicReference;

// Initializes game
public class Game {


    // Called to start game
    public static void newGame() {
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

        // set up black players
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

        // Create ActionListener for button press
        ActionListener listener = e -> {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (e.getSource() == buttons[i][j]) {
                        LegalMove move = new LegalMove(buttons);

                        // Check that it is correct player's turn
                        if (!(selected.get())
                                && (buttons[i][j].toString().contains("white") && white.getPlayerTurn())) {
                            curR.set(i);
                            curC.set(j);
                            buttons[i][j].setSelected(true);
                            selected.set(true);
                        } else if (!(selected.get()) &&
                                (buttons[i][j].toString().contains("black")
                                        && black.getPlayerTurn())) {
                            curR.set(i);
                            curC.set(j);
                            buttons[i][j].setSelected(true);
                            selected.set(true);
                        } else if (!(selected.get()) &&
                                (buttons[i][j].toString().contains("black") && !black.getPlayerTurn() ||
                                        buttons[i][j].toString().contains("white") && !white.getPlayerTurn())) {
                            throw new IllegalArgumentException("Invalid Move");
                        }

                        // Move the piece
                        else {
                            move.setPositions(i, j, curR.get(), curC.get());
                            if (move.getLegalMove()) {
                                Checks.pawnPromotion(buttons, i, j);
                                Checks.isKingCaptured(frame, buttons, curR.get(), curC.get(), i, j);
                                buttons[i][j].setIcon(buttons[curR.get()][curC.get()].getIcon());
                                buttons[curR.get()][curC.get()].setIcon(null);
                                selected.set(false);
                                white.setPlayerTurn(!white.getPlayerTurn());
                                black.setPlayerTurn(!black.getPlayerTurn());
                            }

                            // Reset button press if illegal move
                            else {
                                selected.set(false);
                                throw new IllegalArgumentException("Invalid Move");
                            }
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

    // Begin new game. Use for testing features by ensuring game rules are implemented properly.
    public static void main(String[] args) {
        Game.newGame();
    }
}

