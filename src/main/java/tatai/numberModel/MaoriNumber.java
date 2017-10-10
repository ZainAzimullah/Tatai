package tatai.numberModel;

import java.util.HashMap;
import java.util.Map;

import tatai.exceptions.TataiException;
import tatai.expression.Operand;

// This class represents a Maori number/English number pairing
public class MaoriNumber extends Operand implements Comparable<MaoriNumber> {

	// private strings used to store the actual integer and the maori form of the
	// integer for what 'this' is asked to represent
	private String _maoriName;
	private Integer _number;

	// public constructor used toe generate the maori form of a given integer
	// argument
	public MaoriNumber(int number) {
		// checking if the number is valid ()
		if ((number <= 0) || (number > 99)) {
			// if the number is invalid ( integer is < 0 or integer is > 99) then throw a
			// new tatai exception
			throw new TataiException("Invalid number");
		}

		// otherwise assign the field used to track the actual integer to the input
		// integer argument
		_number = number;
		// call a private method to identify what maori words corresponds with the
		// integer
		setMaoriName(number);
	}
	
	public int getDigit() {
		return _number;
	}

	// method used to compare two MaoriNumber Objects, this is done by comparing the
	// integer values they are representing
	@Override
	public int compareTo(MaoriNumber otherNumber) {
		return _number.compareTo(otherNumber._number);
	}

	// method used to determine if two MaoriNumber objects, each representing an
	// integer, are the same
	@Override
	public boolean equals(Object otherNumber) {
		if (!(otherNumber instanceof MaoriNumber)) {
			// if the other object we are trying to compare MoariNumber is not an instance
			// of a MaoriNumber then throw new tatai exception as they are not comparable
			throw new TataiException("Trying to compare non-MaoriNumber to MaoriNumber");
		}

		// else compare the two integers the MaoriNumber object is representing
		return _number.equals(((MaoriNumber) otherNumber)._number);
	}

	// returns the maori representation of the integer 'this' object is representing
	@Override
	public String toString() {
		return _maoriName;
	}

	// Work out what the Maori word is for a given integer
	private void setMaoriName(int number) {
		// determine if the integer is 10
		if (number == 10) {
			// if the integer is 10 then set the maori name as 10 and return
			_maoriName = "tekau";
			return;
		}

		// setting up a HashMap to allocate a maori word for every number
		Map<Integer, String> map = new HashMap<>();

		map.put(1, "tahi");
		map.put(2, "rua");
		map.put(3, "toru");
		map.put(4, "whaa");
		map.put(5, "rima");
		map.put(6, "ono");
		map.put(7, "whitu");
		map.put(8, "waru");
		map.put(9, "iwa");

		// if the integer is less than 10 then
		if (number < 10) {
			// just allocate one word to the integer
			_maoriName = map.get(number);
		}

		// otherwise if the integer is >10 then
		else {
			// determine what the 10's and 1's digit is
			int tens = number / 10;
			int ones = number % 10;

			// if the integer's 1's digit is a "0" then just append a space and "tekau" to
			// the end of the maori word for the 10's digit
			if (ones == 0) {
				_maoriName = map.get(tens) + " tekau";
				return;
			}

			// otherwise in the 10's digit is a "1" append the Maori word for the 1's digit
			// to "tekau ma "
			if (tens == 1) {
				_maoriName = "tekau maa " + map.get(ones);
				return;
			}

			// otherwise if none of the above apply to the integer in question then set the
			// maori word for the integer as the maori word for the 10's digit followed by
			// "tekau ma " then followed by the maori word for the 1's digit
			_maoriName = map.get(tens) + " tekau maa ";
			_maoriName += map.get(ones);
		}
	}
}
