package game2048.gameFieldHandling;

import game2048.gameFieldHandling.GameField;

/**
 * Created by anri on 18.10.15.
 */
public interface GameFieldPrinter {

    void printGameField(GameField gameField);

    void printGameProcessHeader();

    void printWinnerMenu();

    void printLooserMenu();
}
