package game2048.gameFieldHandling;

import game2048.controllers.Options;
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

    private void getFieldFromIntArray(int[][] tempCellArray) {
        for (int i = 0; i < GameField.FIELD_SIZE; i++) {
            for (int j = 0; j < GameField.FIELD_SIZE; j++) {
                gameField.getCells()[i][j].setCellValue(tempCellArray [i][j]);
            }
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
        gameField = new GameField();

        int[][] tempCellArray = {
                {2, 2, 4, 8},
                {2, 16, 32, 64},
                {128, 256, 512, 2},
                {1024, 2048, 2, 2},
        };

        getFieldFromIntArray(tempCellArray);

        assertThat(gameField.hasAvailableMove(), is(true));
    }

    //CellsMover
    
    //MoveUpTests
    @Test
    public void testMoveUpEmptyField() {
        int[][] tempCellArray = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        getFieldFromIntArray(tempCellArray);

        gameField.moveCells(Options.UP);

        assertThat(gameField.hasMove(), is(false));

        assertThat(gameField.toString(), is(
                "0 0 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n"
        ));
    }

    @Test
    public void testMoveUpNormalCase() {
        int[][] tempCellArray = {
                {2, 4, 0, 16},
                {2, 0, 8, 0},
                {0, 4, 8, 0},
                {0, 0, 0, 16}
        };

        getFieldFromIntArray(tempCellArray);

        gameField.moveCells(Options.UP);

        assertThat(gameField.hasMove(), is(true));

        assertThat(gameField.toString(), is(
                "4 8 16 32 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n"
        ));
    }

    @Test
    public void testMoveUpNextCellWithSameValueCase() {
        int[][] tempCellArray = {
                {4, 2, 2, 4},
                {2, 2, 0, 0},
                {2, 4, 2, 2},
                {0, 0, 4, 2}
        };

        getFieldFromIntArray(tempCellArray);

        gameField.moveCells(Options.UP);

        assertThat(gameField.hasMove(), is(true));

        assertThat(gameField.toString(), is(
                "4 4 4 4 \n" +
                "4 4 4 4 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n"
        ));
    }

    @Test
    public void testMoveUpFourSameCellsInLineCase() {
        int[][] tempCellArray = {
                {2, 2, 4, 4},
                {2, 4, 2, 2},
                {2, 2, 0, 2},
                {2, 4, 2, 2}
        };

        getFieldFromIntArray(tempCellArray);

        gameField.moveCells(Options.UP);

        assertThat(gameField.hasMove(), is(true));

        assertThat(gameField.toString(), is(
                "4 2 4 4 \n" +
                "4 4 4 4 \n" +
                "0 2 0 2 \n" +
                "0 4 0 0 \n"
        ));
    }

    @Test
    public void testMoveUpWithoutAvailableMove() {
        int[][] tempCellArray = {
                {2, 2, 4, 4},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        getFieldFromIntArray(tempCellArray);

        gameField.moveCells(Options.UP);

        assertThat(gameField.hasMove(), is(false));

        assertThat(gameField.toString(), is(
                "2 2 4 4 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n"
        ));
    }
    
    //moveDownTests
    @Test
    public void testMoveDownWithoutAvailableMoves() {
        int[][] tempCellArray = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 4, 2, 2}
        };

        getFieldFromIntArray(tempCellArray);

        gameField.moveCells(Options.DOWN);

        assertThat(gameField.hasMove(), is(false));

        assertThat(gameField.toString(), is(
                "0 0 0 0 \n" +
                "0 0 0 0 \n" +
                "0 0 0 0 \n" +
                "2 4 2 2 \n"
        ));
    }

    @Test
    public void testMoveDownMultipurposeTest() {
        int[][] tempCellArray = {
                {0, 0, 2, 4},
                {4, 2, 2, 2},
                {2, 2, 2, 4},
                {2, 4, 2, 2}
        };

        getFieldFromIntArray(tempCellArray);

        gameField.moveCells(Options.DOWN);

        assertThat(gameField.hasMove(), is(true));

        assertThat(gameField.toString(), is(
                "0 0 0 4 \n" +
                "0 0 0 2 \n" +
                "4 4 4 4 \n" +
                "4 4 4 2 \n"
        ));
    }

    //moveLeftTests
    @Test
    public void testMoveLeftWithoutAvailableMoves() {
        int[][] tempCellArray = {
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {4, 0, 0, 0},
                {2, 0, 0, 0}
        };

        getFieldFromIntArray(tempCellArray);

        gameField.moveCells(Options.LEFT);

        assertThat(gameField.hasMove(), is(false));

        assertThat(gameField.toString(), is(
                "2 0 0 0 \n" +
                "2 0 0 0 \n" +
                "4 0 0 0 \n" +
                "2 0 0 0 \n"
        ));
    }

    @Test
    public void testMoveLeftMultipurposeTest() {
        int[][] tempCellArray = {
                {2, 2, 4, 0},
                {4, 2, 2, 0},
                {2, 2, 2, 2},
                {2, 4, 2, 4}
        };

        getFieldFromIntArray(tempCellArray);

        gameField.moveCells(Options.LEFT);

        assertThat(gameField.hasMove(), is(true));

        assertThat(gameField.toString(), is(
                "4 4 0 0 \n" +
                "4 4 0 0 \n" +
                "4 4 0 0 \n" +
                "2 4 2 4 \n"
        ));
    }

    //moveRightTests
    @Test
    public void testMoveRightWithoutAvailableMoves() {
        int[][] tempCellArray = {
                {0, 0, 0, 2},
                {0, 0, 0, 2},
                {0, 0, 0, 4},
                {0, 0, 0, 2}
        };

        getFieldFromIntArray(tempCellArray);

        gameField.moveCells(Options.RIGHT);

        assertThat(gameField.hasMove(), is(false));

        assertThat(gameField.toString(), is(
                "0 0 0 2 \n" +
                "0 0 0 2 \n" +
                "0 0 0 4 \n" +
                "0 0 0 2 \n"
        ));
    }

    @Test
    public void testMoveRightMultipurposeTest() {
        int[][] tempCellArray = {
                {2, 2, 4, 0},
                {4, 2, 2, 0},
                {2, 2, 2, 2},
                {2, 4, 2, 4}
        };

        getFieldFromIntArray(tempCellArray);

        gameField.moveCells(Options.RIGHT);

        assertThat(gameField.hasMove(), is(true));

        assertThat(gameField.toString(), is(
                "0 0 4 4 \n" +
                "0 0 4 4 \n" +
                "0 0 4 4 \n" +
                "2 4 2 4 \n"
        ));
    }
}
