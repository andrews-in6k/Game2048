package game2048.gameFieldHandling;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/16/15.
 */
public class GameFieldTest {

    GameField gameField;

    private void fillGameField() {
        for (int i = 0; i < (GameField.FIELD_SQUARE); i++) {
            gameField.fillEmptyCell();
        }
    }

    @Before
    public void setUp() throws Exception {
        gameField = new GameField(new StaticCellValueGenerator(2));
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
        gameField = new GameField(new StaticCellValueGenerator(2), new OneByOneEmptyCellSelector());

        gameField.startNewGame();

        assertThat(gameField.getScore(), is(0));

        assertThat(gameField.toString(), is(
                "2 2 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n"
        ));
    }

    @Test
    public void testFillEmptyCell() {
        fillGameField();

        assertThat(gameField.toString(), is(
                "2 2 2 2 \n" +
                "2 2 2 2 \n" +
                "2 2 2 2 \n" +
                "2 2 2 2 \n"
        ));
    }

    @Test
    public void testValueGeneratorIsUsed() {
        gameField = new GameField(new StaticCellValueGenerator(4));

        gameField.fillEmptyCell();
        assertThat(gameField.toString(), containsString("4"));
    }

    @Test
    public void testHasEmptyCell() {
        assertThat(gameField.hasEmptyCell(), is(true));
    }

    @Test
    public void testHasEmptyCellWithFieldCells() {
        for (int i = 0; i < (GameField.FIELD_SQUARE) - 1; i++) {
            gameField.fillEmptyCell();
        }

        assertThat(gameField.hasEmptyCell(), is(true));
    }

    @Test
    public void testDoesNotHaveEmptyCell() {
        fillGameField();

        assertThat(gameField.hasEmptyCell(), is(false));
    }

    @Test
    public void testDoesNotHaveVictoryCellValue() {
        assertThat(gameField.hasVictoryCellValue(), is(false));
    }

    @Test
    public void testHasVictoryCellValue() {
        gameField = new GameField(new StaticCellValueGenerator(GameField.VALUE_REQUIRED_FOR_VICTORY));

        gameField.fillEmptyCell();

        assertThat(gameField.hasVictoryCellValue(), is(true));
    }

    @Test
    public void testHasAvailableMove(){
        assertThat(gameField.hasAvailableMove(), is(true));

    }

    @Test
    public void testDoesNotHasAvailableMove(){
        gameField = new GameField(new ProgressiveCellValueGenerator());

        fillGameField();

        assertThat(gameField.hasAvailableMove(), is(false));
    }

    @Test
    public void testHasAvailableMoveWhenGameFieldFilled(){
        gameField = new GameField(new ProgressiveCellValueGenerator(), new OneByOneEmptyCellSelector());

        fillGameField();

        gameField.getCells()[0][0].setCellValue(2);
        gameField.getCells()[0][1].setCellValue(2);
        gameField.getCells()[1][0].setCellValue(2);
        gameField.getCells()[2][3].setCellValue(2);
        gameField.getCells()[3][2].setCellValue(2);
        gameField.getCells()[3][0].setCellValue(2);

        assertThat(gameField.hasAvailableMove(), is(true));
    }
}
