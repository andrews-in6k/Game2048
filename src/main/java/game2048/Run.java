package game2048;

/**
 * Created by anri on 18.10.15.
 */
public class Run {

    private static GameController gameController;

    public static void main(String[] args) {
        gameController = new ConsoleGameController();
        gameController.startController();
    }
}
