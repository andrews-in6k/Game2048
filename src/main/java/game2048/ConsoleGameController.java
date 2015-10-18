package game2048;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by anri on 18.10.15.
 */
public class ConsoleGameController implements GameController{

    private GameField gameField;

    private GameFieldPrinter gameFieldPrinter;

    private PrintStream printStream = new PrintStream(System.out);

    public void startController() {
        Scanner scanner = new Scanner(System.in);

        boolean iter = true;

        while (iter) {
            System.out.println("n - new game");
            System.out.println("8 - move up");
            System.out.println("2 - move down");
            System.out.println("4 - move left");
            System.out.println("6 - move right");
            System.out.println("e - exit");

            char ch = scanner.next().charAt(0);
            switch (ch) {
                case 'n':
                    gameField = new GameField(new RandomCellValueGenerator());
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

            if (gameField.hasCellWith2048()) {
                System.out.println("YOU ARE THE WINNER");
                System.out.println("1 - keep going");
                System.out.println("n - new game");
                System.out.println("e - exit");

                ch = scanner.next().charAt(0);
                switch (ch) {
                    case '1':
                        break;
                    case 'n':
                        gameField = new GameField(new RandomCellValueGenerator());
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
