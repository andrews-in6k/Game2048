package game2048.gameFieldHandling;

import game2048.cellHandling.Cell;

import java.util.List;
import java.util.Random;

/**
 * Created by employee on 10/16/15.
 */
public class RandomEmptyCellSelector implements EmptyCellSelector {

    public Cell getEmptyCell(List<Cell> emptyCellsList) {
        int randomResult = 0;

        if (!emptyCellsList.isEmpty()) {
            Random random = new Random();
            randomResult = random.nextInt(emptyCellsList.size());
        }

        return emptyCellsList.get(randomResult);
    }

}
