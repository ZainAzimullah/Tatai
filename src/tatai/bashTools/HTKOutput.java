package tatai.bashTools;

import java.io.BufferedReader;
import java.io.IOException;

import tatai.exceptions.TataiException;

public class HTKOutput extends BashCommand {
	
	private HTKRecipient _recipient;
	
	public HTKOutput(HTKRecipient recipient) {
		_recipient = recipient;
	}
	
	@Override
	protected void retrieveStdOut(BufferedReader stdOut) {
		
		String line;
		boolean ready = false;
		
		try {
			while ((line = stdOut.readLine()) != null) {
				
				if (ready) {
					_recipient.receiveHTKguess(line);
					return;
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
