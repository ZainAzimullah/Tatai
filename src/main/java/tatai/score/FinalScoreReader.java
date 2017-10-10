package tatai.score;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FinalScoreReader {
	
	private File _file;
	
	public FinalScoreReader(String filename) {
		_file = new File(System.getProperty("user.dir") + "/" + filename);
	}
	
	// Read score history from file and create list of FinalScores
	public ObservableList<FinalScore> read() {
		
		// Create output list
		ObservableList<FinalScore> output = FXCollections.observableArrayList();
		
		// Initialise readers
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try {
			fileReader = new FileReader(_file);
			bufferedReader = new BufferedReader(fileReader);
			
			// Read each line from the file
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				// Create and add FinalScore object to output
				output.add(new FinalScore(line));
			}
		
		} catch (FileNotFoundException e) {
			return output; // Return empty list if file not found
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			
			// Close BufferedReader
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			// Close FileReader
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return output;
	}
}
