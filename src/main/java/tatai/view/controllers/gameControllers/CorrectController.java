package tatai.view.controllers.gameControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import tatai.Game;
import tatai.exceptions.ResultOutOfRangeException;
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
        try {
            _speech.setText(Game.getInstance().getCurrentQuestion().getMaoriResult().toString());
        } catch (ResultOutOfRangeException e) {
            e.printStackTrace();
        }
        _question.setText(Game.getInstance().getCurrentQuestion().toString());
    }

    @FXML
    @Override
    protected void returnToMainMenu() {
        Game.getInstance().returnToMainMenu();
    }
}
