package game2048;

/**
 * Created by employee on 10/16/15.
 */
public class MoveCells {

    private boolean hasMove;

    public boolean moveUp(Cell[][] cell) {
        hasMove = false;

        for (int j = 0; j < GameField.FIELD_SIZE; j++) {
            for (int i = 0; i < GameField.FIELD_SIZE - 1; i++) {
                if (cell[i][j].getCellValue() != 0) {
                    int k = i + 1;
                    while (k < GameField.FIELD_SIZE) {
                        if (cell[i][j].getCellValue() == cell[k][j].getCellValue()) {
                            cell[i][j].incrementPower();
                            hasMove = true;
                            GameField.incrementScore(cell[i][j].getCellValue());
                            cell[k][j].setCellValue(0);
                            break;
                        } else if (cell[k][j].getCellValue() != 0) {
                            break;
                        }
                        k++;
                    }
                }
            }

            for (int i = 1; i < GameField.FIELD_SIZE; i++) {
                if (cell[i][j].getCellValue() != 0) {
                    while ((i != 0) && (cell[i - 1][j].getCellValue() == 0)) {
                        cell[i - 1][j].setCellValue(cell[i][j].getCellValue());
                        cell[i][j].setCellValue(0);
                        hasMove = true;
                        i--;
                    }
                }
            }
        }

        return hasMove;
    }

    public boolean moveDown(Cell[][] cell) {
        hasMove = false;

        for (int j = 0; j < GameField.FIELD_SIZE; j++) {
            for (int i = GameField.FIELD_SIZE - 1; i > 0; i--) {
                if (cell[i][j].getCellValue() != 0) {
                    int k = i - 1;
                    while (k >= 0) {
                        if (cell[i][j].getCellValue() == cell[k][j].getCellValue()) {
                            cell[i][j].incrementPower();
                            hasMove = true;
                            GameField.incrementScore(cell[i][j].getCellValue());
                            cell[k][j].setCellValue(0);
                            break;
                        } else if (cell[k][j].getCellValue() != 0) {
                            break;
                        }
                        k--;
                    }
                }
            }

            for (int i = GameField.FIELD_SIZE - 2; i >= 0; i--) {
                if (cell[i][j].getCellValue() != 0) {
                    while ((i != GameField.FIELD_SIZE - 1) && (cell[i + 1][j].getCellValue() == 0)) {
                        cell[i + 1][j].setCellValue(cell[i][j].getCellValue());
                        cell[i][j].setCellValue(0);
                        hasMove = true;
                        i++;
                    }
                }
            }
        }

        return hasMove;
    }

    public boolean moveLeft(Cell[][] cell){
        hasMove = false;

        for (int i = 0; i < GameField.FIELD_SIZE; i++) {
            for (int j = 0; j < GameField.FIELD_SIZE - 1; j++) {
                if (cell[i][j].getCellValue() != 0) {
                    int k = j + 1;
                    while (k < GameField.FIELD_SIZE) {
                        if (cell[i][j].getCellValue() == cell[i][k].getCellValue()) {
                            cell[i][j].incrementPower();
                            hasMove = true;
                            GameField.incrementScore(cell[i][j].getCellValue());
                            cell[i][k].setCellValue(0);
                            break;
                        } else if (cell[i][k].getCellValue() != 0) {
                            break;
                        }
                        k++;
                    }
                }
            }

            for (int j = 1; j < GameField.FIELD_SIZE; j++) {
                if (cell[i][j].getCellValue() != 0) {
                    while ((j != 0) && (cell[i][j - 1].getCellValue() == 0)) {
                        cell[i][j - 1].setCellValue(cell[i][j].getCellValue());
                        cell[i][j].setCellValue(0);
                        hasMove = true;
                        j--;
                    }
                }
            }
        }

        return hasMove;
    }

    public boolean moveRight(Cell[][] cell){
        hasMove = false;

        for (int i = 0; i < GameField.FIELD_SIZE; i++) {
            for (int j = GameField.FIELD_SIZE - 1; j > 0; j--) {
                if (cell[i][j].getCellValue() != 0) {
                    int k = j - 1;
                    while (k >= 0) {
                        if (cell[i][j].getCellValue() == cell[i][k].getCellValue()) {
                            cell[i][j].incrementPower();
                            hasMove = true;
                            GameField.incrementScore(cell[i][j].getCellValue());
                            cell[i][k].setCellValue(0);
                            break;
                        } else if (cell[i][k].getCellValue() != 0) {
                            break;
                        }
                        k--;
                    }
                }
            }

            for (int j = GameField.FIELD_SIZE - 2; j >= 0; j--) {
                if (cell[i][j].getCellValue() != 0) {
                    while ((j != GameField.FIELD_SIZE - 1) && (cell[i][j + 1].getCellValue() == 0)) {
                        cell[i][j + 1].setCellValue(cell[i][j].getCellValue());
                        cell[i][j].setCellValue(0);
                        hasMove = true;
                        j++;
                    }
                }
            }
        }

        return hasMove;
    }
}
