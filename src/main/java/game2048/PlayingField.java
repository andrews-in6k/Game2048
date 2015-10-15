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
        for (int i = 0; i < PLAYING_FIELD_SIZE; i++) {
            for (int j = 0; j < PLAYING_FIELD_SIZE;j++) {
                numbers[i][j] = null;
            }
        }

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
        boolean action = false;

        for (int j = 0; j < PLAYING_FIELD_SIZE; j++) {
            for (int i = 1; i < PLAYING_FIELD_SIZE; i++) {
                if (numbers[i][j] != null){
                    //TODO Method
                    for (int k = i; k > 0; k--) {
                        if (numbers[k - 1][j] == null) {
                            numbers[k - 1][j] = numbers[k][j];
                            numbers[k][j] = null;
                            action = true;
                        } else if (numbers[k - 1][j].getNumber() == numbers[k][j].getNumber()){
                            numbers[k - 1][j].incrementPower();
                            numbers[k][j] = null;
                            action = true;
                            break;
                        }
                    }
                    //
                }
            }
        }

        if (action){
            addNumbers(COUNT_OF_NEW_NUMBERS_AFTER_MOVE);
        }
    }

    public void moveDown(){
        boolean action = false;

        for (int j = 0; j < PLAYING_FIELD_SIZE; j++) {
            for (int i = PLAYING_FIELD_SIZE - 1; i >= 0; i--) {
                if (numbers[i][j] != null){
                    //TODO Method
                    for (int k = i; k < PLAYING_FIELD_SIZE - 1; k++) {
                        if (numbers[k + 1][j] == null) {
                            numbers[k + 1][j] = numbers[k][j];
                            numbers[k][j] = null;
                            action = true;
                        } else if (numbers[k + 1][j].getNumber() == numbers[k][j].getNumber()){
                            numbers[k + 1][j].incrementPower();
                            numbers[k][j] = null;
                            action = true;
                            break;
                        }
                    }
                    //
                }
            }
        }

        if (action){
            addNumbers(COUNT_OF_NEW_NUMBERS_AFTER_MOVE);
        }
    }

    public void moveLeft(){
        boolean action = false;

        for (int i = 0; i < PLAYING_FIELD_SIZE; i++) {
            for (int j = 1; j < PLAYING_FIELD_SIZE; j++) {
                if (numbers[i][j] != null){
                    //TODO Method
                    for (int k = j; k > 0; k--) {
                        if (numbers[i][k - 1] == null) {
                            numbers[i][k - 1] = numbers[i][k];
                            numbers[i][k] = null;
                            action = true;
                        } else if (numbers[i][k - 1].getNumber() == numbers[i][k].getNumber()){
                            numbers[i][k - 1].incrementPower();
                            numbers[i][k] = null;
                            action = true;
                            break;
                        }
                    }
                    //
                }
            }
        }

        if (action){
            addNumbers(COUNT_OF_NEW_NUMBERS_AFTER_MOVE);
        }
    }

    public void moveRight(){
        boolean action = false;

        for (int i = 0; i < PLAYING_FIELD_SIZE; i++) {
            for (int j = PLAYING_FIELD_SIZE - 1; j >= 0; j--) {
                if (numbers[i][j] != null){
                    //TODO Method
                    for (int k = j; k < PLAYING_FIELD_SIZE - 1; k++) {
                        if (numbers[i][k + 1] == null) {
                            numbers[i][k + 1] = numbers[i][k];
                            numbers[i][k] = null;
                            action = true;
                        } else if (numbers[i][k + 1].getNumber() == numbers[i][k].getNumber()){
                            numbers[i][k + 1].incrementPower();
                            numbers[i][k] = null;
                            action = true;
                            break;
                        }
                    }
                    //
                }
            }
        }

        if (action){
            addNumbers(COUNT_OF_NEW_NUMBERS_AFTER_MOVE);
        }
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
