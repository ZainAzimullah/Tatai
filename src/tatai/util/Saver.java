package tatai.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Saver {
	
	private FinalScore _finalScore;
	
	public Saver(FinalScore finalScore) {
		_finalScore = finalScore;
	}
	
	public void save(String filename) {
		
		// Create file object of text file to save to
		File file = new File(System.getProperty("user.dir") + "/" + filename);
		
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		
		try {
			// Check if file exists
			if (!file.exists()) {
				file.createNewFile();
			}
			
			// Create wrtiers
			fileWriter = new FileWriter(file.getAbsoluteFile(), true);
			bufferedWriter = new BufferedWriter(fileWriter);
			
			// Write to file
			bufferedWriter.write(_finalScore.toString() + "\n");
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			
			// Close buffered writer
			if (bufferedWriter != null) {
				try {
					bufferedWriter.close();
				} catch (IOException e) {
					
				}
			}
			
			// Close file writer
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {

				}
			}
		}
	}
}
