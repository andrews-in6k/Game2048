package game2048;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by anri on 18.10.15.
 */
public class Run {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xmlConfig.xml");
        GameController gameController = (GameController)applicationContext.getBean("gameController");

        gameController.startGame();
    }
}
