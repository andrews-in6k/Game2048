package game2048.gameFieldHandling.printers;

import game2048.cellHandling.CellColor;
import game2048.gameFieldHandling.GameField;
import game2048.gameFieldHandling.GameFieldPrinter;

import java.io.PrintStream;

/**
 * Created by anri on 18.10.15.
 */
public class ANSIGameFieldPrinter implements GameFieldPrinter {

    private PrintStream printStream;

    public ANSIGameFieldPrinter(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printGameField(GameField gameField) {
        printStream.println("Score: " + gameField.getScore());
        printStream.println("-----------------------------");

        for (int i = 0; i < GameField.FIELD_SIZE; i++) {
            printStream.print("|");

            printCells(gameField, i);

            printStream.println();
            printStream.println("-----------------------------");
        }
    }

    private void printCells(GameField gameField, int i) {
        for (int j = 0; j < GameField.FIELD_SIZE; j++) {
            if (gameField.getCells()[i][j].isEmpty()) {
                printStream.print("      |");
            } else {
                printStream.printf("%s%6d%s|", gameField.getCells()[i][j].getCellColor(),
                        gameField.getCells()[i][j].getCellValue(),
                        CellColor.DEFAULT);
            }
        }
    }

    public void printGameProcessHeader() {
        printStream.println("n - new game");
        printStream.println("8 - move up");
        printStream.println("2 - move down");
        printStream.println("4 - move left");
        printStream.println("6 - move right");
        printStream.println("e - exit");
    }

    public void printWinnerMenu() {
        printStream.println("YOU ARE THE WINNER");
        printStream.println("1 - keep going");
        printStream.println("n - new game");
        printStream.println("e - exit");
    }

    public void printLooserMenu() {
        printStream.println("YOU ARE LOOSE");
        printStream.println("n - new game");
        printStream.println("e - exit");
    }

}
