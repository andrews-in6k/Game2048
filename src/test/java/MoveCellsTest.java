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

        generateEmptyCells();
        moveCells.moveUp(cell);
        for (int i = 0; i < GameField.FIELD_SIZE; i++) {
            for (int j = 0; j < GameField.FIELD_SIZE; j++) {
                assertThat(cell[i][j].getCellValue(), is(0));
            }
        }

    }

    private void generateEmptyCells() {
        for (int i = 0; i < GameField.FIELD_SIZE; i++) {
            for (int j = 0; j < GameField.FIELD_SIZE; j++) {
                cell[i][j] = new Cell();
            }
        }
    }
}
