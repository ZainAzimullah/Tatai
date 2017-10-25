package tatai.expression;

import tatai.exceptions.ResultInvalidException;

/**
 * The Subtract class is an internal node which can
 * recursively subtract other Operators or MaoriNumbers
 */
public class Subtract extends Operator {

	@Override
	protected int calculate() throws ResultInvalidException {
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
