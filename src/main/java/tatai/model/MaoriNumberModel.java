package tatai.model;

import java.util.Random;

import tatai.Game;
import tatai.exceptions.FirstNumberNotAdvancedToException;
import tatai.exceptions.OutOfNumbersException;

public abstract class MaoriNumberModel {
	private final int LIST_SIZE = Game.NUMBER_OF_QUESTIONS;
	//variables used to keep track of what position we are in on the Maori number model
	protected MaoriNumber _currentNumber;
	private int _currentNumberPosition;
	//field used for storing the MaoriNumberModel
	protected MaoriNumber[] _numbers = new MaoriNumber[LIST_SIZE];
	
	//abstract constructor used by children to create an array of MaoriNumbers in a range
	protected MaoriNumberModel(int maxValue, int minValue) {
		Random rand = new Random();

		for (int index = 0; index < 10; index++) {
			// creating a number between the range of minValue - maxValue and using it to
			// generate
			// a Maori number that is then stored in an array to set up the stages for the
			// easy game mode
			_numbers[index] =(new MaoriNumber(rand.nextInt(maxValue) + minValue));
		}

		// initialised pointer to nothing (you must advance first).
		_currentNumber = null;
		_currentNumberPosition = -1;

	}

	//used to get to the next item in the array storing the randomly generated Maori number
	public void advance() throws OutOfNumbersException {
		_currentNumberPosition++;
		
		// Check if advancing beyond list size
		if (_currentNumberPosition == LIST_SIZE) {
			throw new OutOfNumbersException("Advanced too far in list");
		}
		
		_currentNumber = _numbers[_currentNumberPosition];
	}
	
	//getter for returning the current MaoriNumber Object we are pointing at
	public MaoriNumber getCurrentMaoriNumber() {
		if (_currentNumberPosition < 0) {
			throw new FirstNumberNotAdvancedToException("You must first use advance() "
					+ "before you try to get the first Maori Number");
		}
		
		return _currentNumber;
	}
}
