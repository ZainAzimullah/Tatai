package tatai.expression;

import tatai.exceptions.ResultOutOfRangeException;

public class Add extends Operator {
	
	/**
	 * this class is responsible for the addition of all of its operands
	 */

	//protected method that calculates the sum of all the operands
	@Override
	protected int calculate() throws ResultOutOfRangeException {
		
		//initializes the variable to keep track of the sum
		int sum = 0;
		
		//iterates through each of the operands and preforms actions on them
		for(Operand operand : _operands) {
			
			//sums up each operand to obtain a sum to return
			sum += operand.getResult();
		}
		
		//returns the sum
		return sum;
		
	}

	@Override
	protected String operatorString() {
		return "+";
	}

}
