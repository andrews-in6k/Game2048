package game2048.cellHandling;

/**
 * Created by employee on 10/16/15.
 */
public class Cell {
    public static final int BASIC_NUMBER = 2;

    private int cellValue;

    public Cell() {
        cellValue = 0;
    }

    public Cell(int cellValue) {
        setCellValue(cellValue);
    }

    public boolean isEmpty() {
        return cellValue == 0;
    }

    public void incrementPower() {
        cellValue = cellValue * BASIC_NUMBER;
    }

    public void setCellValue(int cellValue) {
        this.cellValue = cellValue;
    }

    public int getCellValue() {
        return cellValue;
    }

    public String getCellColor() {
        return calculateCellColor();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        return cellValue == cell.cellValue;

    }

    @Override
    public int hashCode() {
        return cellValue;
    }

    private String calculateCellColor() {
        int index = (int) (Math.log(cellValue) / Math.log(BASIC_NUMBER)) % 8;
        CellColor[] cellColors = CellColor.values();

        return cellColors[index].toString();
    }
}
