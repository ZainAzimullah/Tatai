package tatai.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import tatai.exceptions.SpeechNotFoundException;

public class VoiceRecogniser {
	
	public String getSpeech(String filename) throws SpeechNotFoundException {
		
		// Run speech recognition commands
		BashCommand bash = new BashCommand();
		bash.runCommand("HVite -H HMMs/hmm15/macros -H "
				+ "HMMs/hmm15/hmmdefs -C user/configLR  -w "
				+ "user/wordNetworkNum -o SWT -l '*' -i recout.mlf "
				+ "-p 0.0 -s 5.0  user/dictionaryD user/tiedList " + filename);

        File file = new File("recout.mlf");
        BufferedReader bufferedReader = null;
        
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		String speech = "", line = null;
		boolean readyToGet = false;
		
		try {
			// Iterate through the lines to find the one that says "sil",
			// and then the next lines will contain the word the user said
			// until "sil" is seen again.
			while ((line = bufferedReader.readLine()) != null) {
	
				
				if ((line.equals("sil")) && (!readyToGet)) {
					readyToGet = true;
					continue;
				} else if ((line.equals("sil")) && (readyToGet)) {
					readyToGet = false;
				}
				
				if (readyToGet) {
					speech = speech + " " + line;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// If sil was never founded, then user never said anything
		if ((speech == null) || (speech.equals(""))) {
			throw new SpeechNotFoundException("No Maori numbers observed");
		}
		
		// Remove whitespace at front of word
		speech = speech.trim();
		return speech;
	}
}
