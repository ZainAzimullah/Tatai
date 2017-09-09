package tatai.view;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import tatai.Countdown;
import tatai.Game;
import tatai.bashTools.BashCommand;

public class RecordController extends SceneController {
	
	private final int RECORDING_TIME = 2;
	
	@FXML
	private Label _recordMsg;
	
	@FXML
	private Button _button;
	
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
	
	private class Background extends Task<Void> {
		
		@Override
		protected Void call() {
			// This command needs to be changed before submission!
			new BashCommand().runCommand("arecord -d " + RECORDING_TIME + " -r 22050 -c 1 -i -t wav -f s16_LE foo.wav");
			//new BashCommand().runCommand("ffmpeg -f alsa -i hw:0 -t " + RECORDING_TIME + " -acodec pcm_s16le -ar 22050 -ac 1 foo.wav");
			
			return null;
		}
		
		@Override
		protected void done() {
			Platform.runLater(() -> {
				
				// Update UI
				_recordMsg.textProperty().unbind();
				_recordMsg.setText("Finished recording");
				_button.setText("Record");
				_button.setDisable(false);
				
				// Proceed to Game class
				Game.getInstance().finishedRecording();
			});
		}
	}
}
