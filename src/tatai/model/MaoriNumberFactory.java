package tatai.model;

import tatai.Level;
import tatai.TataiException;

public class MaoriNumberFactory {
	private static MaoriNumberModel _model;
	
	public static MaoriNumberModel getNumberModel(Level level) {
		switch (level) {
		
		case EASY:
			return new EasyMaoriNumberModel(1, 9);

		case HARD:
			return new HardMaoriNumberModel(11, 99);
			
		default:
			throw new TataiException("Unhandled level chosen");

		}
	}
}
