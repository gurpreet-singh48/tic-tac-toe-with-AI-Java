package tictactoe.controller;

import java.util.Scanner;
import tictactoe.models.GameStatus;
import tictactoe.models.Player;
import tictactoe.models.Result;
import tictactoe.movement.GameMovingStrategy;

public class TicTacToeGame implements BoardGame {

    private final Scanner scanner;
    private final Player firstPlayer;
    private final Player secondPlayer;
    private final Board board;

    public TicTacToeGame(Scanner scanner, Player firstPlayer, Player secondPlayer,
            Board board) {
        this.scanner = scanner;
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.board = board;
    }

    @Override
    public void startGame() {
        board.printBoard();

        while (true) {
            Result firstPlayerResult = firstPlayer.getMovingStrategy().makeMove(board, firstPlayer);
            if (firstPlayerResult.getGameOutcomeType() == GameStatus.WON) {
                System.out.printf("%s wins", firstPlayerResult.getSymbol());
                break;
            }
            if (firstPlayerResult.getGameOutcomeType() == GameStatus.DRAW) {
                System.out.println("Draw");
                break;
            }

            Result secondPlayerResult = secondPlayer.getMovingStrategy().makeMove(board, secondPlayer);
            if (secondPlayerResult.getGameOutcomeType() == GameStatus.WON) {
                System.out.printf("%s wins", secondPlayerResult.getSymbol());
                break;
            }
            if (secondPlayerResult.getGameOutcomeType() == GameStatus.DRAW) {
                System.out.println("Draw");
                break;
            }
        }
    }
}
