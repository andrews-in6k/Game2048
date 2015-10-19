package game2048.gameFieldHandling.printers;

import game2048.cellHandling.CellColor;
import game2048.gameFieldHandling.GameField;
import game2048.gameFieldHandling.GameFieldPrinter;
import game2048.gameFieldHandling.StaticCellValueGenerator;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/19/15.
 */
public class ANSIGameFieldPrinterTest {

    @Test
    public void testCreateANSIGameFieldPrinter() {
        new ANSIGameFieldPrinter(new PrintStream(System.out));
    }

    @Test
    public void testPrintGameField() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);

        GameFieldPrinter gameFieldPrinter = new ANSIGameFieldPrinter(printStream);

        GameField gameField = new GameField();

        gameFieldPrinter.printGameField(gameField);

        assertThat(baos.toString(), is(
                "Score: 0\n" +
                "-----------------------------\n" +
                "|      |      |      |      |\n" +
                "-----------------------------\n" +
                "|      |      |      |      |\n" +
                "-----------------------------\n" +
                "|      |      |      |      |\n" +
                "-----------------------------\n" +
                "|      |      |      |      |\n" +
                "-----------------------------\n"
        ));

        baos = new ByteArrayOutputStream();
        printStream = new PrintStream(baos);

        gameFieldPrinter = new ANSIGameFieldPrinter(printStream);

        gameField = new GameField(new StaticCellValueGenerator(4));

        for (int i = 0; i < GameField.FIELD_SIZE * GameField.FIELD_SIZE; i++) {
            gameField.fillEmptyCell();
        }

        gameFieldPrinter.printGameField(gameField);

        assertThat(baos.toString(), is(
                "Score: 0\n" +
                "-----------------------------\n" +
                "|" + CellColor.RED + "     4" + CellColor.DEFAULT +
                "|" + CellColor.RED + "     4" + CellColor.DEFAULT +
                "|" + CellColor.RED + "     4" + CellColor.DEFAULT +
                "|" + CellColor.RED + "     4" + CellColor.DEFAULT + "|\n" +
                "-----------------------------\n" +
                "|" + CellColor.RED + "     4" + CellColor.DEFAULT +
                "|" + CellColor.RED + "     4" + CellColor.DEFAULT +
                "|" + CellColor.RED + "     4" + CellColor.DEFAULT +
                "|" + CellColor.RED + "     4" + CellColor.DEFAULT + "|\n" +
                "-----------------------------\n" +
                "|" + CellColor.RED + "     4" + CellColor.DEFAULT +
                "|" + CellColor.RED + "     4" + CellColor.DEFAULT +
                "|" + CellColor.RED + "     4" + CellColor.DEFAULT +
                "|" + CellColor.RED + "     4" + CellColor.DEFAULT + "|\n" +
                "-----------------------------\n" +
                "|" + CellColor.RED + "     4" + CellColor.DEFAULT +
                "|" + CellColor.RED + "     4" + CellColor.DEFAULT +
                "|" + CellColor.RED + "     4" + CellColor.DEFAULT +
                "|" + CellColor.RED + "     4" + CellColor.DEFAULT + "|\n" +
                "-----------------------------\n"
        ));
    }
}
