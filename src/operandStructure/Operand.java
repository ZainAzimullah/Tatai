package operandStructure;

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

	public final MaoriNumber getMaoriResult() {

		if (this instanceof MaoriNumber) {
			
			return (MaoriNumber) this;
			
		} else if (this instanceof Operator) {
						
			return new MaoriNumber(((Operator) this).calculate());
			
		} else {

			throw new TataiException("Unexpected operand detected");

		}

	}

}
