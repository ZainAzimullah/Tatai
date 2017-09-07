package tatai.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public abstract class NumberModel {

	protected MaoriNumber _currentNumber;
	protected List<MaoriNumber> _numbers = new LinkedList<MaoriNumber>();

	protected NumberModel(int maxValue, int minValue) {
		Random rand = new Random();

		for (int index = 0; index < 10; index++) {
			// creating a number between the range of minValue - maxValue and using it to
			// generate
			// a Maori number that is then stored in a list to set up the stages for the
			// easy game mode
			_numbers.add(new MaoriNumber(rand.nextInt(maxValue) + minValue));
		}

		// setting the very first number in the sequence of number to the variable
		// assigned for keeping
		// track of the current number being used in the game.
		_currentNumber = _numbers.iterator().next();

	}

	public void advance() {
		_currentNumber = _numbers.iterator().next();
	}

	public MaoriNumber getCurrentMaoriNumber() {
		return _currentNumber;
	}
}
