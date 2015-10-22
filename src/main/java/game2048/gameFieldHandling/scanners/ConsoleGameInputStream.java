package game2048.gameFieldHandling.scanners;

import game2048.controllers.Options;
import game2048.gameFieldHandling.GameInputStream;

import java.util.Scanner;

/**
 * Created by employee on 10/22/15.
 */
public class ConsoleGameInputStream implements GameInputStream{
    Scanner scanner;

    public ConsoleGameInputStream(Scanner scanner) {
        this.scanner = scanner;
    }

    public Options gameProcessControl() {
        switch (scanner.next().charAt(0)) {
            case 'n':
                return Options.NEW_GAME;
            case '8':
                return Options.UP;
            case '2':
                return Options.DOWN;
            case '4':
                return Options.LEFT;
            case '6':
                return Options.RIGHT;
            case 'e':
                return Options.EXIT;
        }

        return Options.NOT_AVAILABLE;
    }

    public Options winnerControl() {
        switch (scanner.next().charAt(0)) {
            case '1':
                return Options.KEEP_GOING;
            case 'n':
                return Options.NEW_GAME;
            case 'e':
                return Options.EXIT;
        }

        return Options.NOT_AVAILABLE;
    }

    public Options looserControl() {
        switch (scanner.next().charAt(0)) {
            case 'n':
                return Options.NEW_GAME;
            default:
                return Options.EXIT;
        }
    }
}
