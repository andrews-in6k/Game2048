package game2048;

/**
 * Created by employee on 10/16/15.
 */
public class MoveCells {

    public void moveUp(Cell[][] cell) {
        for (int j = 0; j < GameField.FIELD_SIZE; j++) {
            for (int i = 0; i < GameField.FIELD_SIZE - 1; i++) {
                if (cell[i][j].getCellValue() != 0) {
                    int k = i + 1;
                    while (k < GameField.FIELD_SIZE) {
                        if (cell[i][j].getCellValue() == cell[k][j].getCellValue()) {
                            cell[i][j].incrementPower();
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
                        i--;
                    }
                }
            }
        }
    }
}
