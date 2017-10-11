package tatai.expression;

import tatai.exceptions.ResultOutOfRangeException;
import tatai.numberModel.MaoriNumber;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Operator extends Operand {

	/**
	 * This class is responsible for containing all fields and methods anything that
	 * classifies as a operator should have in this implementation an operator is a
	 * type of operand.  Composite pattern has been used here.
	 */

	// a list of operands that the operator must perform actions on.
	// Declaring such a list in this class will reduce code repetition for child
	// classes
	protected ArrayList<Operand> _operands = new ArrayList<Operand>();

	// all children must have a concrete method for performing calculations to a
	// list of operands
	protected abstract int calculate() throws ResultOutOfRangeException;

	// this method is used to put operands into the list of operands.
	// this method was specifically implemented, as there is no reliable way to
	// determine exactly how many operands a single operation should take, (ie. an
	// operation can take anywhere from 1 - 100 arguements)
	public void addOperand(Operand operand) {
		_operands.add(operand);
	}
	public void addAllOperands(Operand... operands) {
		_operands.addAll(Arrays.asList(operands));
	}


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

	// Hook method
	protected abstract String operatorString();
}
