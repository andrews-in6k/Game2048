package game2048.gameFieldHandling;

import game2048.cellHandling.Cell;
import game2048.controllers.Direction;

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


    public void moveCells(Direction direction) {
        CellsMover cellsMover = new CellsMover(this);
        Boolean hasMove = false;

        switch (direction) {
            case UP:
                hasMove = cellsMover.moveUp();
                break;
            case DOWN:
                hasMove = cellsMover.moveDown();
                break;
            case LEFT:
                hasMove = cellsMover.moveLeft();
                break;
            case RIGHT:
                hasMove = cellsMover.moveRight();
                break;
        }

        if (hasMove) {
            fillEmptyCell();
        }
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

    public void incrementScore(int value) {
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
}
