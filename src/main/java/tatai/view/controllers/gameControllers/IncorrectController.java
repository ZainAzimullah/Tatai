package tatai.view.controllers.gameControllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import tatai.Game;
import tatai.exceptions.ResultOutOfRangeException;
import tatai.view.controllers.SceneController;

public class IncorrectController extends SceneController {

    @FXML
    private Label _message;

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
        int attemptsRemaining = Game.MAX_ATTEMPTS - Game.getInstance().getErrorCount();

        if (attemptsRemaining == 0) {
            Game.getInstance().newQuestion();
        } else {
            Game.getInstance().skip();
        }
    }

    @FXML
    private void initialize() {
        _question.setText(Game.getInstance().getCurrentQuestion().toString());
        _speech.setText(Game.getInstance().getSpeech());
        int attemptsRemaining = Game.MAX_ATTEMPTS - Game.getInstance().getErrorCount();
        _attemptsRemaining.setText(Integer.toString(attemptsRemaining));
        
        if (attemptsRemaining == 0) {
            _retryButton.setDisable(true);
            _skipButton.setText("Next");
            _message.setText("The correct answer is:");
            try {
                _question.setText(Game.getInstance().getCurrentQuestion().getMaoriResult().toString());
            } catch (ResultOutOfRangeException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    @Override
    protected void returnToMainMenu() {
        showAlertAndReturnFromGame();
    }
}
