package tatai.view.controllers.gameControllers;

import tatai.Game;
import tatai.view.MainMenuLoader;
import tatai.view.controllers.SceneController;

public class SelectLevelController extends SceneController {
    @Override
    protected void returnToMainMenu() {
        Game.getInstance().returnToMainMenu();
    }
}
