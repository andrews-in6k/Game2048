package game2048;

/**
 * Created by employee on 10/16/15.
 */
public class MoveCells {

    private boolean hasMove;

    private Cell[][] cells;

    public MoveCells(Cell[][] cells) {
        this.cells = cells;

        hasMove = false;
    }

    public boolean moveUp() {
        for (int j = 0; j < GameField.FIELD_SIZE; j++) {
            upCellsAddition(j);

            upCellsShift(j);
        }

        return hasMove;
    }

    public boolean moveDown() {
        for (int j = 0; j < GameField.FIELD_SIZE; j++) {
            downCellsAddition(j);

            downCellsShift(j);
        }

        return hasMove;
    }

    public boolean moveLeft(){
        for (int i = 0; i < GameField.FIELD_SIZE; i++) {
            leftCellsAddition(i);

            leftCellsShift(i);
        }

        return hasMove;
    }

    public boolean moveRight(){
        for (int i = 0; i < GameField.FIELD_SIZE; i++) {
            rightCellsAddition(i);

            rightCellsShift(i);
        }

        return hasMove;
    }

    private void upCellsAddition(int j) {
        for (int i = 0; i < GameField.FIELD_SIZE - 1; i++) {
            if (cells[i][j].getCellValue() != 0) {
                int k = i + 1;

                while (k < GameField.FIELD_SIZE) {
                    if (cells[i][j].getCellValue() == cells[k][j].getCellValue()) {
                        verticalCellsAddition(j, i, k);
                        break;
                    } else if (cells[k][j].getCellValue() != 0) {
                        break;
                    }
                    k++;
                }
            }
        }
    }

    private void upCellsShift(int j) {
        for (int i = 1; i < GameField.FIELD_SIZE; i++) {
            if (cells[i][j].getCellValue() != 0) {
                while ((i != 0) && (cells[i - 1][j].getCellValue() == 0)) {
                    cells[i - 1][j].setCellValue(cells[i][j].getCellValue());
                    cells[i][j].setCellValue(0);

                    hasMove = true;
                    i--;
                }
            }
        }
    }

    private void downCellsAddition(int j) {
        for (int i = GameField.FIELD_SIZE - 1; i > 0; i--) {
            if (cells[i][j].getCellValue() != 0) {
                int k = i - 1;

                while (k >= 0) {
                    if (cells[i][j].getCellValue() == cells[k][j].getCellValue()) {
                        verticalCellsAddition(j, i, k);
                        break;
                    } else if (cells[k][j].getCellValue() != 0) {
                        break;
                    }
                    k--;
                }
            }
        }
    }

    private void downCellsShift(int j) {
        for (int i = GameField.FIELD_SIZE - 2; i >= 0; i--) {
            if (cells[i][j].getCellValue() != 0) {
                while ((i != GameField.FIELD_SIZE - 1) && (cells[i + 1][j].getCellValue() == 0)) {
                    cells[i + 1][j].setCellValue(cells[i][j].getCellValue());
                    cells[i][j].setCellValue(0);

                    hasMove = true;
                    i++;
                }
            }
        }
    }

    private void verticalCellsAddition(int j, int i, int k) {
        cells[i][j].incrementPower();
        GameField.incrementScore(cells[i][j].getCellValue());
        cells[k][j].setCellValue(0);

        hasMove = true;
    }

    private void leftCellsAddition(int i) {
        for (int j = 0; j < GameField.FIELD_SIZE - 1; j++) {
            if (cells[i][j].getCellValue() != 0) {
                int k = j + 1;

                while (k < GameField.FIELD_SIZE) {
                    if (cells[i][j].getCellValue() == cells[i][k].getCellValue()) {
                        horizontalCellsAddition(i, j, k);
                        break;
                    } else if (cells[i][k].getCellValue() != 0) {
                        break;
                    }
                    k++;
                }
            }
        }
    }

    private void leftCellsShift(int i) {
        for (int j = 1; j < GameField.FIELD_SIZE; j++) {
            if (cells[i][j].getCellValue() != 0) {
                while ((j != 0) && (cells[i][j - 1].getCellValue() == 0)) {
                    cells[i][j - 1].setCellValue(cells[i][j].getCellValue());
                    cells[i][j].setCellValue(0);

                    hasMove = true;
                    j--;
                }
            }
        }
    }

    private void rightCellsAddition(int i) {
        for (int j = GameField.FIELD_SIZE - 1; j > 0; j--) {
            if (cells[i][j].getCellValue() != 0) {
                int k = j - 1;

                while (k >= 0) {
                    if (cells[i][j].getCellValue() == cells[i][k].getCellValue()) {
                        horizontalCellsAddition(i, j, k);
                        break;
                    } else if (cells[i][k].getCellValue() != 0) {
                        break;
                    }
                    k--;
                }
            }
        }
    }

    private void rightCellsShift(int i) {
        for (int j = GameField.FIELD_SIZE - 2; j >= 0; j--) {
            if (cells[i][j].getCellValue() != 0) {
                while ((j != GameField.FIELD_SIZE - 1) && (cells[i][j + 1].getCellValue() == 0)) {
                    cells[i][j + 1].setCellValue(cells[i][j].getCellValue());
                    cells[i][j].setCellValue(0);

                    hasMove = true;
                    j++;
                }
            }
        }
    }

    private void horizontalCellsAddition(int i, int j, int k) {
        cells[i][j].incrementPower();
        GameField.incrementScore(cells[i][j].getCellValue());
        cells[i][k].setCellValue(0);

        hasMove = true;
    }
}
