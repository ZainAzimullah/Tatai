package tatai.expression;

import tatai.exceptions.ResultOutOfRangeException;
import tatai.exceptions.TataiException;
import tatai.numberModel.MaoriNumber;

public abstract class Operand {

	/**
	 * this class is responsible for containing methods that all operands should
	 * have, this primarily includes methods that will return the integer and Maori
	 * number results to the caller.
	 */

	// protected method that cannot be changed for all subclasses to use to obtain
	// the integer value for a particular operand
	protected final int getResult() throws TataiException {

		// if the operand instance is a MaoriNumber
		if (this instanceof MaoriNumber) {

			// the return to the caller the integer value of the Maori number
			return ((MaoriNumber) this).getDigit();

			// otherwise if the operand instance is an operator
		} else if (this instanceof Operator) {

			// then assign it as an operator and return the integer value calculated from
			// the operator's calculate method
			return ((Operator) this).calculate();

			// if the operand is not an instance of either
		} else {

			// then something has gone wrong and report it as an error
			throw new TataiException("Unexpected operand detected, cannot return an integer value for it");

		}

	}

	// protected method that cannot be changed for all subclasses to use to obtain
	// the integer Maori number representation for a particular operand
	public final MaoriNumber getMaoriResult() throws ResultOutOfRangeException {

		// if the operand instance if a MaoriNumber
		if (this instanceof MaoriNumber) {

			// then just return the operand instance, because it already is a maori number
			return (MaoriNumber) this;

			// if the operand instance is an operator
		} else if (this instanceof Operator) {

			// attempt to generate a Maori number from the integer value obtained from the
			// instances' calculate method
			try {

				return new MaoriNumber(((Operator) this).calculate());

			} catch (TataiException tataie) {

				// if this cannot be done and the integer value is outside the recognizable
				// range then catch then catch the error message and declare a new error message
				// so that it can be easily recognize and dealt with by the client code
				throw new ResultOutOfRangeException();
			}

		} else {

			// otherwise something has gone astray and a separate error message must be
			// Declared and thrown
			throw new TataiException("Unexpected operand detected");

		}

	}

}
