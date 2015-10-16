import game2048.GameField;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/16/15.
 */
public class GameFieldTest {

    @Test
    public void testCreateGameField() {
        new GameField();
    }

    @Test
    public void testGameFieldToString() {
        GameField gameField = new GameField();
        assertThat(gameField.toString(), is(
                "0 0 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n"
        ));
    }

    @Test
    public void testFillEmptyCell() {
        GameField gameField = new GameField();

        gameField.fillEmptyCell(2);
        assertThat(gameField.toString(), containsString("2"));

        gameField.fillEmptyCell(4);
        assertThat(gameField.toString(), containsString("4"));

        for (int i = 0; i < (gameField.FIELD_SIZE * gameField.FIELD_SIZE); i++) {
            gameField.fillEmptyCell(2);
        }
        assertThat(gameField.toString(), is(
                "2 2 2 2 \n" +
                "2 2 2 2 \n" +
                "2 2 2 2 \n" +
                "2 2 2 2 \n"
        ));
    }


}
