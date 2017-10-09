package operandStructure;

import java.util.ArrayList;

public abstract class Operator extends Operand {
	
	protected ArrayList<Operand> _operands;
	
	protected abstract int calculate();
	
}
