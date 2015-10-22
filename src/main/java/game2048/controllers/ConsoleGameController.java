package game2048.controllers;

import game2048.GameController;
import game2048.gameFieldHandling.GameField;
import game2048.gameFieldHandling.GameFieldPrinter;
import game2048.gameFieldHandling.printers.ANSIGameFieldPrinter;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by anri on 18.10.15.
 */
public class ConsoleGameController implements GameController {
    private GameField gameField;

    private PrintStream printStream = new PrintStream(System.out);
    private Scanner scanner = new Scanner(System.in);

    private boolean isExitPressed;
    private boolean winner;
    private GameFieldPrinter gameFieldPrinter;

    public ConsoleGameController(GameField gameField, Scanner scanner, GameFieldPrinter gameFieldPrinter) {
        this.gameField = gameField;
        this.scanner = scanner;
        this.gameFieldPrinter = gameFieldPrinter;
    }

    public void startGame() {
        isExitPressed = false;
        winner = false;

        while (!isExitPressed) {


            printGameProcessHeader();
            gameProcessControl(scanner.next().charAt(0));

            if (!winner) {
                if (gameField.hasVictoryCellValue()) {
                    printWinnerMenu();
                    hasWinner(scanner.next().charAt(0));
                }
            }

            if (!gameField.hasAvailableMove()) {
                printLooserMenu();
                hasLooser(scanner.next().charAt(0));
            }

            gameFieldPrinter.printGameField(gameField);
        }
    }

    protected void gameProcessControl(char enteredChar) {
        boolean hasMove = false;

        switch (enteredChar) {
            case 'n':
                gameField.startNewGame();
                break;
            case '8':
                hasMove = gameField.moveCells(Direction.UP);
                break;
            case '2':
                hasMove = gameField.moveCells(Direction.DOWN);
                break;
            case '4':
                hasMove = gameField.moveCells(Direction.LEFT);
                break;
            case '6':
                hasMove = gameField.moveCells(Direction.RIGHT);
                break;
            case 'e':
                isExitPressed = true;
                break;
        }

        if (hasMove) {
            gameField.fillEmptyCell();
        }
    }

    protected void hasWinner(char enteredChar) {
        switch (enteredChar) {
            case '1':
                winner = true;
                break;
            case 'n':
                gameField.startNewGame();
                break;
            case 'e':
                isExitPressed = true;
                break;
            default:
                isExitPressed = true;
        }
    }

    protected void hasLooser(char enteredChar) {
        switch (enteredChar) {
            case 'n':
                winner = false;
                gameField.startNewGame();
                break;
            case 'e':
                isExitPressed = true;
                break;
            default:
                isExitPressed = true;
        }
    }

    private void printGameProcessHeader() {
        printStream.println("n - new game");
        printStream.println("8 - move up");
        printStream.println("2 - move down");
        printStream.println("4 - move left");
        printStream.println("6 - move right");
        printStream.println("e - exit");
    }

    private void printWinnerMenu() {
        printStream.println("YOU ARE THE WINNER");
        printStream.println("1 - keep going");
        printStream.println("n - new game");
        printStream.println("e - exit");
    }

    private void printLooserMenu() {
        printStream.println("YOU ARE LOOSE");
        printStream.println("n - new game");
        printStream.println("e - exit");
    }
}
