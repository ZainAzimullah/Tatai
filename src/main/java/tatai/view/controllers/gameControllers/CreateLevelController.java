package tatai.view.controllers.gameControllers;

import javafx.fxml.FXML;
import tatai.Game;
import tatai.view.controllers.SceneController;

public class CreateLevelController extends SceneController{

    @FXML
    private void save() {

    }

    @FXML
    @Override
    protected void returnToMainMenu() {
        Game.getInstance().selectLevel();
    }
}
