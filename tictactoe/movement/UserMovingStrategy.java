package tictactoe.movement;

import java.util.Scanner;
import tictactoe.controller.Board;
import tictactoe.models.Move;
import tictactoe.models.ParsedInput;
import tictactoe.models.Player;
import tictactoe.models.Result;
import tictactoe.models.Symbol;
import tictactoe.validators.Validator;

public class UserMovingStrategy implements GameMovingStrategy {

    private final Scanner scanner;

    public UserMovingStrategy(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Result makeMove(Board board, Player player) {

        while (true) {
            System.out.print("Enter the coordinates: ");
            String coordinates = scanner.nextLine();

            ParsedInput parsedInput = Validator.isUserInputValid(coordinates, board);

            if (!parsedInput.isValid()) {
                continue;
            }

            return board.makeMove(new Move(parsedInput.getRow() - 1, parsedInput.getCol() - 1), player.getSymbol());
        }
    }
}
