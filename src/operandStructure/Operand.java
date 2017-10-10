package operandStructure;

import tatai.exceptions.TataiException;
import tatai.model.MaoriNumber;

public abstract class Operand {
	
	protected Operand _operand;
	
	protected final int getResult() throws TataiException {
		
		if(_operand instanceof MaoriNumber) {
			
			return ((MaoriNumber) _operand).getDigit();
			
		} else if(_operand instanceof Operator) {
			
			return _operand.getResult();
			
		} else {
			
			throw new TataiException("Unexpected operand detected");
			
		}
		
	}
	
	public final MaoriNumber getMaoriResult() {
		
		return new MaoriNumber(_operand.getResult());
		
	}

}
