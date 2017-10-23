package tatai.expression;

import tatai.exceptions.ResultInvalidException;
import tatai.numberModel.MaoriNumber;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Operator is a composite which is some sort of concrete
 * Operator object (such as Add, Divide, etc).  It can contain
 * other Operands. That is, an Operator can contain other
 * Operators or MaoriNumbers.  Composite pattern has been
 * enforced here, where an Operator is an internal node
 * and a MaoriNumber is a leaf of the recursive expression tree.
 */
public abstract class Operator extends Operand {
	// Children
	protected ArrayList<Operand> _operands = new ArrayList<Operand>();

	// Add children
	public void addOperand(Operand operand) {
		_operands.add(operand);
	}
	public void addAllOperands(Operand... operands) {
		_operands.addAll(Arrays.asList(operands));
	}

	// Strategy pattern enforced here - every child must implement their own calculation strategy
	protected abstract int calculate() throws ResultInvalidException;

	// Hook method for children to specify the string representation of their operand
	protected abstract String operatorString();

	// Put the expression into String form (using template method)
	@Override
	public final String toString() {
		String out = "("; // Start with open bracket

		// Iterate through each suboperand
		for (Operand operand: _operands) {

			// Get number if operand is a number, or get suboperand string
			if (operand instanceof MaoriNumber) {
				out += Integer.toString(((MaoriNumber) operand).getDigits());
			} else if (operand instanceof  Operator) {
				out += ((Operator) operand).toString();
			} else {
				throw new RuntimeException();
			}
			// Include the operator in the String (hook call)
			out += " " + operatorString() + " ";
		}

		// Trim off extra operand
		out = out.substring(0, out.length() - 3);
		out += ")";

		return out;
	}
}
