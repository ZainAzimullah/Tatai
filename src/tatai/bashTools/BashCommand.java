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
	private List<String> _log;
	
	public BashCommand() {
		_commands = new ArrayList<>();
		_commands.add("bash");
		_commands.add("-c");
		
		_log = new ArrayList<>();
	}
	
	public void runCommand(String command) {
		_commands.add(2, command);
		
		// Run BASH process
		try {
			ProcessBuilder processBuilder = new ProcessBuilder(_commands);
			Process process = processBuilder.start();

			(new Consumer(process.getInputStream())).start();
			(new Consumer(process.getErrorStream())).start();

			int exitStatus = process.waitFor();
			if (exitStatus != 0) {
				throw new Exception();
			}
			
			process.destroy();
		} catch (Exception e) {
			throw new TataiException("Error running BASH command");
		}
	}
	
	
	public void givePermissions(String filename) {
		runCommand("chmod +x " + filename);
	}
	
	public List<String> getLog() {
		return _log;
	}
	
	/*
	 * This class consumes an input stream from a process so that the 
	 * buffer does not get blocked (and thus resulting in a deadlock)
	 */
	private class Consumer extends Thread {
		
		private InputStream _inputStream;
		
		public Consumer(InputStream inputStream) {
			_inputStream = inputStream;
			
		}
		
		public void run() {
			InputStreamReader inputStreamReader = new InputStreamReader(_inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			
			String line;
			try {
				while ((line = bufferedReader.readLine()) != null) {
					_log.add(line);
					System.out.println(line);
				}
			} catch (IOException e) {
				
			}
		}
	}
}
