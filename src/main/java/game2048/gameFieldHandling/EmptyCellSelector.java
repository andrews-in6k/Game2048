package game2048.gameFieldHandling;

import game2048.cellHandling.Cell;

import java.util.List;

/**
 * Created by employee on 10/16/15.
 */
public interface EmptyCellSelector {

    Cell getEmptyCell(List<Cell> emptyCellsList);

}
