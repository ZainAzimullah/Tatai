package tatai.bashTools;

import java.io.BufferedReader;
import java.io.IOException;

import tatai.exceptions.TataiException;

public class HTKOutput extends BashCommand<String> {
	
	@Override
	public String retrieveStdOut(BufferedReader stdOut) {
		
		String line;
		boolean ready = false;
		
		try {
			while ((line = stdOut.readLine()) != null) {
				
				if (ready) {
					return line;
				}
				
				if (line.equals("sil")) {
					ready = true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		throw new TataiException("Didn't get HTK output!");
	}
}
