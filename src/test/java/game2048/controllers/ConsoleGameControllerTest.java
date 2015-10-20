package game2048.controllers;

import game2048.gameFieldHandling.GameField;
import game2048.gameFieldHandling.StaticCellValueGenerator;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/20/15.
 */
public class ConsoleGameControllerTest {

    ConsoleGameController consoleGameController;
    GameField gameField;

    @Test
    public void testConsoleGameController() {
        new ConsoleGameController(new GameField());
    }

    @Test
    public void testGameProcessControl() {
        gameField = new GameField(new StaticCellValueGenerator(2));

        consoleGameController = new ConsoleGameController(gameField);

        consoleGameController.gameProcessControl('n');

        assertThat(gameField.toString(), containsString("2"));
    }
}
