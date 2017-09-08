package tatai.bashTools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Consumer extends Thread {
	
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
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
