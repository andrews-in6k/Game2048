package game2048;

import java.util.Scanner;

/**
 * Created by employee on 10/15/15.
 */
public class Run {

    public static void main(String[] args){
        PlayingField playingField = new PlayingField();

        playingField.printField();

        Scanner scanner = new Scanner(System.in);

        boolean iter = true;

        while (iter) {
            System.out.println("8 - move up");
            System.out.println("2 - move down");
            System.out.println("4 - move left");
            System.out.println("6 - move right");
            System.out.println("e - exit");

            char ch = scanner.next().charAt(0);
            switch (ch) {
                case '8':
                    playingField.moveUp();
                    break;
                case '2':
                    playingField.moveDown();
                    break;
                case '4':
                    playingField.moveLeft();
                    break;
                case '6':
                    playingField.moveRight();
                    break;
                case 'e':
                    iter = false;
                    break;
            }

            playingField.printField();
        }

    }
}
