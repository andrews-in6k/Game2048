package game2048;

/**
 * Created by employee on 10/16/15.
 */
public class GameField {
    public static final int FIELD_SIZE = 4;
    public static final int NEW_GAME_NUMBERS_COUNT = 2;
    public static final int VALUE_REQUIRED_FOR_VICTORY = 2048;

    private static int score = 0;

    private Cell[][] cells = new Cell[FIELD_SIZE][FIELD_SIZE];

    CellValueGenerator cellValueGenerator;

    public GameField(CellValueGenerator cellValueGenerator){
        initEmptyCells();

        this.cellValueGenerator = cellValueGenerator;
    }

    public void startNewGame() {
        initEmptyCells();

        score = 0;

        for (int i = 0; i < NEW_GAME_NUMBERS_COUNT; i++) {
            fillEmptyCell();
        }
    }

    private void initEmptyCells(){
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public void fillEmptyCell() {
        if (hasEmptyCell()) {
            EmptyCellSelector emptyCellSelector = new RandomEmptyCellSelector(cells);

            emptyCellSelector.getEmptyCell().setCellValue(cellValueGenerator.generateCellValue());
        }
    }


    public boolean hasEmptyCell() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (cells[i][j].getCellValue() == 0){
                    return true;
                }
            }
        }

        return false;
    }


    public void moveCells(Direction direction) {
        MoveCells moveCells = new MoveCells(cells);
        Boolean hasMove = false;

        switch (direction) {
            case UP:
                hasMove = moveCells.moveUp();
                break;
            case DOWN:
                hasMove = moveCells.moveDown();
                break;
            case LEFT:
                hasMove = moveCells.moveLeft();
                break;
            case RIGHT:
                hasMove = moveCells.moveRight();
                break;
        }

        if (hasMove) {
            fillEmptyCell();
        }
    }

    public boolean hasCellWithValueRequiredForVictory() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (cells[i][j].getCellValue() == VALUE_REQUIRED_FOR_VICTORY){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasAvailableMove() {
        if (hasEmptyCell()) {
            return true;
        } else {
            for (int i = 0; i < FIELD_SIZE; i++) {
                for (int j = 0; j < FIELD_SIZE; j++) {
                    if (i != FIELD_SIZE - 1){
                        if (cells[i][j].getCellValue() == cells[i + 1][j].getCellValue()) {
                            return true;
                        }
                    }

                    if (j != FIELD_SIZE - 1){
                        if (cells[i][j].getCellValue() == cells[i][j + 1].getCellValue()) {
                            return true;
                        }
                    }
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

    public Cell[][] getCells() {
        return cells;
    }

    public String toString() {
        String cells = "";

        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                cells += this.cells[i][j].getCellValue() + " ";
            }

            cells += "\n";
        }

        return cells;
    }
}
