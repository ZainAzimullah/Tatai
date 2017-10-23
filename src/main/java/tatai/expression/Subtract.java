package tatai.expression;

import tatai.exceptions.ResultOutOfRangeException;

/**
 * The Subtract class is an internal node which can
 * recursively subtract other subtractions or MaoriNumbers
 */
public class Subtract extends Operator {

	@Override
	protected int calculate() throws ResultOutOfRangeException {
		int sum = _operands.get(0).getResult();
		boolean firstOperand = true;

		// Subtract all operands from first operand
		for (Operand operand : _operands) {
			// Ignore first operand
			if (firstOperand) {
				firstOperand = false;
				continue;
			}

			sum -= operand.getResult();
		}

		return sum;
	}

	@Override
	protected String operatorString() {
		return "-";
	}
}
