package tatai.expressionModel;

import tatai.exceptions.OutOfItemsException;
import tatai.expression.Operand;

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
        return questionNumber;
    }
}
