package gameFieldHandling;

import game2048.cellHandling.Cell;
import game2048.gameFieldHandling.GameField;
import game2048.gameFieldHandling.MoveCells;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/16/15.
 */
public class MoveCellsTest {

    Cell[][] cells = new Cell[GameField.FIELD_SIZE][GameField.FIELD_SIZE];

    @Test
    public void testMoveCells() {
        new MoveCells(cells);
    }

    @Test
    public void testMoveUp(){
        MoveCells moveCells;

        //test empty
        generateEmptyCells();
        moveCells = new MoveCells(cells);

        assertThat(moveCells.moveUp(), is(false));

        assertThat(cellToString(), is(
                "0 0 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n"
        ));

        //case 1
        generateMoveUpCase1();
        moveCells = new MoveCells(cells);

        assertThat(moveCells.moveUp(), is(true));

        assertThat(cellToString(), is(
                "2 2 2 2 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n"
        ));

        //case 2
        generateMoveUpCase2();
        moveCells = new MoveCells(cells);

        assertThat(moveCells.moveUp(), is(true));

        assertThat(cellToString(), is(
                "2 0 2 2 \n" +
                "4 0 4 4 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n"
        ));

        //case 3
        generateMoveUpCase3();
        moveCells = new MoveCells(cells);

        assertThat(moveCells.moveUp(), is(false));

        assertThat(cellToString(), is(
                "2 4 0 0 \n" +
                "4 0 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n"
        ));

        //case 4
        generateMoveUpCase4();
        moveCells = new MoveCells(cells);

        assertThat(moveCells.moveUp(), is(true));

        assertThat(cellToString(), is(
                "4 8 16 4 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n"
        ));

        //case final
        generateFinalMoveCase();
        moveCells = new MoveCells(cells);

        assertThat(moveCells.moveUp(), is(true));

        assertThat(cellToString(), is(
                "4 4 2 4 \n" +
                "4 8 4 4 \n" +
                "0 0 2 0 \n" +
                "0 0 4 0 \n"
        ));
    }

    @Test
    public void testMoveDown() {
        MoveCells moveCells;

        generateEmptyCells();
        moveCells = new MoveCells(cells);

        assertThat(moveCells.moveDown(), is(false));

        assertThat(cellToString(), is(
                "0 0 0 0 \n" +
                        "0 0 0 0 \n" +
                        "0 0 0 0 \n" +
                        "0 0 0 0 \n"
        ));

        generateFinalMoveCase();
        moveCells = new MoveCells(cells);

        assertThat(moveCells.moveDown(), is(true));

        assertThat(cellToString(), is(
                "0 0 2 0 \n" +
                "0 0 4 0 \n" +
                "4 4 2 4 \n" +
                "4 8 4 4 \n"
        ));
    }

    @Test
    public void testMoveLeft() {
        MoveCells moveCells;

        generateEmptyCells();
        moveCells = new MoveCells(cells);

        assertThat(moveCells.moveLeft(), is(false));

        assertThat(cellToString(), is(
                "0 0 0 0 \n" +
                        "0 0 0 0 \n" +
                        "0 0 0 0 \n" +
                        "0 0 0 0 \n"
        ));

        generateFinalMoveCase();
        moveCells = new MoveCells(cells);

        assertThat(moveCells.moveLeft(), is(true));

        assertThat(cellToString(), is(
                "4 4 0 0 \n" +
                "4 4 2 0 \n" +
                "2 4 2 4 \n" +
                "2 8 0 0 \n"
        ));
    }

    @Test
    public void testMoveRight() {
        MoveCells moveCells;

        generateEmptyCells();
        moveCells = new MoveCells(cells);

        assertThat(moveCells.moveRight(), is(false));

        assertThat(cellToString(), is(
                "0 0 0 0 \n" +
                        "0 0 0 0 \n" +
                        "0 0 0 0 \n" +
                        "0 0 0 0 \n"
        ));

        generateFinalMoveCase();
        moveCells = new MoveCells(cells);

        assertThat(moveCells.moveRight(), is(true));

        assertThat(cellToString(), is(
                "0 0 4 4 \n" +
                "0 4 4 2 \n" +
                "2 4 2 4 \n" +
                "0 0 2 8 \n"
        ));
    }

    private String cellToString() {
        String cells = "";

        for (int i = 0; i < GameField.FIELD_SIZE; i++) {
            for (int j = 0; j < GameField.FIELD_SIZE; j++) {
                cells += this.cells[i][j].getCellValue() + " ";
            }

            cells += "\n";
        }

        return cells;
    }

    private void generateEmptyCells() {
        for (int i = 0; i < GameField.FIELD_SIZE; i++) {
            for (int j = 0; j < GameField.FIELD_SIZE; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    private void generateMoveUpCase1() {
        generateEmptyCells();

        cells[2][0] = new Cell(2);
        cells[3][1] = new Cell(2);
        cells[3][2] = new Cell(2);
        cells[3][3] = new Cell(2);
    }

    private void generateMoveUpCase2() {
        generateEmptyCells();

        cells[2][0] = new Cell(2);
        cells[3][0] = new Cell(4);
        cells[0][2] = new Cell(2);
        cells[3][2] = new Cell(4);
        cells[0][3] = new Cell(2);
        cells[1][3] = new Cell(4);
    }

    private void generateMoveUpCase3() {
        generateEmptyCells();

        cells[0][0] = new Cell(2);
        cells[0][1] = new Cell(4);
        cells[1][0] = new Cell(4);
    }

    private void generateMoveUpCase4() {
        generateEmptyCells();

        cells[0][0] = new Cell(2);
        cells[0][1] = new Cell(4);
        cells[1][0] = new Cell(2);
        cells[1][2] = new Cell(8);
        cells[1][3] = new Cell(2);
        cells[2][1] = new Cell(4);
        cells[2][3] = new Cell(2);
        cells[3][2] = new Cell(8);
    }

    private void generateFinalMoveCase() {
        generateEmptyCells();

        cells[0][0] = new Cell(2);
        cells[0][1] = new Cell(2);
        cells[0][2] = new Cell(2);
        cells[0][3] = new Cell(2);
        cells[1][0] = new Cell(2);
        cells[1][1] = new Cell(2);
        cells[1][2] = new Cell(4);
        cells[1][3] = new Cell(2);
        cells[2][0] = new Cell(2);
        cells[2][1] = new Cell(4);
        cells[2][2] = new Cell(2);
        cells[2][3] = new Cell(4);
        cells[3][0] = new Cell(2);
        cells[3][1] = new Cell(4);
        cells[3][2] = new Cell(4);
        cells[3][3] = new Cell(0);
    }
}
