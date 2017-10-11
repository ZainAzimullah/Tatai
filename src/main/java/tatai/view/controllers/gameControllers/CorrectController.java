package tatai.view.controllers.gameControllers;

import javafx.fxml.FXML;
import tatai.Game;
import tatai.view.controllers.SceneController;

public class CorrectController extends SceneController {

    @FXML
    private void next() {

    }

    @FXML
    @Override
    protected void returnToMainMenu() {
        Game.getInstance().returnToMainMenu();
    }
}
