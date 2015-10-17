import game2048.Cell;
import game2048.GameField;
import game2048.MoveCells;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/16/15.
 */
public class MoveCellsTest {

    Cell[][] cell = new Cell[GameField.FIELD_SIZE][GameField.FIELD_SIZE];

    @Test
    public void testMoveCells() {
        new MoveCells();
    }

    @Test
    public void testMoveUp(){
        MoveCells moveCells = new MoveCells();

        //test empty
        generateEmptyCells();
        moveCells.moveUp(cell);
        assertThat(cellToString(), is(
                "0 0 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n"
        ));

        //case 1
        generateMoveUpCase1();
        moveCells.moveUp(cell);
        assertThat(cellToString(), is(
                "2 2 2 2 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n"
        ));

        //case 2
        generateMoveUpCase2();
        moveCells.moveUp(cell);
        assertThat(cellToString(), is(
                "2 0 2 2 \n" +
                "4 0 4 4 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n"
        ));

        //case 3
        generateMoveUpCase3();
        moveCells.moveUp(cell);
        assertThat(cellToString(), is(
                "2 4 0 0 \n" +
                "4 0 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n"
        ));

        //case 4
        generateMoveUpCase4();
        moveCells.moveUp(cell);
        assertThat(cellToString(), is(
                "4 8 16 4 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n"
        ));

        //case 5
        generateMoveUpCase5();
        moveCells.moveUp(cell);
        assertThat(cellToString(), is(
                "4 4 2 4 \n" +
                "4 8 4 4 \n" +
                "0 0 2 0 \n" +
                "0 0 4 0 \n"
        ));
    }

    private String cellToString() {
        String cells = "";

        for (int i = 0; i < GameField.FIELD_SIZE; i++) {
            for (int j = 0; j < GameField.FIELD_SIZE; j++) {
                cells += cell[i][j].getCellValue() + " ";
            }

            cells += "\n";
        }

        return cells;
    }

    private void generateEmptyCells() {
        for (int i = 0; i < GameField.FIELD_SIZE; i++) {
            for (int j = 0; j < GameField.FIELD_SIZE; j++) {
                cell[i][j] = new Cell();
            }
        }
    }

    private void generateMoveUpCase1(){
        generateEmptyCells();

        cell[2][0] = new Cell(2);
        cell[3][1] = new Cell(2);
        cell[3][2] = new Cell(2);
        cell[3][3] = new Cell(2);
    }

    private void generateMoveUpCase2(){
        generateEmptyCells();

        cell[2][0] = new Cell(2);
        cell[3][0] = new Cell(4);
        cell[0][2] = new Cell(2);
        cell[3][2] = new Cell(4);
        cell[0][3] = new Cell(2);
        cell[1][3] = new Cell(4);
    }

    private void generateMoveUpCase3(){
        generateEmptyCells();

        cell[0][0] = new Cell(2);
        cell[0][1] = new Cell(4);
        cell[1][0] = new Cell(4);
    }

    private void generateMoveUpCase4(){
        generateEmptyCells();

        cell[0][0] = new Cell(2);
        cell[0][1] = new Cell(4);
        cell[1][0] = new Cell(2);
        cell[1][2] = new Cell(8);
        cell[1][3] = new Cell(2);
        cell[2][1] = new Cell(4);
        cell[2][3] = new Cell(2);
        cell[3][2] = new Cell(8);
    }

    private void generateMoveUpCase5(){
        generateEmptyCells();

        cell[0][0] = new Cell(2);
        cell[0][1] = new Cell(2);
        cell[0][2] = new Cell(2);
        cell[0][3] = new Cell(2);
        cell[1][0] = new Cell(2);
        cell[1][1] = new Cell(2);
        cell[1][2] = new Cell(4);
        cell[1][3] = new Cell(2);
        cell[2][0] = new Cell(2);
        cell[2][1] = new Cell(4);
        cell[2][2] = new Cell(2);
        cell[2][3] = new Cell(4);
        cell[3][0] = new Cell(2);
        cell[3][1] = new Cell(4);
        cell[3][2] = new Cell(4);
        cell[3][3] = new Cell(0);
    }
}
