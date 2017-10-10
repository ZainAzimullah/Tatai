package operandStructure;

public class Multiply extends Operator {

	@Override
	protected int calculate() {
		
		int product = 1;
		
		for(Operand operand : _operands) {
			product *= operand.getResult();
		}
		
		return product;
		
	}

}
