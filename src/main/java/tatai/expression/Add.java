package tatai.expression;

import tatai.exceptions.ResultOutOfRangeException;

/**
 * The Add class is an internal node which can
 * recursively add other additions or MaoriNumbers
 */
public class Add extends Operator {

	@Override
	protected int calculate() throws ResultOutOfRangeException {

		int sum = 0;
		
		//Sum up the operands
		for(Operand operand : _operands) {
			sum += operand.getResult();
		}

		return sum;
	}

	@Override
	protected String operatorString() {
		return "+";
	}

}
