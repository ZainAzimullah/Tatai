package tatai.model;

import java.util.HashMap;
import java.util.Map;

import tatai.TataiException;

// This class represents a Maori number/English number pairing
public class MaoriNumber implements Comparable<MaoriNumber> {
	private String _maoriName;
	private Integer _number;
	
	public MaoriNumber(int number) {
		if ((number <= 0) || (number > 99)) {
			throw new TataiException("Invalid number");
		}
		
		_number = number;
		setMaoriName(number);
	}

	@Override
	public int compareTo(MaoriNumber otherNumber) {
		return _number.compareTo(otherNumber._number);
	}
	
	@Override
	public boolean equals(Object otherNumber) {
		if (!(otherNumber instanceof MaoriNumber)) {
			throw new TataiException("Trying to compare non-MaoriNumber to MaoriNumber");
		}
		
		return _number.equals(((MaoriNumber) otherNumber)._number);
	}
	
	@Override
	public String toString() {
		return _maoriName;
	}
	
	// Work out what the Maori word is for a given integer
	private void setMaoriName(int number) {
		if (number == 10) {
			_maoriName = "tekau";
			return;
		}
		
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
		
		if (number < 10) {
			_maoriName = map.get(number);
		} else {
			int tens = number / 10;
			int ones = number % 10;
			
			if (ones == 0) {
				_maoriName = map.get(tens) + " tekau";
				return;
			}
			
			if (tens == 1) {
				_maoriName = "tekau ma " + map.get(ones);
				return;
			}
			
			_maoriName = map.get(tens) + " tekau ma ";
			_maoriName += map.get(ones);
		}
	}
}
