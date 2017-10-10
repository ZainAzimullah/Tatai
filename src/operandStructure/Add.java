package operandStructure;

public class Add extends Operator {

	@Override
	protected int calculate() {
		
		int sum = 0;
		
		for(Operand operand : _operands) {
			
			sum += operand.getResult();
		}
		
		return sum;
		
	}

}
