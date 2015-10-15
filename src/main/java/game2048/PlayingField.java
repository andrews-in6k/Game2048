package game2048;

import java.util.Random;

/**
 * Created by employee on 10/15/15.
 */
public class PlayingField {
    public static final int PLAYING_FIELD_SIZE = 4;
    public static final int COUNT_OF_STARTING_NUMBERS = 2;
    public static final int COUNT_OF_NEW_NUMBERS_AFTER_MOVE = 1;

    private Number[][] numbers = new Number[4][4];

    PlayingField() {
        addNumbers(COUNT_OF_STARTING_NUMBERS);
    }

    public void printField() {
        System.out.println("-----------------------------");

        for (int i = 0; i < PLAYING_FIELD_SIZE; i++) {

            System.out.print("|");

            for (int j = 0; j < PLAYING_FIELD_SIZE; j++) {
                if (numbers[i][j] == null) {
                    System.out.print("      |");
                } else {
                    System.out.printf("%6d|", numbers[i][j].getNumber());
                }
            }

            System.out.println();
            System.out.println("-----------------------------");

        }
    }

    public void moveUp() {
        
    }

    public void moveDown(){

    }

    public void moveLeft(){

    }

    public void moveRight(){

    }

    private void addNumbers(int count) {
        Random random = new Random();

        int i, j;

        for (int k = 0; k < count; k++) {
            i = random.nextInt(PLAYING_FIELD_SIZE);
            j = random.nextInt(PLAYING_FIELD_SIZE);

            if (numbers[i][j] == null) {
                numbers[i][j] = new Number();
            } else {
                k--;
            }
        }
    }

}
