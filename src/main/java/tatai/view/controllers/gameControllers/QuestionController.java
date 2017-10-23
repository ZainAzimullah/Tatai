package tatai.view.controllers.gameControllers;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
    private JFXButton _record, _skip, _home;

    @FXML
    private Label _questionNumber;

    @FXML
    private void initialize() {
        String question = Game.getInstance().getCurrentQuestion().toString();
        _questionNumber.setText(Integer.toString(Game.getInstance().getCurrentQuestionNumber()));

        // Remove extra brackets
        _equation.setText(question.substring(1,question.length() - 1) + " = ?");
    }

    // This method is invoked when the Record button is clicked
    @FXML
    private void record() {
        // Begin countdown
        Countdown countdown = new Countdown(RECORDING_TIME);
        countdown.start();

        // Change UI
        disablePopOver(_record);
        _record.setText("RECORDING");
        _record.setDisable(true);
        _skip.setDisable(true);
        _home.setDisable(true);

        // Bind label to countdown messages
        _recordMsg.textProperty().bind(countdown.getMessageProperty());

        // Start recording
        new Thread(new Background()).start();
    }

    @FXML
    private void skip() {
        Game.getInstance().skip();
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
                    Game.getInstance().record();
                    return;
                }

                Game.getInstance().finishedRecording();
            });
        }
    }
}
