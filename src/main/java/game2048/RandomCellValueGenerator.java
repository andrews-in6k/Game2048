package game2048;

import java.util.Random;

/**
 * Created by employee on 10/16/15.
 */
public class RandomCellValueGenerator implements CellValueGenerator {

    @Override
    public int generateCellValue() {
        Random random = new Random();
        int randomResult = random.nextInt(10);
        if (randomResult < 8) {
            return 2;
        } else {
            return 4;
        }
    }
}
