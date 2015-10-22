package game2048.gameFieldHandling;

import game2048.controllers.Options;

/**
 * Created by employee on 10/22/15.
 */
public interface GameInputStream {
    Options gameProcessControl();

    Options winnerControl();

    Options looserControl();
}
