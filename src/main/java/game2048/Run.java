package game2048;

import game2048.controllers.ConsoleGameController;
import game2048.gameFieldHandling.GameField;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.UrlResource;

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
