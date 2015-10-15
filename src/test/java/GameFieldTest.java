import game2048.GameField;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/15/15.
 */
public class GameFieldTest {
    @Test
    public void testCreateGameField() throws Exception {
        new GameField();
    }

    @Test
    public void testGameFieldToString() throws Exception {
        GameField gameField = new GameField();
        assertThat(gameField.toString(), is(
                "0 0 0 0\n" +
                "0 0 0 0\n" +
                "0 0 0 0\n" +
                "0 0 0 0\n"));

    }

    @Test
    public void testFillEmptyCell() throws Exception {
        GameField gameField = new GameField();
        gameField.fillEmptyCell(2);
        assertThat(gameField.toString(), not(is(
                "0 0 0 0\n" +
                        "0 0 0 0\n" +
                        "0 0 0 0\n" +
                        "0 0 0 0\n")));

    }
}
