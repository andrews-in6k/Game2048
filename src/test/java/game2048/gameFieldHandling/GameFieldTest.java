package game2048.gameFieldHandling;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/16/15.
 */
public class GameFieldTest {

    GameField gameField;

    @Test
    public void testCreateGameField() {
        new GameField();
    }

    @Test
    public void testGameFieldToString() {
        gameField = new GameField();

        assertThat(gameField.toString(), is(
                "0 0 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n"
        ));
    }

    @Test
    public void testStartGame() {
        gameField = new GameField(new StaticCellValueGenerator(2));

        gameField.startNewGame();

        assertThat(GameField.getScore(), is(0));

        assertThat(gameField.toString(), containsString("2"));
    }

    @Test
    public void testFillEmptyCell() {
        gameField = new GameField(new StaticCellValueGenerator(4));

        gameField.fillEmptyCell();
        assertThat(gameField.toString(), containsString("4"));

        gameField = new GameField(new StaticCellValueGenerator(2));

        gameField.fillEmptyCell();
        assertThat(gameField.toString(), containsString("2"));

        for (int i = 0; i < (GameField.FIELD_SIZE * GameField.FIELD_SIZE); i++) {
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
    public void testHasEmptyCell() {
        gameField = new GameField();

        assertThat(gameField.hasEmptyCell(), is(true));

        for (int i = 0; i < (GameField.FIELD_SIZE * GameField.FIELD_SIZE); i++) {
            gameField.fillEmptyCell();
        }

        assertThat(gameField.hasEmptyCell(), is(false));
    }

    @Test
    public void testHasCellWithValueRequiredForVictory() {
        gameField = new GameField(new StaticCellValueGenerator(GameField.VALUE_REQUIRED_FOR_VICTORY));

        assertThat(gameField.hasCellWithValueRequiredForVictory(), is(false));

        gameField.fillEmptyCell();

        assertThat(gameField.hasCellWithValueRequiredForVictory(), is(true));
    }

    @Test
    public void testHasAvailableMove(){
        gameField = new GameField(new StaticCellValueGenerator(2));

        assertThat(gameField.hasAvailableMove(), is(true));

        for (int i = 0; i < (GameField.FIELD_SIZE * GameField.FIELD_SIZE); i++) {
            gameField.fillEmptyCell();
        }

        assertThat(gameField.hasAvailableMove(), is(true));

        gameField = new GameField(new ProgressiveCellValueGenerator());

        for (int i = 0; i < (GameField.FIELD_SIZE * GameField.FIELD_SIZE); i++) {
            gameField.fillEmptyCell();
        }

        assertThat(gameField.hasAvailableMove(), is(false));
    }
}
