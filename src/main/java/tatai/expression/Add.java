package tatai.expression;

import tatai.exceptions.ResultInvalidException;

/**
 * The Add class is an internal node which can
 * recursively add other Operators or MaoriNumbers
 */
public class Add extends Operator {

	@Override
	protected int calculate() throws ResultInvalidException {

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
