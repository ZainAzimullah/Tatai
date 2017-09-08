package tatai.model;

import tatai.Level;
import tatai.TataiException;

public class MaoriNumberModelFactory {
	private static MaoriNumberModel _model;
	
	public static MaoriNumberModel getMaoriNumberModel(Level level) {
		switch (level) {
		
		case EASY:
			return new EasyMaoriNumberModel();

		case HARD:
			return new HardMaoriNumberModel();
			
		default:
			throw new TataiException("Unhandled level chosen");

		}
	}
}
