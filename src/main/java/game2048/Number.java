package game2048;

import java.util.Random;

/**
 * Created by employee on 10/15/15.
 */
public class Number {
    public static final int BASE_NUMBER = 2;
    public static final int INITIAL_POWER = 2;

    private int power;

    private int number;

    private Random random = new Random();

    Number() {
        power = random.nextInt(INITIAL_POWER) + 1;
    }

    public void incrementPower() {
        power++;
    }

    public int getNumber() {
        return (int) Math.pow(BASE_NUMBER, power);
    }
}
