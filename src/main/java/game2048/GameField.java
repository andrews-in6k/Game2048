package game2048;

/**
 * Created by employee on 10/16/15.
 */
public class GameField {
    public static final int FIELD_SIZE = 4;

    private int[][] cell = new int[FIELD_SIZE][FIELD_SIZE];

    private String cells = "";

    CellValueGenerator cellValueGenerator;

    public GameField(CellValueGenerator cellValueGenerator){
        this.cellValueGenerator = cellValueGenerator;
    }

    public String toString() {
        cells = "";

        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                cells += cell[i][j] + " ";
            }

            cells += "\n";
        }

        return cells;
    }


    public void fillEmptyCell() {
        if (hasEmptyCell()) {
            EmptyCellSelector emptyCellSelector = new RandomEmptyCellSelector(cell);

            int i = emptyCellSelector.getRowIndex();
            int j = emptyCellSelector.getColumnIndex();

            cell[i][j] = cellValueGenerator.generateCellValue();
        }
    }


    public boolean hasEmptyCell() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (cell[i][j] == 0){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasCellWith2048() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (cell[i][j] == 2048){
                    return true;
                }
            }
        }
        return false;
    }
}
