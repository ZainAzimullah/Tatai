package tatai.view.controllers.gameControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import tatai.Game;
import tatai.view.controllers.SceneController;

public class QuestionController extends SceneController {

    private Label _equation;

    @FXML
    private void initialize() {
        _equation.setText(Game.getInstance().getCurrentQuestion().toString());
    }

    @Override
    protected void returnToMainMenu() {
        showAlertAndReturnFromGame();
    }
}
