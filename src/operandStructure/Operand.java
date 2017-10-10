package operandStructure;

import tatai.exceptions.ResultOutOfRangeException;
import tatai.exceptions.TataiException;
import tatai.model.MaoriNumber;

public abstract class Operand {

	protected final int getResult() throws TataiException {

		if (this instanceof MaoriNumber) {

			return ((MaoriNumber) this).getDigit();

		} else if (this instanceof Operator) {

			return ((Operator)this).calculate();

		} else {

			throw new TataiException("Unexpected operand detected");

		}

	}

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
