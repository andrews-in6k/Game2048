package game2048;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by anri on 18.10.15.
 */
public class ConsoleGameController implements GameController{

    private GameField gameField = new GameField(new RandomCellValueGenerator());

    private GameFieldPrinter gameFieldPrinter;

    private PrintStream printStream = new PrintStream(System.out);

    public void startController() {
        Scanner scanner = new Scanner(System.in);

        boolean iter = true;
        boolean winner = false;

        while (iter) {
            printStream.println("n - new game");
            printStream.println("8 - move up");
            printStream.println("2 - move down");
            printStream.println("4 - move left");
            printStream.println("6 - move right");
            printStream.println("e - exit");

            char ch = scanner.next().charAt(0);
            switch (ch) {
                case 'n':
                    gameField.startNewGame();
                    break;
                case '8':
                    gameField.move(Direction.UP);
                    break;
                case '2':
                    gameField.move(Direction.DOWN);
                    break;
                case '4':
                    gameField.move(Direction.LEFT);
                    break;
                case '6':
                    gameField.move(Direction.RIGHT);
                    break;
                case 'e':
                    iter = false;
                    break;
            }

            if (!winner) {
                if (gameField.hasCellWith2048()) {
                    printStream.println("YOU ARE THE WINNER");
                    printStream.println("1 - keep going");
                    printStream.println("n - new game");
                    printStream.println("e - exit");

                    ch = scanner.next().charAt(0);
                    switch (ch) {
                        case '1':
                            winner = true;
                            break;
                        case 'n':
                            gameField.startNewGame();
                            break;
                        case 'e':
                            iter = false;
                            break;
                    }
                }
            }

            if (!gameField.hasAvailableMove()) {
                printStream.println("YOU ARE LOOSE");
                printStream.println("n - new game");
                printStream.println("e - exit");

                ch = scanner.next().charAt(0);
                switch (ch) {
                    case 'n':
                        gameField.startNewGame();
                        break;
                    case 'e':
                        iter = false;
                        break;
                }
            }

            gameFieldPrinter = new ANSIGameFieldPrinter(printStream);
            gameFieldPrinter.printGameField(gameField);
        }
    }
}
