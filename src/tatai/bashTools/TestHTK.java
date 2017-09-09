package tatai.bashTools;

import java.io.FileNotFoundException;
import java.util.List;

import tatai.exceptions.SpeechNotFoundException;

public class TestHTK {
	public static void main(String[] args) {
		BashCommand bash = new BashCommand();
		bash.runCommand("arecord -d 2 -r 22050 -c 1 -i -t wav -f s16_LE foo.wav");
		
		bash.runCommand("ffplay -autoexit -nodisp foo.wav &> /dev/null");
		
		VoiceRecogniser htk = new VoiceRecogniser();
		
		try {
			System.out.println(htk.getSpeech("foo.wav"));
		} catch (SpeechNotFoundException e) {
			System.out.println("You didn't say anything recognisable");
		} catch (FileNotFoundException e) {
			System.out.println("Could not find file");
		}
	}
}
