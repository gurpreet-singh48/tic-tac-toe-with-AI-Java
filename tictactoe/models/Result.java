package tictactoe.models;

public class Result {
    private final Symbol symbol;
    private final GameStatus gameOutcomeType;

    public Result(Symbol symbol, GameStatus gameOutcomeType) {
        this.symbol = symbol;
        this.gameOutcomeType = gameOutcomeType;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public GameStatus getGameOutcomeType() {
        return gameOutcomeType;
    }
}
