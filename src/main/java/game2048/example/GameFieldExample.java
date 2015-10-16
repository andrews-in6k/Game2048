package game2048.example;

/**
 * Created by employee on 10/15/15.
 */
public class GameFieldExample {

    private String cells = "0 0 0 0\n0 0 0 0\n0 0 0 0\n0 0 0 0\n";

    @Override
    public String toString() {
        return cells;
    }

    public void fillEmptyCell(int value) {
        cells = "2 0 0 0\n0 0 0 0\n0 0 0 0\n0 0 0 0\n";
    }
}
