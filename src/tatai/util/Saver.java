package tatai.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Saver {
	public void save(FinalScore finalScore) {
		File file = new File("history.txt");
		FileWriter writer;
		
		try {
			writer = new FileWriter(file, true);
			writer.append(finalScore.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
