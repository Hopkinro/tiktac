public class GameLogic {
    public boolean checkWinner(TicTacToeButton[][] buttons) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getValue().equals(buttons[i][1].getValue()) &&
                    buttons[i][1].getValue().equals(buttons[i][2].getValue()) &&
                    !buttons[i][0].getValue().equals("")) {
                return true;
            }
            if (buttons[0][i].getValue().equals(buttons[1][i].getValue()) &&
                    buttons[1][i].getValue().equals(buttons[2][i].getValue()) &&
                    !buttons[0][i].getValue().equals("")) {
                return true;
            }
        }

        // Check diagonals
        if (buttons[0][0].getValue().equals(buttons[1][1].getValue()) &&
                buttons[1][1].getValue().equals(buttons[2][2].getValue()) &&
                !buttons[0][0].getValue().equals("")) {
            return true;
        }

        if (buttons[0][2].getValue().equals(buttons[1][1].getValue()) &&
                buttons[1][1].getValue().equals(buttons[2][0].getValue()) &&
                !buttons[0][2].getValue().equals("")) {
            return true;
        }

        return false;
    }
}

