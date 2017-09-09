package tatai.bashTools;

import java.io.File;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import tatai.exceptions.SpeechNotFoundException;

public class TestHTK extends Application {
	public static void main(String[] args) {
		launch(args);

	}
	
	@Override
	public void start(Stage stage) {
		BashCommand bash = new BashCommand();
		bash.runCommand("arecord -d 2 -r 22050 -c 1 -i -t wav -f s16_LE foo.wav");		
		
		new Thread(new Background()).start();
	}
	
	private class Background extends Task<Void> {
		@Override
		protected Void call() {
			Media media = new Media((new File(System.getProperty("user.dir") + "/foo.wav")).toURI().toString());
			MediaPlayer player = new MediaPlayer(media);
			player.play();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		}
		
		@Override
		protected void succeeded() {
			VoiceRecogniser htk = new VoiceRecogniser();
			
			try {
				System.out.println(htk.getSpeech("foo.wav"));
			} catch (SpeechNotFoundException e) {
				System.out.println("You didn't say anything recognisable");
			} catch (FileNotFoundException e) {
				System.out.println("Could not find file");
			}
			
			System.exit(0);
		}
	}
}
