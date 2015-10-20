package game2048.gameFieldHandling;

import game2048.cellHandling.Cell;

/**
 * Created by employee on 10/16/15.
 */
public class MoveCells {

    private boolean hasMove;

    private Cell[][] cells;

    private int row;
    private int col;
    private int tempIndex;

    public MoveCells(Cell[][] cells) {
        this.cells = cells;

        hasMove = false;
    }

    public boolean moveUp() {
        for (col = 0; col < GameField.FIELD_SIZE; col++) {
            upCellsAddition();
            upCellsShift();
        }

        return hasMove;
    }

    public boolean moveDown() {
        for (col = 0; col < GameField.FIELD_SIZE; col++) {
            downCellsAddition();
            downCellsShift();
        }

        return hasMove;
    }

    public boolean moveLeft() {
        for (row = 0; row < GameField.FIELD_SIZE; row++) {
            leftCellsAddition();
            leftCellsShift();
        }

        return hasMove;
    }

    public boolean moveRight() {
        for (row = 0; row < GameField.FIELD_SIZE; row++) {
            rightCellsAddition();
            rightCellsShift();
        }

        return hasMove;
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
        GameField.incrementScore(cells[row][col].getCellValue());
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
        GameField.incrementScore(cells[row][col].getCellValue());
        cells[row][tempIndex].setCellValue(0);

        hasMove = true;
    }
}
