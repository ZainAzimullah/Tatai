package tatai.view.controllers.gameControllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import tatai.Game;
import tatai.view.controllers.SceneController;

public class LoadLevelController extends SceneController {

    @FXML
    @Override
    protected void returnToMainMenu() {
        Game.getInstance().selectLevel();
    }
}
