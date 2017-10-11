package tatai.expressionModel;

import tatai.exceptions.OutOfItemsException;
import tatai.exceptions.ResultOutOfRangeException;
import tatai.exceptions.TataiException;
import tatai.expression.Operand;
import tatai.numberModel.MaoriNumber;

import java.util.ArrayList;
import java.util.List;

public abstract class ExpressionModel {

    private int questionNumber = -1;
    protected List<Operand> _expressions = new ArrayList<>();

    public int getSize() {
        return _expressions.size();
    }

    public Operand getNext() throws OutOfItemsException {
        questionNumber++;

        if (questionNumber >= _expressions.size()) {
            throw new OutOfItemsException("No more expressions left in list");
        }

        return _expressions.get(questionNumber);
    }

    public int getCurrentQuestionNumber() {
        return questionNumber + 1;
    }

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

    protected MaoriNumber generateRandomMaoriNumber(int limit) {
        return new MaoriNumber((int) (Math.random() * limit + 1));
    }

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
