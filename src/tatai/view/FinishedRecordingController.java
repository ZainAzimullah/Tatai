package tatai.view;

import java.io.File;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import tatai.Game;

public class FinishedRecordingController extends SceneController {
	
	@FXML
	private Label _message;
	
	@FXML
	private Button _play;
	
	@FXML
	private void playback() {
		_message.setText("Playing back recording...");
		_message.setAlignment(Pos.CENTER);
		_play.setDisable(true);
		
		Media media = new Media(new File("foo.wav").toURI().toString());
		MediaPlayer player = new MediaPlayer(media);
		
		player.play();
		player.setOnEndOfMedia(() -> {
			Game.getInstance().finishedRecording();
		});
		
	}
	
	@FXML
	private void submit() {
		Game.getInstance().showResult();
	}
	
	@FXML
	private void redo() {
		Game.getInstance().record();
	}
}
