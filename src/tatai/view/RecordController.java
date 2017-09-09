package tatai.view;

import java.io.File;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import tatai.Game;
import tatai.bashTools.BashCommand;

public class RecordController extends SceneController {
	
	@FXML
	private Label _label;
	
	@FXML
	private Button _button;
	
	@FXML
	private void record() {
		_button.setText("RECORDING");
		_button.setDisable(true);
		_label.setText("Recording");
		new Thread(new Background()).start();
	}
	
	private class Background extends Task<Void> {
		
		@Override
		protected Void call() {
			new BashCommand().runCommand("arecord -d 2 -r 22050 -c 1 -i -t wav -f s16_LE foo.wav");
			
			return null;
		}
		
		@Override
		protected void done() {
			Platform.runLater(() -> {
				Game.getInstance().finishedRecording();
			});
		}
	}
}
