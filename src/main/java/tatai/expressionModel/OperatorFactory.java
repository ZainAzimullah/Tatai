package tatai.expressionModel;

import tatai.exceptions.TataiException;
import tatai.expression.*;

/**
 * This factory delivers an Operator object based on the specified Operation
 */
public class OperatorFactory {
    private static Operator _operator;

    public static Operator getOperator(Operation operation) {
        switch (operation) {
            case ADD:
                _operator = new Add();
                break;
            case SUBTRACT:
                _operator = new Subtract();
                break;
            case MULTIPLY:
                _operator = new Multiply();
                break;
            case DIVIDE:
                _operator = new Divide();
                break;
            default:
                throw new TataiException("Operation not supported");
        }

        return _operator;
    }
}
