package tatai.view.controllers.gameControllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import tatai.Game;
import tatai.exceptions.SpeechNotFoundException;
import tatai.util.VoiceRecogniser;
import tatai.view.controllers.SceneController;

import java.io.File;

/**
 * this class is responsible for the logic behind what happens when the user has finished
 * recording their answer. from here they can replay what they said, re-record their
 * answer or submit their answer to the speech recogniser.
 */

public class FinishedRecordingController extends SceneController {

    @FXML
    private Label _message;

    @FXML
    private JFXButton _play;

    //sets up the audio file of what the user said to be played back and plays it back
    @FXML
    private void playback() {
        // Tell user recording is playing back
        _message.setText("Playing back recording...");
        _message.setAlignment(Pos.CENTER);
        _play.setDisable(true);

        // Play back the recording
        Media media = new Media(new File("foo.wav").toURI().toString());
        MediaPlayer player = new MediaPlayer(media);

        player.play();
        player.setOnEndOfMedia(() -> {
            // Reshow this scene once playback has finished
            Game.getInstance().finishedRecording();
        });

    }

    //submits the audio file of what the user said to the speech recogoniser. to
    //decipher what has been said.
    @FXML
    private void submit() {
        // Try to interpret what they said
        VoiceRecogniser htk = new VoiceRecogniser();

        try {
            Game.getInstance().storeSpeech(htk.getSpeech("foo.wav"));
        } catch (SpeechNotFoundException e) {
            // We should have caught this earlier, so if this happened again
            // then something went wrong
            e.printStackTrace();
        }

        Game.getInstance().checkAnswer();
    }

    //reset the audio file to be re-recorded
    @FXML
    private void redo() {
        Game.getInstance().record();
    }

    @FXML
    @Override
    protected void returnToMainMenu() {
        showAlertAndReturnFromGame();
    }
}
