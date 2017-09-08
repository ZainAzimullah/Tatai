package tatai.bashTools;

import java.io.InputStream;

public class HTKConsumer extends Consumer {

	public HTKConsumer(InputStream inputStream) {
		super(inputStream);
	}
	
	@Override
	protected void readOutput(String line) {
		System.out.println(line);
	}

}
