package tatai.score;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ScoreProperties {

    public String getDate() {
        return _date.get();
    }

    public StringProperty dateProperty() {
        return _date;
    }

    public String getDifficulty() {
        return _difficulty.get();
    }

    public StringProperty difficultyProperty() {
        return _difficulty;
    }

    public String getTotal() {
        return _total.get();
    }

    public StringProperty totalProperty() {
        return _total;
    }

    public String getNumMistakes() {
        return _numMistakes.get();
    }

    public StringProperty numMistakesProperty() {
        return _numMistakes;
    }

    private StringProperty _date, _difficulty, _total, _numMistakes;

    public ScoreProperties(Score score) {
        _date = new SimpleStringProperty(score.getTime());
        _difficulty = new SimpleStringProperty(score.getDifficulty().toString());
        _total = new SimpleStringProperty(Integer.toString(score.getTotal()));
        _numMistakes = new SimpleStringProperty(Integer.toString(score.getNumMistakes()));
    }
}
