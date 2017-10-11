package tatai.view.controllers.gameControllers;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import tatai.Game;
import tatai.exceptions.SpeechNotFoundException;
import tatai.util.BashCommand;
import tatai.util.Countdown;
import tatai.util.VoiceRecogniser;
import tatai.view.controllers.SceneController;

public class QuestionController extends SceneController {
    public static final int RECORDING_TIME = 2;

    @FXML
    private Label _equation;

    @FXML
    private Label _recordMsg;

    @FXML
    private Button _button;

    @FXML
    private void initialize() {
        _equation.setText(Game.getInstance().getCurrentQuestion().toString() + " = ?");
    }

    // This method is invoked when the Record button is clicked
    @FXML
    private void record() {
        // Begin countdown
        Countdown countdown = new Countdown(RECORDING_TIME);
        countdown.start();

        // Change UI
        _button.setText("RECORDING");
        _button.setDisable(true);

        // Bind label to countdown messages
        _recordMsg.textProperty().bind(countdown.getMessageProperty());

        // Start recording
        new Thread(new Background()).start();
    }

    @FXML
    @Override
    protected void returnToMainMenu() {
        showAlertAndReturnFromGame();
    }

    private class Background extends Task<Void> {

        @Override
        protected Void call() {
            new BashCommand().runCommand("arecord -d " + RECORDING_TIME + " -r 22050 -c 1 -i -t wav -f s16_LE foo.wav");
            //new BashCommand().runCommand("ffmpeg -f alsa -i hw:0 -t " + RECORDING_TIME + " -acodec pcm_s16le -ar 22050 -ac 1 foo.wav");

            return null;
        }

        @Override
        protected void done() {
            Platform.runLater(() -> {

                // Check if user said anything recognisable
                try {
                    new VoiceRecogniser().getSpeech("foo.wav");

                } catch (SpeechNotFoundException e) {
                    // Tell user to record again
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    Label label = new Label("You did not say any recognisable Maori numbers.\nPlease record again.");
                    label.setWrapText(true);
                    alert.setHeaderText("Record Again");
                    alert.getDialogPane().setContent(label);
                    alert.showAndWait();
                    Game.getInstance().recordAgain();
                    return;
                }

                Game.getInstance().finishedRecording();
            });
        }
    }
}
