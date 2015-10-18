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

    public void setCellValue(int cellValue) {
        this.cellValue = cellValue;
    }

    public int getCellValue() {
        return cellValue;
    }

    public String getCellColor() {
        int index = (int)(Math.log(cellValue)/Math.log(2)) % 8;
        CellColor[] cellColors = CellColor.values();
        return cellColors[index].toString();
    }
}
