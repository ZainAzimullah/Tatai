package tatai.expression;

public class Multiply extends Operator {

	/**
	 * this class is responsible for the multiplication of all of its operands
	 */

	//protected method that calculates the product of all the operands
	@Override
	protected int calculate() {
		
		//Initializes the product variable so that it can used in the product calculations
		int product = 1;
		
		//loops through each operand and preforms actions on them
		for(Operand operand : _operands) {
			
			//multiplies each operand together so that i can be returned as the sum
			product *= operand.getResult();
		}
		
		//returns the result to the caller
		return product;
		
	}

	@Override
	protected String operatorString() {
		return "x";
	}

}
