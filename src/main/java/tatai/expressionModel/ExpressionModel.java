package tatai.expressionModel;

import tatai.exceptions.OutOfItemsException;
import tatai.exceptions.ResultOutOfRangeException;
import tatai.exceptions.TataiException;
import tatai.expression.Operand;
import tatai.numberModel.MaoriNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * Any ExpressionModel contains a collection of Operands (expressions) and should
 * extend this class to inherit the List/
 */
public abstract class ExpressionModel {

    private int questionNumber = -1;  // Invoking getNext() moves this to 0 (first queston)
    protected List<Operand> _expressions = new ArrayList<>();

    // Get the next question
    public Operand getNext() throws OutOfItemsException {
        questionNumber++;
        if (questionNumber >= _expressions.size()) {
            throw new OutOfItemsException("No more expressions left in list");
        }

        return _expressions.get(questionNumber);
    }

    // Get the size of the model
    public int getSize() {
        return _expressions.size();
    }

    // Reset the pointer to negative 1
    public void reset() {
        questionNumber = -1;
    }

    // Get the question number, adjusted to start from 1 for user
    public int getCurrentQuestionNumber() {
        return questionNumber + 1;
    }

    // Utility method for subclasses to be able to pick an Operation at random
    protected Operation generateRandomOperation() {
        int randomNumber = (int) (Math.random() * 4 + 1);

        switch (randomNumber) {
            case 1:
                return Operation.ADD;
            case 2:
                return Operation.SUBTRACT;
            case 3:
                return Operation.MULTIPLY;
            case 4:
                return Operation.DIVIDE;

            default:
                throw new TataiException("Operation not supported");
        }
    }

    // Utility method for subclasses to get a random MaoriNumber
    protected MaoriNumber generateRandomMaoriNumber(int limit) {
        return new MaoriNumber((int) (Math.random() * limit + 1));
    }

    // Prints out information
    public void debug() {
        int i = 1;
        for (Operand operand: _expressions) {
            try {
                System.out.println(i + ": " + operand + " = " + operand.getMaoriResult().getDigits());
            } catch (ResultOutOfRangeException e) {
                e.printStackTrace();
            }
            i++;
        }
    }
}
