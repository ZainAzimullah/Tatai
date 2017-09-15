package tatai.bashTools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import tatai.exceptions.TataiException;

/*
 * Any BASH command that needs to be run can be done by simply
 * creating an instance of this BashCommand class and then invoking
 * bashCommand.runCommand(command :String).  It is assumed that
 * the command will be run in the newly generated creations directory.
 */
public class BashCommand {
	private List<String> _commands;
	
	public BashCommand() {
		// Create list of commands for bash process
		_commands = new ArrayList<>();
		_commands.add("bash");
		_commands.add("-c");
	}
	
	public void runCommand(String command) {
		_commands.add(2, command);
		
		Consumer stdout = null, stderr = null;
		
		// Run BASH process
		try {
			// Build process
			ProcessBuilder processBuilder = new ProcessBuilder(_commands);
			Process process = processBuilder.start();
			
			// Create stream eaters so that buffer doesn't get blocked
			stdout = new Consumer(process.getInputStream());
			stderr = new Consumer(process.getErrorStream());
			
			// Start stream eaters
			stdout.start();
			stderr.start();
			
			// Wait for process to finish
			process.waitFor();
			
			// Destroy process
			process.destroy();
		} catch (Exception e) {
			throw new TataiException("Error running BASH command");
			
		} finally {
			// Terminate stream eaters
			if (stdout != null) {
				stdout.cancel();
			}
			
			if (stderr != null) {
				stderr.cancel();
			}	
		}
	}
	
	
	public void givePermissions(String filename) {
		runCommand("chmod +x " + filename);
	}
	
	/*
	 * This class consumes an input stream from a process so that the 
	 * buffer does not get blocked (and thus resulting in a deadlock)
	 */
	private class Consumer extends Thread {
		
		private InputStream _inputStream;
		private boolean _alive = true;
		
		public Consumer(InputStream inputStream) {
			_inputStream = inputStream;
			
		}
		
		public void run() {
			InputStreamReader inputStreamReader = new InputStreamReader(_inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			
			@SuppressWarnings("unused")
			String line;
			
			// Continuously read stream and do nothing with it
			try {
				while (((line = bufferedReader.readLine()) != null) && (_alive)) {}
			} catch (IOException e) {
				
			}
		}
		
		// Make cancel request
		public void cancel() {
			_alive = false;
		}
	}
}
