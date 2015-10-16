import game2048.GameField;
import game2048.RandomCellValueGenerator;
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
        new GameField(new RandomCellValueGenerator());
    }

    @Test
    public void testGameFieldToString() {
        GameField gameField = new GameField(new RandomCellValueGenerator());
        assertThat(gameField.toString(), is(
                "0 0 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n"
        ));
    }

    @Test
    public void testFillEmptyCell() {
        GameField gameField = new GameField(new StaticCellValueGenerator(4));


        gameField.fillEmptyCell();
        assertThat(gameField.toString(), containsString("4"));

        gameField = new GameField(new StaticCellValueGenerator(2));

        gameField.fillEmptyCell();
        assertThat(gameField.toString(), containsString("2"));

        for (int i = 0; i < (gameField.FIELD_SIZE * gameField.FIELD_SIZE); i++) {
            gameField.fillEmptyCell();
        }
        assertThat(gameField.toString(), is(
                "2 2 2 2 \n" +
                "2 2 2 2 \n" +
                "2 2 2 2 \n" +
                "2 2 2 2 \n"
        ));
    }

    @Test
    public void testHasEmpty(){
        GameField gameField = new GameField(new RandomCellValueGenerator());

        assertThat(gameField.hasEmpty(), is(true));

        for (int i = 0; i < (gameField.FIELD_SIZE * gameField.FIELD_SIZE); i++) {
            gameField.fillEmptyCell();
        }

        assertThat(gameField.hasEmpty(), is(false));
    }


}
