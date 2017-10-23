package tatai.expression;

import tatai.exceptions.ResultOutOfRangeException;

/**
 * The Divide class is an internal node which can
 * recursively divide other Additions or MaoriNumbers
 */
public class Divide extends Operator {


    @Override
    protected int calculate() throws ResultOutOfRangeException {
        double result = _operands.get(0).getResult();
        boolean firstOperand = true;

        for (Operand operand : _operands) {
            // Ignore first operand
            if (firstOperand) {
                firstOperand = false;
                continue;
            }

            // Keep dividing each operand
            result /= operand.getResult();
        }

        // Check if result is whole number
        if (!(result % 1 == 0)) {
            throw new ResultOutOfRangeException();
        }

        return (int) result;
    }

    @Override
    protected String operatorString() {
        return "÷";
    }
}
