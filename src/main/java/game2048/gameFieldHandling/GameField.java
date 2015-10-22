package game2048.gameFieldHandling;

import game2048.cellHandling.Cell;
import game2048.controllers.Options;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 10/16/15.
 */
public class GameField {
    public static final int FIELD_SIZE = 4;
    public static final int FIELD_SQUARE = FIELD_SIZE * FIELD_SIZE;
    public static final int NEW_GAME_NUMBERS_COUNT = 2;
    public static final int VALUE_REQUIRED_FOR_VICTORY = 2048;

    private int score = 0;

    private Cell[][] cells = new Cell[FIELD_SIZE][FIELD_SIZE];

    private List<Cell> emptyCellsList;

    CellValueGenerator cellValueGenerator;
    EmptyCellSelector emptyCellSelector;

    private boolean hasMove;

    public GameField() {
        initEmptyField();

        emptyCellSelector = new RandomEmptyCellSelector();
        cellValueGenerator = new RandomCellValueGenerator();
    }

    public GameField(CellValueGenerator cellValueGenerator) {
        initEmptyField();

        emptyCellSelector = new RandomEmptyCellSelector();
        this.cellValueGenerator = cellValueGenerator;
    }

    public GameField(CellValueGenerator cellValueGenerator, EmptyCellSelector emptyCellSelector) {
        this(cellValueGenerator);

        this.emptyCellSelector = emptyCellSelector;
    }

    public void startNewGame() {
        initEmptyField();

        for (int i = 0; i < NEW_GAME_NUMBERS_COUNT; i++) {
            fillEmptyCell();
        }
    }

    private void initEmptyField() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                cells[i][j] = new Cell();
            }
        }

        score = 0;
    }

    public void fillEmptyCell() {
        if (hasEmptyCell()) {
            fillEmptyCellsList();

            emptyCellSelector.getEmptyCell(emptyCellsList).setCellValue(cellValueGenerator.generateCellValue());
        }
    }

    private void fillEmptyCellsList() {
        emptyCellsList = new ArrayList<>();

        for (int i = 0; i < GameField.FIELD_SIZE; i++) {
            for (int j = 0; j < GameField.FIELD_SIZE; j++) {
                if (cells[i][j].isEmpty()) {
                    emptyCellsList.add(cells[i][j]);
                }
            }
        }
    }

    public boolean hasEmptyCell() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (cells[i][j].isEmpty()) {
                    return true;
                }
            }
        }

        return false;
    }


    public boolean moveCells(Options options) {
        CellsMover cellsMover = new CellsMover();
        hasMove = false;

        switch (options) {
            case UP:
                cellsMover.moveUp();
                break;
            case DOWN:
                cellsMover.moveDown();
                break;
            case LEFT:
                cellsMover.moveLeft();
                break;
            case RIGHT:
                cellsMover.moveRight();
                break;
        }

        return hasMove;
    }

    protected boolean hasMove() {
        return hasMove;
    }

    public boolean hasVictoryCellValue() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (cells[i][j].getCellValue() == VALUE_REQUIRED_FOR_VICTORY) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasAvailableMove() {
        return hasEmptyCell() || detectAvailableMoves();
    }

    private boolean detectAvailableMoves() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (i != (FIELD_SIZE - 1)) {
                    if (cells[i][j].equals(cells[i + 1][j])){
                        return true;
                    }
                }

                if (j != (FIELD_SIZE - 1)) {
                    if (cells[i][j].equals(cells[i][j + 1])){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private void incrementScore(int value) {
        score += value;
    }

    public int getScore() {
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

    //Class CellsMover
    protected class CellsMover {

        private int row;
        private int col;
        private int tempIndex;

        public void moveUp() {
            for (col = 0; col < GameField.FIELD_SIZE; col++) {
                upCellsAddition();
                upCellsShift();
            }
        }

        public void moveDown() {
            for (col = 0; col < GameField.FIELD_SIZE; col++) {
                downCellsAddition();
                downCellsShift();
            }
        }

        public void moveLeft() {
            for (row = 0; row < GameField.FIELD_SIZE; row++) {
                leftCellsAddition();
                leftCellsShift();
            }
        }

        public void moveRight() {
            for (row = 0; row < GameField.FIELD_SIZE; row++) {
                rightCellsAddition();
                rightCellsShift();
            }
        }

        private void upCellsAddition() {
            for (row = 0; row < GameField.FIELD_SIZE - 1; row++) {
                if (!cells[row][col].isEmpty()) {
                    tempIndex = row + 1;

                    while (tempIndex < GameField.FIELD_SIZE) {
                        if (cells[row][col].equals(cells[tempIndex][col])) {
                            verticalCellsAddition();
                            break;
                        } else if (!cells[tempIndex][col].isEmpty()) {
                            break;
                        }
                        tempIndex++;
                    }
                }
            }
        }

        private void upCellsShift() {
            for (row = 1; row < GameField.FIELD_SIZE; row++) {
                if (!cells[row][col].isEmpty()) {
                    while ((row != 0) && (cells[row - 1][col].isEmpty())) {
                        cells[row - 1][col].setCellValue(cells[row][col].getCellValue());
                        cells[row][col].setCellValue(0);

                        hasMove = true;
                        row--;
                    }
                }
            }
        }

        private void downCellsAddition() {
            for (row = GameField.FIELD_SIZE - 1; row > 0; row--) {
                if (!cells[row][col].isEmpty()) {
                    tempIndex = row - 1;

                    while (tempIndex >= 0) {
                        if (cells[row][col].equals(cells[tempIndex][col])) {
                            verticalCellsAddition();
                            break;
                        } else if (!cells[tempIndex][col].isEmpty()) {
                            break;
                        }
                        tempIndex--;
                    }
                }
            }
        }

        private void downCellsShift() {
            for (row = GameField.FIELD_SIZE - 2; row >= 0; row--) {
                if (!cells[row][col].isEmpty()) {
                    while ((row != GameField.FIELD_SIZE - 1) && (cells[row + 1][col].isEmpty())) {
                        cells[row + 1][col].setCellValue(cells[row][col].getCellValue());
                        cells[row][col].setCellValue(0);

                        hasMove = true;
                        row++;
                    }
                }
            }
        }

        private void verticalCellsAddition() {
            cells[row][col].incrementPower();
            incrementScore(cells[row][col].getCellValue());
            cells[tempIndex][col].setCellValue(0);

            hasMove = true;
        }

        private void leftCellsAddition() {
            for (col = 0; col < GameField.FIELD_SIZE - 1; col++) {
                if (!cells[row][col].isEmpty()) {
                    tempIndex = col + 1;

                    while (tempIndex < GameField.FIELD_SIZE) {
                        if (cells[row][col].equals(cells[row][tempIndex])) {
                            horizontalCellsAddition();
                            break;
                        } else if (!cells[row][tempIndex].isEmpty()) {
                            break;
                        }
                        tempIndex++;
                    }
                }
            }
        }

        private void leftCellsShift() {
            for (col = 1; col < GameField.FIELD_SIZE; col++) {
                if (!cells[row][col].isEmpty()) {
                    while ((col != 0) && (cells[row][col - 1].isEmpty())) {
                        cells[row][col - 1].setCellValue(cells[row][col].getCellValue());
                        cells[row][col].setCellValue(0);

                        hasMove = true;
                        col--;
                    }
                }
            }
        }

        private void rightCellsAddition() {
            for (col = GameField.FIELD_SIZE - 1; col > 0; col--) {
                if (!cells[row][col].isEmpty()) {
                    tempIndex = col - 1;

                    while (tempIndex >= 0) {
                        if (cells[row][col].equals(cells[row][tempIndex])) {
                            horizontalCellsAddition();
                            break;
                        } else if (!cells[row][tempIndex].isEmpty()) {
                            break;
                        }
                        tempIndex--;
                    }
                }
            }
        }

        private void rightCellsShift() {
            for (col = GameField.FIELD_SIZE - 2; col >= 0; col--) {
                if (!cells[row][col].isEmpty()) {
                    while ((col != GameField.FIELD_SIZE - 1) && (cells[row][col + 1].isEmpty())) {
                        cells[row][col + 1].setCellValue(cells[row][col].getCellValue());
                        cells[row][col].setCellValue(0);

                        hasMove = true;
                        col++;
                    }
                }
            }
        }

        private void horizontalCellsAddition() {
            cells[row][col].incrementPower();
            incrementScore(cells[row][col].getCellValue());
            cells[row][tempIndex].setCellValue(0);

            hasMove = true;
        }
    }
}
