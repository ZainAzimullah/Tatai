package tatai.expression;

import tatai.exceptions.ResultInvalidException;
import tatai.numberModel.MaoriNumber;

public class ExpressionTester {
	
	public static void main(String[] args) {
		Operator operandMutiply = new Multiply();
		Operator operandSubstraction = new Subtract();
		
		MaoriNumber num1, num2, num3;
		
		num1 = new MaoriNumber(25);
		num2 = new MaoriNumber(2);
		num3 = new MaoriNumber(3);
		
		operandMutiply.addOperand(num1);
		operandMutiply.addOperand(num2);
		
		operandSubstraction.addOperand(operandMutiply);
		operandSubstraction.addOperand(num3);
		
		
		try {
		MaoriNumber result = operandSubstraction.getMaoriResult();
		System.out.println(result.getDigits());
		} catch (ResultInvalidException tataie) {
			System.out.println("0, #>99 or #<0 detected");
			System.exit(1);
		}
		
	}

}
