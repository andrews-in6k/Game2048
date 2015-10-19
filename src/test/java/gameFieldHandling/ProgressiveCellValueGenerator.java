package gameFieldHandling;

import game2048.gameFieldHandling.CellValueGenerator;

/**
 * Created by anri on 18.10.15.
 */
public class ProgressiveCellValueGenerator implements CellValueGenerator {
    private int value;

    public ProgressiveCellValueGenerator() {
        value = 1;
    }

    public int generateCellValue() {
        value = value * 2;
        return value;
    }
}
