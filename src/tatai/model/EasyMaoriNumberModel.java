package tatai.model;

public class EasyMaoriNumberModel extends NumberModel {

	// private final variables that are used to store the maximum and minimum values
	// the maori numbers
	// can be for the easy mode of the game. (in the easy mode the range is 1 - 9 )
	// these in addition also make it easier to maintain as it reduces magic numbers
	// scattered throughout the class
	private static final int _MAX_VALUE = 9;
	private static final int _MIN_VALUE = 1;

	// public constructor used for creating a easy mode number model (1-9 in maori)
	// that is used for in the easy mode of the tatai game
	public EasyMaoriNumberModel() {
		super(_MAX_VALUE, _MIN_VALUE);
	}
}
