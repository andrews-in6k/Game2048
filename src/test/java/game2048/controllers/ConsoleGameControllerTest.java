package game2048.controllers;

import game2048.gameFieldHandling.GameField;
import game2048.gameFieldHandling.StaticCellValueGenerator;
import game2048.gameFieldHandling.printers.ANSIGameFieldPrinter;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/20/15.
 */
public class ConsoleGameControllerTest {

    ConsoleGameController consoleGameController;
    GameField gameField;

    Scanner scanner;
    PrintStream printStream;
    ANSIGameFieldPrinter ansiGameFieldPrinter;

    @Test
    public void testConsoleGameController() {
        scanner = new Scanner(System.in);
        printStream = new PrintStream(System.out);
        ansiGameFieldPrinter = new ANSIGameFieldPrinter(printStream);

        new ConsoleGameController(
                new GameField(),
                scanner,
                ansiGameFieldPrinter);
    }

    @Test
    public void testGameProcessControl() {
        gameField = new GameField(new StaticCellValueGenerator(2));

        consoleGameController = new ConsoleGameController(gameField, scanner, ansiGameFieldPrinter);

        consoleGameController.gameProcessControl('n');

        assertThat(gameField.toString(), containsString("2"));
    }
}
