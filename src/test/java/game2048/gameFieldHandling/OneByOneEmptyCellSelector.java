package game2048.gameFieldHandling;

import game2048.cellHandling.Cell;

import java.util.List;

/**
 * Created by employee on 10/20/15.
 */
public class OneByOneEmptyCellSelector implements EmptyCellSelector{

    public Cell getEmptyCell(List<Cell> emptyCellsList) {
        return emptyCellsList.get(0);
    }
}
