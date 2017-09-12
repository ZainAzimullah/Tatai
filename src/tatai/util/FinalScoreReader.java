package tatai.util;

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
	
	public ObservableList<FinalScore> read() {
		ObservableList<FinalScore> output = FXCollections.observableArrayList();
		
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try {
			fileReader = new FileReader(_file);
			bufferedReader = new BufferedReader(fileReader);
			
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				output.add(new FinalScore(line));
			}
		
		} catch (FileNotFoundException e) {
			return output;
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
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
