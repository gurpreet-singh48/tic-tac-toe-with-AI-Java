package tictactoe.movement;

import tictactoe.controller.Board;
import tictactoe.models.Player;
import tictactoe.models.Result;

public interface GameMovingStrategy {
    Result makeMove(Board board, Player player);
}
