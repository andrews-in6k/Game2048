import game2048.CellValueGenerator;

/**
 * Created by employee on 10/16/15.
 */
public class StaticCellValueGenerator implements CellValueGenerator {

    private int value;

    public StaticCellValueGenerator(int value){
        this.value = value;
    }

    @Override
    public int generateCellValue() {
        return value;
    }
}
