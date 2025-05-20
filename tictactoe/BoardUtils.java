package tictactoe;

import java.util.Random;
import tictactoe.controller.Board;
import tictactoe.models.Move;
import tictactoe.models.Symbol;
import tictactoe.validators.Validator;

public class BoardUtils {

    public static Move getWinningMove(Board board, Symbol symbol) {
        // Check rows
        for (int row = 0; row < 3; row++) {
            int count = 0;
            int emptyCol = -1;
            for (int col = 0; col < 3; col++) {
                if (board.getCell(row, col).getSymbol() == symbol) {
                    count++;
                } else if (board.getCell(row, col).getSymbol() == Symbol.EMPTY) {
                    emptyCol = col;
                }
            }
            if (count == 2 && emptyCol != -1) {
                return new Move(row, emptyCol);
            }
        }

        // Check columns
        for (int col = 0; col < 3; col++) {
            int count = 0;
            int emptyRow = -1;
            for (int row = 0; row < 3; row++) {
                if (board.getCell(row, col).getSymbol() == symbol) {
                    count++;
                } else if (board.getCell(row, col).getSymbol() == Symbol.EMPTY) {
                    emptyRow = row;
                }
            }
            if (count == 2 && emptyRow != -1) {
                return new Move(emptyRow, col);
            }
        }

        // Check diagonals
        int countMainDiagonal = 0, countAntiDiagonal = 0;
        int emptyMainDiagonal = -1, emptyAntiDiagonal = -1;

        for (int i = 0; i < 3; i++) {
            // Main diagonal
            if (board.getCell(i, i).getSymbol() == symbol) {
                countMainDiagonal++;
            } else if (board.getCell(i, i).getSymbol() == Symbol.EMPTY) {
                emptyMainDiagonal = i;
            }

            // Anti-diagonal
            if (board.getCell(i, 2 - i).getSymbol() == symbol) {
                countAntiDiagonal++;
            } else if (board.getCell(i, 2 - i).getSymbol() == Symbol.EMPTY) {
                emptyAntiDiagonal = i;
            }
        }

        if (countMainDiagonal == 2 && emptyMainDiagonal != -1) {
            return new Move(emptyMainDiagonal, emptyMainDiagonal);
        }

        if (countAntiDiagonal == 2 && emptyAntiDiagonal != -1) {
            return new Move(emptyAntiDiagonal, 2 - emptyAntiDiagonal);
        }

        return null;
    }

    public static Move getRandomMove(Board board) {
        Random random = new Random();
        Move move;
        while (true) {
            int row = random.nextInt(3) + 1;
            int col = random.nextInt(3) + 1;

            if (Validator.areValuesOutOfBound(board, row, col) || Validator.isCellOccupied(board, row, col)) {
                continue;
            }
            move = new Move(row - 1, col - 1);
            break;
        }

        return move;
    }
}
