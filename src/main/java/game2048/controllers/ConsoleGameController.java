package game2048.controllers;

import game2048.GameController;
import game2048.gameFieldHandling.GameField;
import game2048.gameFieldHandling.GameFieldPrinter;
import game2048.gameFieldHandling.GameInputStream;

/**
 * Created by anri on 18.10.15.
 */
public class ConsoleGameController implements GameController {
    private GameField gameField;

    private GameInputStream gameInputStream;
    private GameFieldPrinter gameFieldPrinter;

    Options option;
    private boolean winner;

    public ConsoleGameController(GameField gameField, GameInputStream gameInputStream, GameFieldPrinter gameFieldPrinter) {
        this.gameField = gameField;
        this.gameInputStream = gameInputStream;
        this.gameFieldPrinter = gameFieldPrinter;
        option = Options.NOT_AVAILABLE;
    }

    public void startGame() {
        boolean hasMoved;
        boolean isExitPressed = false;
        winner = false;

        while (!isExitPressed) {
            hasMoved = false;

            gameFieldPrinter.printGameProcessHeader();

            option = gameInputStream.gameProcessControl();

            if (gameField.hasVictoryCellValue() && !winner) {
                gameFieldPrinter.printWinnerMenu();
                winner = true;
                option = gameInputStream.winnerControl();
            }

            if (!gameField.hasAvailableMove()) {
                gameFieldPrinter.printLooserMenu();
                option = gameInputStream.looserControl();
            }

            switch (option){
                case NEW_GAME:
                    gameField.startNewGame();
                    break;
                case UP:
                    hasMoved = gameField.moveCells(Options.UP);
                    break;
                case DOWN:
                    hasMoved = gameField.moveCells(Options.DOWN);
                    break;
                case LEFT:
                    hasMoved = gameField.moveCells(Options.LEFT);
                    break;
                case RIGHT:
                    hasMoved = gameField.moveCells(Options.RIGHT);
                    break;
                case KEEP_GOING:
                    winner = true;
                    break;
                case EXIT:
                    isExitPressed = true;
                    break;
            }

            if (hasMoved) {
                gameField.fillEmptyCell();
            }

            gameFieldPrinter.printGameField(gameField);

        }
    }

}
