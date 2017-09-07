package model;

import tatai.TataiException;

// This class represents a Maori number/English number pairing
public class Number implements Comparable<Number> {
	private String _maoriName;
	private Integer _number;
	
	public Number(int number) {
		_number = number;
	}
	
	public Number(String maoriName) {
		_maoriName = maoriName;
	}

	@Override
	public int compareTo(Number otherNumber) {
		return _number.compareTo(otherNumber._number);
	}
	
	@Override
	public boolean equals(Object otherNumber) {
		if (!(otherNumber instanceof Number)) {
			throw new TataiException("Trying to compare non-Number to Number");
		}
		
		return _number.equals(((Number) otherNumber)._number);
	}
}
