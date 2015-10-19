package game2048.cellHandling;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/16/15.
 */
public class CellTest {

    Cell cell;

    @Test
    public void testCreateCell() {
        new Cell();
    }

    @Test
    public void testIsEmpty() {
        cell = new Cell();

        assertThat(cell.isEmpty(), is(true));

        cell.setCellValue(2);

        assertThat(cell.isEmpty(), is(false));
    }

    @Test
    public void testGetCellValue() {
        cell = new Cell();

        assertThat(cell.getCellValue(), is(0));

        cell = new Cell(2);

        assertThat(cell.getCellValue(), is(2));
    }

    @Test
    public void testSetCellValue(){
        cell = new Cell();

        cell.setCellValue(4);

        assertThat(cell.getCellValue(), is(4));
    }

    @Test
    public void testIncrementPower() {
        cell = new Cell();

        cell.incrementPower();

        assertThat(cell.getCellValue(), is(0));

        cell.setCellValue(2);
        cell.incrementPower();

        assertThat(cell.getCellValue(),is(4));

        cell.incrementPower();

        assertThat(cell.getCellValue(),is(8));
    }
}
