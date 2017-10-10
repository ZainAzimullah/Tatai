package operandStructure;

public class Subtract extends Operator {

	@Override
	protected int calculate() {
		
		int sum = _operands.get(0).getResult();
		_operands.remove(0);
		
		for(Operand operand : _operands) {
			sum -= operand.getResult();
		}
		
		return sum;
				
	}

}
