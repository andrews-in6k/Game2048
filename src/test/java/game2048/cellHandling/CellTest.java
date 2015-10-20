package game2048.cellHandling;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/16/15.
 */
public class CellTest {

    Cell cell;

    @Before
    public void setUp() {
        cell = new Cell();
    }

    @Test
    public void testCreateCell() {
        new Cell();
    }

    @Test
    public void testIsEmpty() {
        cell.setCellValue(0);

        assertThat(cell.isEmpty(), is(true));
    }

    @Test
    public void testNotIsEmpty() {
        cell.setCellValue(2);

        assertThat(cell.isEmpty(), is(false));
    }

    @Test
    public void testGetCellValue() {
        cell.setCellValue(2);

        assertThat(cell.getCellValue(), is(2));
    }

    @Test
    public void testSetCellValue(){
        cell.setCellValue(4);

        assertThat(cell.getCellValue(), is(4));
    }

    @Test
    public void testIncrementPower() {
        cell.setCellValue(2);
        cell.incrementPower();

        assertThat(cell.getCellValue(),is(4));
    }

    @Test
    public void testRepeatedlyIncrementPower() {
        cell.setCellValue(2);

        cell.incrementPower();
        cell.incrementPower();

        assertThat(cell.getCellValue(),is(8));
    }
}
