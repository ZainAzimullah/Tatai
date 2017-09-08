package tatai.bashTools;

import java.io.InputStream;

import tatai.Game;

public class HTKConsumer extends Consumer {

	public HTKConsumer(InputStream inputStream) {
		super(inputStream);
	}
	
	@Override
	protected void readOutput(String line) {
		
	}

}
