package tictactoe.movement;

import java.util.Random;
import tictactoe.BoardUtils;
import tictactoe.controller.Board;
import tictactoe.models.Move;
import tictactoe.models.Player;
import tictactoe.models.Result;

public class AIEasyLevelMovingStrategy implements GameMovingStrategy {

    private final Random random;

    public AIEasyLevelMovingStrategy(Random random) {
        this.random = random;
    }

    @Override
    public Result makeMove(Board board, Player player) {
        Move randomMove = BoardUtils.getRandomMove(board);
        System.out.println("Making move level \"easy\"");
        return board.makeMove(randomMove, player.getSymbol());
    }
}
