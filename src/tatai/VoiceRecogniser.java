package tatai;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import tatai.bashTools.BashCommand;
import tatai.exceptions.SpeechNotFoundException;

public class VoiceRecogniser {
	
	public String getSpeech(String filename) throws SpeechNotFoundException {
		BashCommand bash = new BashCommand();
		
		bash.runCommand("HVite -H HMMs/hmm15/macros -H "
				+ "HMMs/hmm15/hmmdefs -C user/configLR  -w "
				+ "user/wordNetworkNum -o SWT -l '*' -i recout.mlf "
				+ "-p 0.0 -s 5.0  user/dictionaryD user/tiedList " + filename);
		bash.runCommand("rm -f " + filename);

        File file = new File("recout.mlf");
        BufferedReader bufferedReader = null;
        
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		String speech = null, line = null;
		boolean readyToGet = false;
		
		try {
			while ((line = bufferedReader.readLine()) != null) {
				if (readyToGet) {
					speech = line;
					break;
				}
				
				if (line.equals("sil")) {
					readyToGet = true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (speech == null) {
			throw new SpeechNotFoundException("No voice observed");
		}
		
		return speech;
	}
}
