package tatai.model;

import tatai.exceptions.TataiException;
import tatai.util.Level;

// This class instantiates a MaoriNumberModel depending on a
// given level.
public class MaoriNumberModelFactory {
	// Create a MaoriNumberModel for a given level.
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
