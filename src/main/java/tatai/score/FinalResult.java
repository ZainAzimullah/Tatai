package tatai.score;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import tatai.expression.Operand;

public class FinalResult {

    private StringProperty _state;

    public String getState() {
        return _state.get();
    }

    public StringProperty stateProperty() {
        return _state;
    }

    public String getNumMistakes() {
        return _numMistakes.get();
    }

    public StringProperty numMistakesProperty() {
        return _numMistakes;
    }

    public String getQuestionNumber() {
        return _questionNumber.get();
    }

    public StringProperty questionNumberProperty() {
        return _questionNumber;
    }

    public StringProperty expressionProperty() {
        return _expression;
    }

    private StringProperty _numMistakes;
    private StringProperty _questionNumber;
    private StringProperty _expression;


    public FinalResult(int questionNumber, Operand question, Result result) {
        _state = new SimpleStringProperty(result.getState().toString());
        _numMistakes = new SimpleStringProperty(Integer.toString(result.getErrorCount()));
        _questionNumber = new SimpleStringProperty(Integer.toString(questionNumber));
        _expression = new SimpleStringProperty(question.toString());
    }
}
