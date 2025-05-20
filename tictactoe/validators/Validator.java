package tictactoe.validators;

import tictactoe.controller.Board;
import tictactoe.models.ParsedInput;
import tictactoe.models.Symbol;

public class Validator {

    public static ParsedInput isUserInputValid(String input, Board board) {
        int rowInt = -1, colInt = -1;

        String[] arr = input.split(" ");
        if (arr.length != 2) {
            System.out.println("You should enter numbers!");
            return new ParsedInput(false);
        }

        String row = arr[0];
        String col = arr[1];

        try {
            rowInt = Integer.parseInt(row);
            colInt = Integer.parseInt(col);
        } catch (NumberFormatException e) {
            System.out.println("You should enter numbers!");
            return new ParsedInput(false);
        }

        if (areValuesOutOfBound(board, rowInt, colInt)) {
            System.out.println("Coordinates should be from 1 to 3!");
            return new ParsedInput(false);
        }

        if (isCellOccupied(board, rowInt, colInt)) {
            System.out.println("This cell is occupied! Choose another one!");
            return new ParsedInput(false);
        }

        return new ParsedInput(rowInt, colInt, true);
    }

    public static boolean areValuesOutOfBound(Board board, int rowInt, int colInt) {
        return rowInt < 1 || rowInt > 3 || colInt < 1 || colInt > 3;
    }

    public static boolean isCellOccupied(Board board, int rowInt, int colInt) {
        return board.getCell(rowInt - 1, colInt - 1).getSymbol() != Symbol.EMPTY;
    }
}
