package tatai.score;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * This class is equivalent to a FinalResult object, however it also contains
 * StringProperties for each field, to allow JavaFX to display these in a table.
 */
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

    private FinalResultProperties(FinalResult result) {
        _expression = new SimpleStringProperty(result.getExpression());
        _numMistakes = new SimpleStringProperty(Integer.toString(result.getNumMistakes()));
        _questionNumber = new SimpleStringProperty(Integer.toString(result.getQuestionNumber()));
        _state = new SimpleStringProperty(result.getState().toString());
    }

    // Get an ObservableList of FinalResultProperties objects for a given Score object
    public static ObservableList<FinalResultProperties> getObservableList(Score score) {
        ArrayList<FinalResult> results = score.getFinalResults();
        ObservableList<FinalResultProperties> out = FXCollections.observableArrayList();

        for (FinalResult result: results) {
            out.add(new FinalResultProperties(result));
        }

        return out;
    }
}
