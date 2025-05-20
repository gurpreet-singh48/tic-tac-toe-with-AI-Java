package tictactoe.movement;

import tictactoe.BoardUtils;
import tictactoe.controller.Board;
import tictactoe.models.Move;
import tictactoe.models.Player;
import tictactoe.models.Result;
import tictactoe.models.Symbol;

public class AIMediumLevelMovingStrategy implements GameMovingStrategy {

    @Override
    public Result makeMove(Board board, Player player) {
        Move winningMove = BoardUtils.getWinningMove(board, player.getSymbol());

        if (winningMove != null) {
            return board.makeMove(winningMove, player.getSymbol());
        }

        Move blockingMove = BoardUtils.getWinningMove(board, player.getSymbol() == Symbol.O ? Symbol.X : Symbol.O);
        if (blockingMove != null) {
            return board.makeMove(blockingMove, player.getSymbol());
        }

        Move randomMove = BoardUtils.getRandomMove(board);
        System.out.println("Making move level \"medium\"");
        return board.makeMove(randomMove, player.getSymbol());
    }
}
