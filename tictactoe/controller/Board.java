package tictactoe.controller;

import tictactoe.models.Cell;
import tictactoe.models.GameStatus;
import tictactoe.models.Move;
import tictactoe.models.Result;
import tictactoe.models.Symbol;

public class Board {

    private final Cell[][] cells;

    public Board(String input) {
        cells = new Cell[3][3];
        initializeBoard(input);
    }

    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    public void setCell(int row, int col, Symbol symbol) {
        cells[row][col].setSymbol(symbol);
    }

    private void initializeBoard(String input) {
        for (int i = 0; i < input.length(); i++) {
            int row = i / 3;
            int col = i % 3;

            if (input.charAt(i) == Symbol.X.getValue()) {
                cells[row][col] = new Cell(row, col, Symbol.X);
            } else if (input.charAt(i) == Symbol.O.getValue()) {
                cells[row][col] = new Cell(row, col, Symbol.O);
            } else {
                cells[row][col] = new Cell(row, col, Symbol.EMPTY);
            }
        }
    }

    public void printBoard() {
        System.out.println("---------");

        for (int row = 0; row < 3; row++) {
            System.out.printf("| %s %s %s |%n", cells[row][0].getSymbol().getValue(), cells[row][1].getSymbol().getValue(),
                    cells[row][2].getSymbol().getValue());
        }

        System.out.println("---------");
    }

    public Result makeMove(Move move, Symbol symbol) {
        cells[move.getRow()][move.getCol()].setSymbol(symbol);
        printBoard();
        return checkGameStatus();
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j].getSymbol() == Symbol.EMPTY) {
                    return false;
                }
            }
        }

        return true;
    }

    private Symbol checkRows() {
        for (int i = 0; i < 3; i++) {
            if (cells[i][0].getSymbol() == Symbol.EMPTY) {
                continue;
            }

            Symbol current = cells[i][0].getSymbol();
            boolean win = true;
            for (int j = 1; j < 3; j++) {
                if (cells[i][j].getSymbol() != current) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return current;
            }
        }

        return null;
    }

    private Symbol checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (cells[0][i].getSymbol() == Symbol.EMPTY) {
                continue;
            }

            Symbol current = cells[0][i].getSymbol();
            boolean win = true;
            for (int j = 1; j < 3; j++) {
                if (cells[j][i].getSymbol() != current) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return current;
            }
        }

        return null;
    }

    private Symbol checkDiagonalLToR() {
        if (cells[0][0].getSymbol() == Symbol.EMPTY) {
            return null;
        }
        Symbol current = cells[0][0].getSymbol();

        boolean win = true;
        for (int i = 1; i < 3; i++) {
            if (cells[i][i].getSymbol() != current) {
                win = false;
                break;
            }
        }

        if (win) {
            return current;
        }
        return null;
    }

    private Symbol checkDiagonalRToL() {
        if (cells[0][2].getSymbol() == Symbol.EMPTY) {
            return null;
        }
        Symbol current = cells[0][2].getSymbol();

        boolean win = true;
        for (int i = 0, j = 2; i < 3 && j >= 0; i++, j--) {
            if (cells[i][j].getSymbol() != current) {
                win = false;
                break;
            }
        }

        if (win) {
            return current;
        }
        return null;
    }

    public Result checkGameStatus() {
        Symbol rowResult = checkRows();
        if (rowResult != null) {
            return new Result(rowResult, GameStatus.WON);
        }

        Symbol colResult = checkColumns();
        if (colResult != null) {
            return new Result(colResult, GameStatus.WON);
        }

        Symbol diagonalLToRResult = checkDiagonalLToR();
        if (diagonalLToRResult != null) {
            return new Result(diagonalLToRResult, GameStatus.WON);
        }

        Symbol diagonalRtoLResult = checkDiagonalRToL();
        if (diagonalRtoLResult != null) {
            return new Result(diagonalRtoLResult, GameStatus.WON);
        }

        if (isBoardFull()) {
            return new Result(null, GameStatus.DRAW);
        }
        
        return new Result(null, GameStatus.NOT_FINISHED);
    }
}
