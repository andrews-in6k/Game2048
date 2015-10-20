//package game2048.gameFieldHandling;
//
//import game2048.cellHandling.Cell;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.core.Is.is;
//
///**
// * Created by employee on 10/16/15.
// */
//public class CellsMoverTest {
//
//    GameField gameField;
//    CellsMover cellsMover;
//
//    private void getFieldFromIntArray(int[][] tempCellArray) {
//        for (int i = 0; i < GameField.FIELD_SIZE; i++) {
//            for (int j = 0; j < GameField.FIELD_SIZE; j++) {
//                gameField.getCells()[i][j].setCellValue(tempCellArray [i][j]);
//            }
//        }
//    }
//
//    @Before
//    public void setUp() {
////        tempCellArray = new int[GameField.FIELD_SIZE][GameField.FIELD_SIZE];
//        gameField = new GameField();
//    }
//
//    @Test
//    public void testCreateCellsMover() {
//        new CellsMover(new GameField());
//    }
//
//    @Test
//    public void testMoveUpEmptyField() {
//        int[][] tempCellArray = {
//                {0, 0, 0, 0},
//                {0, 0, 0, 0},
//                {0, 0, 0, 0},
//                {0, 0, 0, 0}
//        };
//
//        getFieldFromIntArray(tempCellArray);
//
//        cellsMover = new CellsMover(gameField);
//
//        assertThat(cellsMover.moveUp(), is(false));
//
//        assertThat(gameField.toString(), is(
//                "0 0 0 0 \n" +
//                "0 0 0 0 \n" +
//                "0 0 0 0 \n" +
//                "0 0 0 0 \n"
//        ));
//    }
//
//    @Test
//    public void testMoveUpNormalCase() {
//        int[][] tempCellArray = {
//                {2, 4, 0, 16},
//                {2, 0, 8, 0},
//                {0, 4, 8, 0},
//                {0, 0, 0, 16}
//        };
//
//        getFieldFromIntArray(tempCellArray);
//
//        cellsMover = new CellsMover(gameField);
//
//        assertThat(cellsMover.moveUp(), is(true));
//
//        assertThat(gameField.toString(), is(
//                "4 8 16 32 \n" +
//                "0 0 0 0 \n" +
//                "0 0 0 0 \n" +
//                "0 0 0 0 \n"
//        ));
//    }
//
//    @Test
//    public void testMoveUpNextCellWithSameValueCase() {
//        int[][] tempCellArray = {
//                {4, 2, 2, 4},
//                {2, 2, 0, 0},
//                {2, 4, 2, 2},
//                {0, 0, 4, 2}
//        };
//
//        getFieldFromIntArray(tempCellArray);
//
//        cellsMover = new CellsMover(gameField);
//
//        assertThat(cellsMover.moveUp(), is(true));
//
//        assertThat(gameField.toString(), is(
//                "4 4 4 4 \n" +
//                "4 4 4 4 \n" +
//                "0 0 0 0 \n" +
//                "0 0 0 0 \n"
//        ));
//    }
//
//    @Test
//    public void testMoveUpFourSameCellsInLineCase() {
//        int[][] tempCellArray = {
//                {2, 2, 4, 4},
//                {2, 4, 2, 2},
//                {2, 2, 0, 2},
//                {2, 4, 2, 2}
//        };
//
//        getFieldFromIntArray(tempCellArray);
//
//        cellsMover = new CellsMover(gameField);
//
//        assertThat(cellsMover.moveUp(), is(true));
//
//        assertThat(gameField.toString(), is(
//                "4 2 4 4 \n" +
//                "4 4 4 4 \n" +
//                "0 2 0 2 \n" +
//                "0 4 0 0 \n"
//        ));
//    }
//
//    @Test
//    public void testMoveUpWithoutAvailableMove() {
//        int[][] tempCellArray = {
//                {2, 2, 4, 4},
//                {0, 0, 0, 0},
//                {0, 0, 0, 0},
//                {0, 0, 0, 0}
//        };
//
//        getFieldFromIntArray(tempCellArray);
//
//        cellsMover = new CellsMover(gameField);
//
//        assertThat(cellsMover.moveUp(), is(false));
//
//        assertThat(gameField.toString(), is(
//                "2 2 4 4 \n" +
//                "0 0 0 0 \n" +
//                "0 0 0 0 \n" +
//                "0 0 0 0 \n"
//        ));
//    }
//}
