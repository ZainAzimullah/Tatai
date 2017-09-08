package tatai.model;

public class HardMaoriNumberModel extends MaoriNumberModel {

	// private final variables that are used to store the maximum and minimum values
	// the maori numbers can be for the hard mode of the game. (in the hard mode the
	// range is 1 - 99)
	// these in addition also make it easier to maintain as it reduces magic numbers
	// scattered throughout the class
	private static final int _MAX_VALUE = 99;
	private static final int _MIN_VALUE = 1;

	// public constructor used for creating an hard mode number model (1 - 99 in
	// maori)
	// that is used for in the hard mode of the tatai game
	public HardMaoriNumberModel() {
		super(_MAX_VALUE, _MIN_VALUE);
		System.out.println(_currentNumber);
	}
}
