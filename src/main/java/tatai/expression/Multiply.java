package tatai.expression;

import tatai.exceptions.ResultOutOfRangeException;

/**
 * The Multiply class is an internal node which can
 * recursively multiply other multiplications or MaoriNumbers
 */
public class Multiply extends Operator {


	@Override
	protected int calculate() throws ResultOutOfRangeException {
		int product = 1;
		
		//Loop through operands and calculate product
		for(Operand operand : _operands) {
			product *= operand.getResult();
		}

		return product;
	}

	@Override
	protected String operatorString() {
		return "x";
	}

}
