package game2048;

import game2048.controllers.ConsoleGameController;
import game2048.gameFieldHandling.GameField;

/**
 * Created by anri on 18.10.15.
 */
public class Run {

    public static void main(String[] args) {
        GameField gameField = new GameField();

        GameController gameController = new ConsoleGameController(gameField);

        gameController.startGame();
    }
}
