package game2048;

import game2048.controllers.ConsoleGameController;
import game2048.gameFieldHandling.GameField;
import game2048.gameFieldHandling.RandomCellValueGenerator;

/**
 * Created by anri on 18.10.15.
 */
public class Run {

    private static GameController gameController;

    public static void main(String[] args) {
        GameField gameField = new GameField(new RandomCellValueGenerator());

        gameController = new ConsoleGameController(gameField);

        gameController.startController();
    }
}
