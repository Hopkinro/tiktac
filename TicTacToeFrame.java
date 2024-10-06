import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class TicTacToeFrame extends JFrame {
    private static final int SIZE = 3;  // Tic Tac Toe grid size (3x3)
    private TicTacToeButton[][] buttons = new TicTacToeButton[SIZE][SIZE];
    private String currentPlayer = "X";
    private int moveCount = 0;
    private GameLogic gameLogic;

    public TicTacToeFrame() {
        setTitle("Tic Tac Toe");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        gameLogic = new GameLogic();


        JPanel boardPanel = new JPanel(new GridLayout(SIZE, SIZE));


        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                TicTacToeButton button = new TicTacToeButton(row, col);
                buttons[row][col] = button;
                button.addActionListener(new ButtonClickListener());
                boardPanel.add(button);
            }
        }


        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(e -> System.exit(0));

        add(boardPanel, BorderLayout.CENTER);
        add(quitButton, BorderLayout.SOUTH);
    }


    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            TicTacToeButton clickedButton = (TicTacToeButton) e.getSource();

            if (!clickedButton.isEmpty()) {

                JOptionPane.showMessageDialog(TicTacToeFrame.this, "This cell is already taken!");
                return;
            }


            clickedButton.setValue(currentPlayer);
            moveCount++;


            if (moveCount >= 5 && gameLogic.checkWinner(buttons)) {
                JOptionPane.showMessageDialog(TicTacToeFrame.this, currentPlayer + " wins!");
                resetBoard();
                return;
            }


            if (moveCount == 9) {
                JOptionPane.showMessageDialog(TicTacToeFrame.this, "It's a tie!");
                resetBoard();
                return;
            }

            // Switch player
            currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
        }
    }


    private void resetBoard() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                buttons[row][col].setValue("");  // Clear all buttons
            }
        }
        moveCount = 0;
    }
}
