package tatai.score;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * This is a wrapper class which converts a Score object into its
 * equivalent object with properties.  The raw Score object can still
 * be retrieved from a ScoreProperties object by invoking getScore()
 */
public class ScoreProperties {

    private StringProperty _date, _difficulty, _total, _numMistakes;

    private Score _score;

    public ScoreProperties(Score score) {
        _score = score;
        _date = new SimpleStringProperty(score.getTime());
        _difficulty = new SimpleStringProperty(score.getDifficulty().toString());
        _total = new SimpleStringProperty(Integer.toString(score.getTotal()));
        _numMistakes = new SimpleStringProperty(Integer.toString(score.getNumMistakes()));
    }

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

    public Score getScore() {
        return _score;
    }
}
