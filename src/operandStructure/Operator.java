package operandStructure;

import java.util.ArrayList;

public abstract class Operator extends Operand {
	
	protected ArrayList<Operand> _operands = new ArrayList<Operand>();
	
	protected abstract int calculate();
	
	public void addOperand(Operand operand) {
		_operands.add(operand);
	}
	
}
