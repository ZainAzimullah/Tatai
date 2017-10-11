package tatai.expression;

import tatai.exceptions.ResultOutOfRangeException;

public class Divide extends Operator {
    @Override
    protected int calculate() throws ResultOutOfRangeException {
        // initializes the variable to keep track of what the sum is, starting with the
        // first element
        double sum = _operands.get(0).getResult();
        boolean firstOperand = true;
        // iterates through each operand to perform actions on it
        for (Operand operand : _operands) {
            if (firstOperand) {
                firstOperand = false;
                continue;
            }

            // subtracts each operand one after the other from the first operand element, so
            // it can be returned as the sum
            sum /= operand.getResult();
        }

        if (!(sum % 1 == 0)) {
            throw new ResultOutOfRangeException();
        }

        // returns the subtraction result to the caller
        return (int) sum;
    }

    @Override
    protected String operatorString() {
        return "/";
    }
}
