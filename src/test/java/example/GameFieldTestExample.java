package example;

import game2048.example.GameFieldExample;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/15/15.
 */
public class GameFieldTestExample {
    @Test
    public void testCreateGameField() throws Exception {
        new GameFieldExample();
    }

    @Test
    public void testGameFieldToString() throws Exception {
        GameFieldExample gameField = new GameFieldExample();
        assertThat(gameField.toString(), is(
                "0 0 0 0\n" +
                "0 0 0 0\n" +
                "0 0 0 0\n" +
                "0 0 0 0\n"));

    }

    @Test
    public void testFillEmptyCell() throws Exception {
        GameFieldExample gameField = new GameFieldExample();
        gameField.fillEmptyCell(2);
        assertThat(gameField.toString(), not(is(
                "0 0 0 0\n" +
                        "0 0 0 0\n" +
                        "0 0 0 0\n" +
                        "0 0 0 0\n")));

    }
}
