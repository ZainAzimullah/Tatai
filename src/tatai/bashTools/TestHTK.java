package tatai.bashTools;

import java.io.File;
import java.io.FileNotFoundException;

import javafx.application.Application;
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
		
		Media media = new Media((new File(System.getProperty("user.dir") + "/foo.wav")).toURI().toString());
		MediaPlayer player = new MediaPlayer(media);
		player.play();
		player.setOnEndOfMedia(() -> {
			VoiceRecogniser htk = new VoiceRecogniser();
			
			try {
				System.out.println(htk.getSpeech("foo.wav"));
			} catch (SpeechNotFoundException e) {
				System.out.println("You didn't say anything recognisable");
			} catch (FileNotFoundException e) {
				System.out.println("Could not find file");
			}

			System.exit(0);
		});
	}
}
