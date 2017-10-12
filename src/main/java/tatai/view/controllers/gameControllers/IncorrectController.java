package tatai.view.controllers.gameControllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import tatai.Game;
import tatai.view.controllers.SceneController;

public class IncorrectController extends SceneController {

    @FXML
    private Label _speech;

    @FXML
    private Label _question;

    @FXML
    private JFXButton _retryButton;

    @FXML
    private JFXButton _skipButton;

    @FXML
    private Label _attemptsRemaining;

    @FXML
    private void retry() {
        Game.getInstance().record();
    }

    @FXML
    private void skip() {
        Game.getInstance().skip();
    }

    @FXML
    private void initialize() {
        _question.setText(Game.getInstance().getCurrentQuestion().toString());
        _speech.setText(Game.getInstance().getSpeech());
        int attemptsRemaining = Game.MAX_ATTEMPTS - Game.getInstance().getErrorCount();

        if (attemptsRemaining == 0) {
            _retryButton.setDisable(true);
            _skipButton.setText("Next");
        }
    }

    @FXML
    @Override
    protected void returnToMainMenu() {
        showAlertAndReturnFromGame();
    }
}
