package tatai.expression;

import tatai.exceptions.ResultOutOfRangeException;

public class Subtract extends Operator {

	/**
	 * this class is responsible for the subtraction of all of its operands from the
	 * first element
	 */

	// protected method that calculates the sum of all the operands
	@Override
	protected int calculate() throws ResultOutOfRangeException {

		// initializes the variable to keep track of what the sum is, starting with the
		// first element
		int sum = _operands.get(0).getResult();
		boolean firstOperand = true;
		// iterates through each operand to perform actions on it
		for (Operand operand : _operands) {
			if (firstOperand) {
				firstOperand = false;
				continue;
			}

			// subtracts each operand one after the other from the first operand element, so
			// it can be returned as the sum
			sum -= operand.getResult();
		}

		// returns the subtraction result to the caller
		return sum;

	}

	@Override
	protected String operatorString() {
		return "-";
	}

}
