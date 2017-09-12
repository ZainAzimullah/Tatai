package tatai.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Saver {
	public void save(FinalScore finalScore) {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("HH-mm-ss_dd-MM-yyyy");
		System.out.println(format.format(date));
		
		FileOutputStream fileOut = null;
		ObjectOutputStream objOut = null;
		
		try {
			fileOut = new FileOutputStream(System.getProperty("user.dir") + "\\" + format.format(date) + ".ser");
			objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(finalScore);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
