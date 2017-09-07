package tatai.model;

import tatai.TataiException;

// This class represents a Maori number/English number pairing
public class MaoriNumber implements Comparable<MaoriNumber> {
	private String _maoriName;
	private Integer _number;
	
	public MaoriNumber(String maoriName, int number) {
		_maoriName = maoriName;
		_number = number;
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
}
