package game2048;

import java.io.PrintStream;

/**
 * Created by anri on 18.10.15.
 */
public class ANSIGameFieldPrinter implements GameFieldPrinter{

    private PrintStream printStream;

    public ANSIGameFieldPrinter(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printGameField(GameField gameField) {
        printStream.println("Score: " + GameField.getScore());
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
            if (gameField.getCells()[i][j].isEmpty()){
                printStream.print("      |");
            } else {
                printStream.printf("%s%6d%s|", gameField.getCells()[i][j].getCellColor(),
                        gameField.getCells()[i][j].getCellValue(),
                        CellColor.DEFAULT);
            }
        }
    }
}
