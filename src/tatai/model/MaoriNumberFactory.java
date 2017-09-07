package tatai.model;

import tatai.Level;
import tatai.TataiException;

public class MaoriNumberFactory {
	private static MaoriNumberModel _model;
	
	public static MaoriNumberModel getNumberModel(Level level) {
		switch (level) {
		
		case EASY:
			return new EasyNumberModel();

		case HARD:
			return new HardNumberModel();
			
		default:
			throw new TataiException("Unhandled level chosen");

		}
	}
}
