package tictactoe.factory;

import java.util.Random;
import java.util.Scanner;
import tictactoe.models.Player;
import tictactoe.models.Symbol;
import tictactoe.movement.AIEasyLevelMovingStrategy;
import tictactoe.movement.AIHardLevelMovingStrategy;
import tictactoe.movement.AIMediumLevelMovingStrategy;
import tictactoe.movement.UserMovingStrategy;

public class PlayerFactory {

    public Player getMovingStrategy(String input, Symbol symbol) {
        if (input.equals("easy")) {
            return new Player(symbol, new AIEasyLevelMovingStrategy(new Random()));
        } else if (input.equals("medium")) {
            return new Player(symbol, new AIMediumLevelMovingStrategy());
        } else if (input.equals("hard")) {
            return new Player(symbol, new AIHardLevelMovingStrategy());
        }
        return new Player(symbol, new UserMovingStrategy(new Scanner(System.in)));
    }
}
