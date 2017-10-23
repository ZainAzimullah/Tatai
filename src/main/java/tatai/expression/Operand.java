package tatai.expression;

import tatai.exceptions.ResultOutOfRangeException;
import tatai.exceptions.TataiException;
import tatai.numberModel.MaoriNumber;

/**
 * This abstract class is an interface for client code
 * dealing with recursive structures involving operands and operators.
 * An Operand can either be a MaoriNumber, or an Operator.  Class Operator
 * subclasses this class, and aggregates it.  That is, an Operator can contain
 * other Operands, whether they be other Operators or MaoriNumbers.
 */
public abstract class Operand {

	// Recursively conduct calculate the result using a Depth-First Traversal
	//	- Operators are internal nodes
	// 	- MaoriNumbers are leaves
	protected final int getResult() throws TataiException, ResultOutOfRangeException {

		if (this instanceof MaoriNumber) {
			// Get digits if bottom of recursive call reached
			return ((MaoriNumber) this).getDigits();
		} else if (this instanceof Operator) {
			// Pass down recursive call if operator (internal node) reached.
			return ((Operator) this).calculate();
		} else {
			throw new TataiException("Unexpected operand detected, cannot return an integer value for it");
		}

	}

	// Same as getResult() except this method is visible to clients using the Operand interface.
	public final MaoriNumber getMaoriResult() throws ResultOutOfRangeException {
		if (this instanceof MaoriNumber) {
			return (MaoriNumber) this;
		} else if (this instanceof Operator) {
			try {
				return new MaoriNumber(((Operator) this).calculate());
			} catch (TataiException tataie) {
				throw new ResultOutOfRangeException();
			}
		} else {
			throw new TataiException("Unexpected operand detected");
		}
	}

}
