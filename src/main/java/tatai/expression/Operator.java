package tatai.expression;

import java.util.ArrayList;

public abstract class Operator extends Operand {

	/**
	 * this class is responsible for containing all fields and methods anything that
	 * classifies as a operator should have in this implementation an operator is a
	 * type of operand
	 */

	// a list of operands that the operator must perform actions on.
	// Declaring such a list in this class will reduce code repetition for child
	// classes
	protected ArrayList<Operand> _operands = new ArrayList<Operand>();

	// all children must have a concrete method for performing calculations to a
	// list of operands
	protected abstract int calculate();

	// this method is used to put operands into the list of operands.
	// this method was specifically implemented, as there is no reliable way to
	// determine exactly how many operands a single operation should take, (ie. an
	// operation can take anywhere from 1 - 100 arguements)
	public void addOperand(Operand operand) {
		_operands.add(operand);
	}

}
