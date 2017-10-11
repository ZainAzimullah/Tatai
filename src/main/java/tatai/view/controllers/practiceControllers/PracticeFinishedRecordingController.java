package tatai.view.controllers.practiceControllers;

import java.io.File;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import tatai.Practice;
import tatai.exceptions.SpeechNotFoundException;
import tatai.util.VoiceRecogniser;
import tatai.view.controllers.SceneController;

public class PracticeFinishedRecordingController extends SceneController {
	
	@FXML
	private Label _message;
	
	@FXML
	private Button _play;
	
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
			Practice.getInstance().finishedRecording();
		});
		
	}
	
	@FXML
	private void submit() {
		// Try to interpret what they said
		VoiceRecogniser htk = new VoiceRecogniser();
		
		try {
			Practice.getInstance().storeAttempt(htk.getSpeech("foo.wav"));
		} catch (SpeechNotFoundException e) {
			// We should have caught this earlier, so if this happened again
			// then something went wrong
			e.printStackTrace();
		}
		
		Practice.getInstance().checkAnswer();
	}
	
	@FXML
	private void redo() {
		Practice.getInstance().rerecord();
	}
	
	@FXML
	@Override
	protected void returnToMainMenu() {
		showAlertAndReturnFromPractice();
	}
}
