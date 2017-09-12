package tatai.util;

import java.io.Serializable;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import tatai.util.Score.Result;

public class FinalScore implements Serializable {

	private static final long serialVersionUID = 1L;
	private StringProperty _numCorrect = new SimpleStringProperty();
	private StringProperty _numIncorrect = new SimpleStringProperty();
	private StringProperty _numAttempts = new SimpleStringProperty();
	private StringProperty _numMistakes = new SimpleStringProperty();
	private StringProperty _level = new SimpleStringProperty();
	
	public FinalScore(Score score, Level level) {
		_numCorrect.set(Integer.toString(score.getNumberOf(Result.CORRECT)));
		_numIncorrect.set(Integer.toString(score.getNumberOf(Result.FAILED)));
		_numAttempts.set(Integer.toString(score.getNumberOfAttempts()));
		_numMistakes.set(Integer.toString(score.getNumberOfMistakes()));
		_level.set(level.toString());
	}

	public StringProperty getNumberCorrect() {
		return _numCorrect;
	}

	public StringProperty getNumberIncorrect() {
		return _numIncorrect;
	}

	public StringProperty getNumberOfAttempts() {
		return _numAttempts;
	}

	public StringProperty getNumberOfMistakes() {
		return _numMistakes;
	}

	public StringProperty getLevel() {
		return _level;
	}
}
