package game2048;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by employee on 10/16/15.
 */
public class RandomEmptyCellSelector implements EmptyCellSelector {

    private List<Cell> emptyCellList = new ArrayList<>();

    public Cell getEmptyCell(Cell[][] cells) {
        for (int i = 0; i < GameField.FIELD_SIZE; i++) {
            for (int j = 0; j < GameField.FIELD_SIZE; j++) {
                if (cells[i][j].getCellValue() == 0) {
                    emptyCellList.add(cells[i][j]);
                }
            }
        }

        int randomResult = 0;
        if (!emptyCellList.isEmpty()) {
            Random random = new Random();
            randomResult = random.nextInt(emptyCellList.size());
        }

        return emptyCellList.get(randomResult);
    }

}
