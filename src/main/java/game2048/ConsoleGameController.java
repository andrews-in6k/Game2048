package game2048;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by anri on 18.10.15.
 */
public class ConsoleGameController implements GameController {
    private GameField gameField;

    private PrintStream printStream = new PrintStream(System.out);
    private Scanner scanner =  new Scanner(System.in);

    private boolean isExitPressed;
    private boolean winner;
    private char enteredChar;

    public ConsoleGameController(GameField gameField) {
        this.gameField = gameField;
    }

    public void startController() {
        isExitPressed = false;
        winner = false;

        while (!isExitPressed) {

            gameProcessControl();

            hasWinner();

            hasLooser();

            GameFieldPrinter gameFieldPrinter = new ANSIGameFieldPrinter(printStream);
            gameFieldPrinter.printGameField(gameField);
        }
    }

    private void gameProcessControl() {
        printGameProcessHeader();

        enteredChar = scanner.next().charAt(0);
        switch (enteredChar) {
            case 'n':
                gameField.startNewGame();
                break;
            case '8':
                gameField.moveCells(Direction.UP);
                break;
            case '2':
                gameField.moveCells(Direction.DOWN);
                break;
            case '4':
                gameField.moveCells(Direction.LEFT);
                break;
            case '6':
                gameField.moveCells(Direction.RIGHT);
                break;
            case 'e':
                isExitPressed = true;
                break;
        }
    }

    protected void hasWinner() {
        if (!winner) {
            if (gameField.hasCellWithValueRequiredForVictory()) {
                printWinnerMenu();

                enteredChar = scanner.next().charAt(0);
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
                }
            }
        }
    }

    private void hasLooser() {
        if (!gameField.hasAvailableMove()) {
            printLooserMenu();

            enteredChar = scanner.next().charAt(0);
            switch (enteredChar) {
                case 'n':
                    winner = false;
                    gameField.startNewGame();
                    break;
                case 'e':
                    isExitPressed = true;
                    break;
            }
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
