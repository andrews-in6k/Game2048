package game2048.controllers.mvcControllers;

import game2048.gameFieldHandling.GameField;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by employee on 11/12/15.
 */
@Controller
@SessionAttributes(value = "gameField")
@RequestMapping("/")
public class BaseController {

    @RequestMapping(method = RequestMethod.GET)
    public String initGame(@ModelAttribute("gameField") GameField gameField, ModelMap model){
        model.addAttribute("gameField", gameField);

        return "index";
    }

    @ModelAttribute("gameField")
    public GameField createUser() {
        GameField gameField = new GameField();
        gameField.startNewGame();
        return gameField;
    }
}
