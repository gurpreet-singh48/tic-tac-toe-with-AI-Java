package tictactoe.movement;

import tictactoe.controller.Board;
import tictactoe.models.GameStatus;
import tictactoe.models.Move;
import tictactoe.models.Player;
import tictactoe.models.Result;
import tictactoe.models.Symbol;

public class AIHardLevelMovingStrategy implements GameMovingStrategy {

    @Override
    public Result makeMove(Board board, Player player) {
        Move bestMove = findBestMove(board, player);
        return board.makeMove(bestMove, player.getSymbol());
    }

    private Move findBestMove(Board board, Player player) {
        int bestVal = -1000;
        Move bestMove = new Move(-1, -1);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getCell(i, j).getSymbol() == Symbol.EMPTY) {
                    board.setCell(i, j, player.getSymbol());
                    int moveVal = minimax(board, 0, false, player);
                    board.setCell(i, j, Symbol.EMPTY);

                    if (moveVal > bestVal) {
                        bestVal = moveVal;
                        bestMove.setRow(i);
                        bestMove.setCol(j);
                    }
                }
            }
        }

        return bestMove;
    }

    private int evaluate(Board board, Player player) {
        Result result = board.checkGameStatus();
        if (result.getGameOutcomeType() == GameStatus.WON) {
            if (result.getSymbol() == player.getSymbol()) {
                return 10;
            } else {
                return -10;
            }
        }

        return 0;
    }

    private int minimax(Board board, int depth, boolean isMax, Player player) {
        int score = evaluate(board, player);

        if (score == 10) {
            return score;
        }

        if (score == -10) {
            return score;
        }

        if (board.isBoardFull()) {
            return 0;
        }

        if (isMax) {
            int best = -1000;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board.getCell(i, j).getSymbol() == Symbol.EMPTY) {
                        board.setCell(i, j, player.getSymbol());

                        best = Math.max(best, minimax(board, depth + 1, false, player));

                        board.setCell(i, j, Symbol.EMPTY);
                    }
                }
            }
            return best;
        } else {
            int best = 1000;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board.getCell(i, j).getSymbol() == Symbol.EMPTY) {
                        board.setCell(i, j, player.getSymbol() == Symbol.O ? Symbol.X : Symbol.O);

                        best = Math.min(best, minimax(board, depth + 1, true, player));

                        board.setCell(i, j, Symbol.EMPTY);
                    }
                }
            }
            return best;
        }
    }
}
