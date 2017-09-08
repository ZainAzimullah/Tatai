package tatai.bashTools;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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
		/*
		 * Make creations folder if it doesn't exist, and then
		 * change into it and run the command given.
		 */
		command = "mkdir -p creations; cd creations; " + command;
		commands.add(2, command);
		
		// Run BASH process
		try {
			ProcessBuilder processBuilder = new ProcessBuilder(commands);
			Process process = processBuilder.start();
			int exitStatus = process.waitFor();
			
			if (exitStatus != 0) {
				return;
			}
			
			BufferedReader stdOut = new BufferedReader(
					new InputStreamReader(process.getInputStream()));
			
			// Call hook method
			getStdOut(stdOut);
			
			process.destroy();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Processing error");
			System.exit(0);
		}
	}
	
	
	public void givePermissions(String filename) {
		runCommand("chmod +x " + filename);
	}
	
	public void getStdOut(BufferedReader stdOut) {} // Optional hook
}
