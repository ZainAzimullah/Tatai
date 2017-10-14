package tatai.score;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import tatai.expression.Operand;

public class FinalResult {

    private String _expression;
    private int _numMistakes, _questionNumber;
    private Result.State _state;

    public String getExpression() {
        return _expression;
    }

    public int getNumMistakes() {
        return _numMistakes;
    }

    public int getQuestionNumber() {
        return _questionNumber;
    }

    public Result.State getState() {
        return _state;
    }

    public FinalResult(int questionNumber, Operand question, Result result) {
        _state = result.getState();
        _numMistakes = result.getErrorCount();
        _questionNumber = questionNumber;
        _expression = question.toString();
    }
}
