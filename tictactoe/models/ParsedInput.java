package tictactoe.models;

public class ParsedInput {
    private final int row;
    private final int col;
    private final boolean isValid;

    public ParsedInput(int row, int col, boolean isValid) {
        this.row = row;
        this.col = col;
        this.isValid = isValid;
    }

    public ParsedInput(boolean isValid) {
        this.row = -1;
        this.col = -1;
        this.isValid = false;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isValid() {
        return isValid;
    }
}
