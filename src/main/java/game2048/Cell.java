package game2048;

/**
 * Created by employee on 10/16/15.
 */
public class Cell {

    private int cellValue;

    public Cell(){
        cellValue = 0;
    }

    public Cell(int cellValue) {
        setCellValue(cellValue);
    }

    public void incrementPower() {
        cellValue = cellValue * 2;
    }

    public int getValue() {
        return cellValue;
    }

    public void setCellValue(int cellValue) {
        this.cellValue = cellValue;
    }
}
