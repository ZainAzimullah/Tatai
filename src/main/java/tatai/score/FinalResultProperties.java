package tatai.score;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class FinalResultProperties {

    public String getExpression() {
        return _expression.get();
    }

    public StringProperty expressionProperty() {
        return _expression;
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

    public String getState() {
        return _state.get();
    }

    public StringProperty stateProperty() {
        return _state;
    }

    private StringProperty _expression, _numMistakes, _questionNumber, _state;

    public FinalResultProperties(FinalResult result) {
        _expression = new SimpleStringProperty(result.getExpression());
        _numMistakes = new SimpleStringProperty(Integer.toString(result.getQuestionNumber()));
        _questionNumber = new SimpleStringProperty(Integer.toString(result.getQuestionNumber()));
        _state = new SimpleStringProperty(result.getState().toString());
    }

    public static ObservableList<FinalResultProperties> getObservableList(Score score) {
        ArrayList<FinalResult> results = score.getFinalResults();
        ObservableList<FinalResultProperties> out = FXCollections.observableArrayList();

        for (FinalResult result: results) {
            out.add(new FinalResultProperties(result));
        }

        return out;
    }
}
