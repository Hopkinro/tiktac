import javax.swing.JButton;

public class TicTacToeButton extends JButton {
    private int row;
    private int col;
    private String value = "";  // "X", "O", or empty

    public TicTacToeButton(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
        setText(value);  // Update the button text
    }

    public boolean isEmpty() {
        return value.equals("");
    }
}
