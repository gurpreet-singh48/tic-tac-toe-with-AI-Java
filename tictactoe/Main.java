package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import tictactoe.controller.Board;
import tictactoe.controller.BoardGame;
import tictactoe.controller.TicTacToeGame;
import tictactoe.factory.PlayerFactory;
import tictactoe.models.Symbol;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Input command: ");
            String inputCommand = scanner.nextLine();

            String[] inputCommandArray = inputCommand.split(" ");
            if(inputCommandArray[0].equals("exit")) break;

            boolean isInputCommandValid = validateInputCommand(inputCommandArray);

            if (!isInputCommandValid) {
                System.out.println("Bad parameters!");
                continue;
            }

            PlayerFactory factory = new PlayerFactory();
            BoardGame ticTocGame = new TicTacToeGame(
                    scanner,
                    factory.getMovingStrategy(inputCommandArray[1], Symbol.X),
                    factory.getMovingStrategy(inputCommandArray[2], Symbol.O),
                    new Board("---------"));

            ticTocGame.startGame();
            System.out.println();
        }
    }

    private static boolean validateInputCommand(String[] inputCommandArray) {
        if (inputCommandArray.length != 3) {
            return false;
        }
        if (!inputCommandArray[0].equals("start")) {
            return false;
        }

        List<String> playerOptions = new ArrayList<>(Arrays.asList("easy", "user", "medium", "hard"));
        return playerOptions.contains(inputCommandArray[1]) && playerOptions.contains(inputCommandArray[2]);
    }
}
