package game2048.gameFieldHandling;

import game2048.cellHandling.Cell;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/16/15.
 */
public class CellsMoverTest {

    @Test
    public void testCreateCellsMover() {
        new CellsMover(new GameField());
    }
}
