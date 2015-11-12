package game2048.controllers.mvcControllers;

import game2048.controllers.Options;
import game2048.gameFieldHandling.GameField;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "action/{option}", method = RequestMethod.GET)
    public String controlGame(@ModelAttribute("gameField") GameField gameField,
                              @PathVariable int option,
                              ModelMap model
    ){
        boolean hasMoved = false;

        switch (option){
            case 1:
                gameField.startNewGame();
                break;
            case 8:
                hasMoved = gameField.moveCells(Options.UP);
                break;
            case 5:
                hasMoved = gameField.moveCells(Options.DOWN);
                break;
            case 4:
                hasMoved = gameField.moveCells(Options.LEFT);
                break;
            case 6:
                hasMoved = gameField.moveCells(Options.RIGHT);
                break;
//            case KEEP_GOING:
//                winner = true;
//                break;
//            case EXIT:
//                isExitPressed = true;
//                break;
        }

        if (hasMoved) {
            gameField.fillEmptyCell();
        }

        return "redirect:/";
    }
}
