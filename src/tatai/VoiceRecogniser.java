package tatai;

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
		
		List<String> output = bash.getLog();
		
		String speech = null;
		boolean readyToGet = false;
		
		for (String line: output) {
			if (readyToGet) {
				speech = line;
				break;
			}
			
			if (line.equals("sil")) {
				readyToGet = true;
			}
		}
		
		if (speech == null) {
			throw new SpeechNotFoundException("No voice observed");
		}
		
		return speech;
	}
}
