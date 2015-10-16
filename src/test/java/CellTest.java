import game2048.Cell;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/16/15.
 */
public class CellTest {

    @Test
    public void testCreateCell() {
        new Cell();
    }

    @Test
    public void testGetValue() {
        Cell cell = new Cell();

        assertThat(cell.getValue(), is(0));

        cell = new Cell(2);

        assertThat(cell.getValue(), is(2));
    }

    @Test
    public void testSetCellValue(){
        Cell cell = new Cell();

        cell.setCellValue(4);

        assertThat(cell.getValue(), is(4));
    }

    @Test
    public void testIncrementPower() {
        Cell cell = new Cell();

        cell.incrementPower();

        assertThat(cell.getValue(), is(0));

        cell.setCellValue(2);
        cell.incrementPower();

        assertThat(cell.getValue(),is(4));

        cell.incrementPower();

        assertThat(cell.getValue(),is(8));
    }
}
