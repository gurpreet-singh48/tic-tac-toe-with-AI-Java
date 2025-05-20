package tictactoe.models;

public class Cell {
    private final int row;
    private final int col;
    private Symbol symbol;

    public Cell(int row, int col, Symbol symbol) {
        this.row = row;
        this.col = col;
        this.symbol = symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Symbol getSymbol() {
        return symbol;
    }
}
