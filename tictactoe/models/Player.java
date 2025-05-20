package tictactoe.models;

import tictactoe.movement.GameMovingStrategy;

public class Player {
    private final Symbol symbol;
    private final GameMovingStrategy movingStrategy;

    public Player(Symbol symbol, GameMovingStrategy movingStrategy) {
        this.symbol = symbol;
        this.movingStrategy = movingStrategy;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public GameMovingStrategy getMovingStrategy() {
        return movingStrategy;
    }
}
