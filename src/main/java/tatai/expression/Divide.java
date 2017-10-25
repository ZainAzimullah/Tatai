package tatai.expression;

import tatai.exceptions.ResultInvalidException;

/**
 * The Divide class is an internal node which can
 * recursively divide other Operators or MaoriNumbers
 */
public class Divide extends Operator {


    @Override
    protected int calculate() throws ResultInvalidException {
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
            throw new ResultInvalidException();
        }

        return (int) result;
    }

    @Override
    protected String operatorString() {
        return "÷";
    }
}
