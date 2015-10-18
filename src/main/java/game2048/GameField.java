package game2048;

/**
 * Created by employee on 10/16/15.
 */
public class GameField {
    public static final int FIELD_SIZE = 4;
    public static final int VALUE_REQUIRED_FOR_VICTORY = 2048;

    private static int score;

    private Cell[][] cell = new Cell[FIELD_SIZE][FIELD_SIZE];

    CellValueGenerator cellValueGenerator;

    public GameField(CellValueGenerator cellValueGenerator){
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                cell[i][j] = new Cell();
            }
        }

        score = 0;

        this.cellValueGenerator = cellValueGenerator;
    }

    public String toString() {
        String cells = "";

        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                cells += cell[i][j].getCellValue() + " ";
            }

            cells += "\n";
        }

        return cells;
    }


    public void fillEmptyCell() {
        if (hasEmptyCell()) {
            EmptyCellSelector emptyCellSelector = new RandomEmptyCellSelector();

            emptyCellSelector.getEmptyCell(cell).setCellValue(cellValueGenerator.generateCellValue());
        }
    }


    public boolean hasEmptyCell() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (cell[i][j].getCellValue() == 0){
                    return true;
                }
            }
        }
        return false;
    }

    public void move(Direction direction) {
        MoveCells moveCells = new MoveCells();

        switch (direction) {
            case UP:
                moveCells.moveUp(cell);
                break;
            case DOWN:

                break;
            case LEFT:

                break;
            case RIGHT:

                break;
        }
    }

    public boolean hasCellWith2048() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (cell[i][j].getCellValue() == VALUE_REQUIRED_FOR_VICTORY){
                    return true;
                }
            }
        }
        return false;
    }

    public static void incrementScore(int value) {
        GameField.score += value;
    }

    public static int getScore() {
        return score;
    }
}
