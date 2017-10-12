package tatai.view.controllers.gameControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import tatai.Game;
import tatai.view.controllers.SceneController;

public class CorrectController extends SceneController {

    @FXML
    private Label _question;

    @FXML
    private Label _speech;

    @FXML
    private void next() {
        Game.getInstance().newQuestion();
    }

    @FXML
    private void initialize() {
        _speech.setText(Game.getInstance().getSpeech());
        _question.setText(Game.getInstance().getCurrentQuestion().toString());
    }

    @FXML
    @Override
    protected void returnToMainMenu() {
        Game.getInstance().returnToMainMenu();
    }
}
