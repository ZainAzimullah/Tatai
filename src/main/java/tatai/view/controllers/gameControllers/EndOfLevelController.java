package tatai.view.controllers.gameControllers;

import tatai.Game;
import tatai.view.controllers.SceneController;

public class EndOfLevelController extends SceneController {



    @Override
    protected void returnToMainMenu() {
        Game.getInstance().returnToMainMenu();
    }
}
