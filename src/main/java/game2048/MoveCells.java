package game2048;

/**
 * Created by employee on 10/16/15.
 */
public class MoveCells {

    private boolean hasMove;

    public boolean moveUp(Cell[][] cells) {
        hasMove = false;

        for (int j = 0; j < GameField.FIELD_SIZE; j++) {
            upCellsAddition(cells, j);

            upCellsShift(cells, j);
        }

        return hasMove;
    }

    private void upCellsAddition(Cell[][] cells, int j) {
        for (int i = 0; i < GameField.FIELD_SIZE - 1; i++) {
            if (cells[i][j].getCellValue() != 0) {
                int k = i + 1;

                while (k < GameField.FIELD_SIZE) {
                    if (cells[i][j].getCellValue() == cells[k][j].getCellValue()) {
                        verticalCellsAddition(cells, j, i, k);
                        break;
                    } else if (cells[k][j].getCellValue() != 0) {
                        break;
                    }
                    k++;
                }
            }
        }
    }

    private void upCellsShift(Cell[][] cells, int j) {
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

    public boolean moveDown(Cell[][] cells) {
        hasMove = false;

        for (int j = 0; j < GameField.FIELD_SIZE; j++) {
            downCellsAddition(cells, j);

            downCellsShift(cells, j);
        }

        return hasMove;
    }

    private void downCellsAddition(Cell[][] cells, int j) {
        for (int i = GameField.FIELD_SIZE - 1; i > 0; i--) {
            if (cells[i][j].getCellValue() != 0) {
                int k = i - 1;

                while (k >= 0) {
                    if (cells[i][j].getCellValue() == cells[k][j].getCellValue()) {
                        verticalCellsAddition(cells, j, i, k);
                        break;
                    } else if (cells[k][j].getCellValue() != 0) {
                        break;
                    }
                    k--;
                }
            }
        }
    }

    private void downCellsShift(Cell[][] cells, int j) {
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

    public boolean moveLeft(Cell[][] cells){
        hasMove = false;

        for (int i = 0; i < GameField.FIELD_SIZE; i++) {
            leftCellsAddition(cells, i);

            leftCellsShift(cells, i);
        }

        return hasMove;
    }

    private void leftCellsAddition(Cell[][] cells, int i) {
        for (int j = 0; j < GameField.FIELD_SIZE - 1; j++) {
            if (cells[i][j].getCellValue() != 0) {
                int k = j + 1;

                while (k < GameField.FIELD_SIZE) {
                    if (cells[i][j].getCellValue() == cells[i][k].getCellValue()) {
                        horizontalCellsAddition(cells, i, j, k);
                        break;
                    } else if (cells[i][k].getCellValue() != 0) {
                        break;
                    }
                    k++;
                }
            }
        }
    }

    private void leftCellsShift(Cell[][] cells, int i) {
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

    public boolean moveRight(Cell[][] cells){
        hasMove = false;

        for (int i = 0; i < GameField.FIELD_SIZE; i++) {
            rightCellsAddition(cells, i);

            rightCellsShift(cells, i);
        }

        return hasMove;
    }

    private void rightCellsAddition(Cell[][] cells, int i) {
        for (int j = GameField.FIELD_SIZE - 1; j > 0; j--) {
            if (cells[i][j].getCellValue() != 0) {
                int k = j - 1;

                while (k >= 0) {
                    if (cells[i][j].getCellValue() == cells[i][k].getCellValue()) {
                        horizontalCellsAddition(cells, i, j, k);
                        break;
                    } else if (cells[i][k].getCellValue() != 0) {
                        break;
                    }
                    k--;
                }
            }
        }
    }

    private void rightCellsShift(Cell[][] cells, int i) {
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

    private void verticalCellsAddition(Cell[][] cells, int j, int i, int k) {
        cells[i][j].incrementPower();
        GameField.incrementScore(cells[i][j].getCellValue());
        cells[k][j].setCellValue(0);

        hasMove = true;
    }

    private void horizontalCellsAddition(Cell[][] cells, int i, int j, int k) {
        cells[i][j].incrementPower();
        GameField.incrementScore(cells[i][j].getCellValue());
        cells[i][k].setCellValue(0);

        hasMove = true;
    }
}
