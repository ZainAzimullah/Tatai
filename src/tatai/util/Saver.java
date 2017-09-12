package tatai.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Saver {
	
	private FinalScore _finalScore;
	
	public Saver(FinalScore finalScore) {
		_finalScore = finalScore;
	}
	
	public void save(String filename) {
		File file = new File(System.getProperty("user.dir") + "/" + filename);
		System.out.println(file.getPath());
		
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			System.out.println(_finalScore);
			fileWriter = new FileWriter(file.getAbsoluteFile(), true);
			bufferedWriter = new BufferedWriter(fileWriter);
			
			bufferedWriter.write(_finalScore.toString() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			if (bufferedWriter != null) {
				try {
					bufferedWriter.close();
				} catch (IOException e) {
					
				}
			}
			
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {

				}
			}
		}
	}
}
