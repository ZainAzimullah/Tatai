package tatai.bashTools;

import java.io.BufferedReader;
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
	private List<String> commands;
	
	public BashCommand() {
		commands = new ArrayList<>();
		commands.add("bash");
		commands.add("-c");
	}
	
	/*
	 * This is a template method which runs the command.
	 * If the stdout from BASH is required, this class can be extended
	 * and the hook method getStdOut(:BufferedReader) can be overridden so that
	 * the output can be collected in such a way desired when getStdOut() is 
	 * downcalled.
	 */
	public final void runCommand(String command) {
		commands.add(2, command);
		
		// Run BASH process
		try {
			ProcessBuilder processBuilder = new ProcessBuilder(commands);
			Process process = processBuilder.start();
			
			(new Consumer(process.getInputStream())).start();
			(new Consumer(process.getErrorStream())).start();
			
			int exitStatus = process.waitFor();
			System.out.println("finished waiting");
			
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
}
