package game2048;

/**
 * Created by employee on 10/16/15.
 */
public class GameField {
    public static final int FIELD_SIZE = 4;

    private int[][] cellsValues = new int[FIELD_SIZE][FIELD_SIZE];

    private String cells = "";

    public String toString() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                cells += cellsValues[i][j] + " ";
            }

            cells += "\n";
        }

        return cells;
    }


    public void fillEmptyCell(int value) {
        cellsValues[0][0] = value;
    }


}
