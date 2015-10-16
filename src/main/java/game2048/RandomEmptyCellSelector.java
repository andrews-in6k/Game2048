package game2048;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by employee on 10/16/15.
 */
public class RandomEmptyCellSelector implements EmptyCellSelector {

    private int randomResult;

    private List<int[]> emptyCellList = new ArrayList<>();

    public RandomEmptyCellSelector(Cell[][] cell) {
        for (int i = 0; i < GameField.FIELD_SIZE; i++) {
            for (int j = 0; j < GameField.FIELD_SIZE; j++) {
                if (cell[i][j].getCellValue() == 0) {
                    int[] emptyCellIndexes = new int[2];
                    emptyCellIndexes[0] = i;
                    emptyCellIndexes[1] = j;
                    emptyCellList.add(emptyCellIndexes);
                }
            }
        }

        if (!emptyCellList.isEmpty()) {
            Random random = new Random();
            randomResult = random.nextInt(emptyCellList.size());
        }
    }

    public int getRowIndex() {
        return emptyCellList.get(randomResult)[0];
    }

    public int getColumnIndex() {
        return emptyCellList.get(randomResult)[1];
    }
}
