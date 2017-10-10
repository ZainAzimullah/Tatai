package tatai.operandModel;

public class Subtract extends Operator {

	/**
	 * this class is responsible for the subtraction of all of its operands from the
	 * first element
	 */

	// protected method that calculates the sum of all the operands
	@Override
	protected int calculate() {

		// initializes the variable to keep track of what the sum is, starting with the
		// first element
		int sum = _operands.get(0).getResult();
		// removes the first element of the operands after it has been initializes as
		// the sum variable
		_operands.remove(0);

		// iterates through each operand to perform actions on it
		for (Operand operand : _operands) {

			// subtracts each operand one after the other from the first operand element, so
			// it can be returned as the sum
			sum -= operand.getResult();
		}

		// returns the subtraction result to the caller
		return sum;

	}

}
