package game2048;

import java.util.Random;

/**
 * Created by employee on 10/15/15.
 */
public class Number {
    public static final int BASE_NUMBER = 2;

    private int power;

    private Random random = new Random();

    Number() {
        if (random.nextInt(10) < 8) {
            power = 1;
        } else {
            power = 2;
        }
    }

    public void incrementPower() {
        power++;
    }

    public String getColorFormat() {
        return "\u001b[3" + power % 8 + "m";
    }

    public int getNumber() {
        return (int) Math.pow(BASE_NUMBER, power);
    }
}
