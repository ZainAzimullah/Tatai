package operandStructure;

public class Add extends Operator {

	@Override
	protected int calculate() {
		
		int result = 0;
		
		for(Operand operand : _operands) {
			result += operand.getResult();
		}
		
		return result;
		
	}

}
