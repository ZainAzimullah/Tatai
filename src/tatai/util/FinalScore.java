package tatai.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import tatai.util.Score.Result;

public class FinalScore {

	private StringProperty _numCorrect = new SimpleStringProperty();
	private StringProperty _numIncorrect = new SimpleStringProperty();
	private StringProperty _numAttempts = new SimpleStringProperty();
	private StringProperty _numMistakes = new SimpleStringProperty();
	private StringProperty _level = new SimpleStringProperty();
	
	private ArrayList<StringProperty> _properties;
	
	private String _inText;
	
	public FinalScore(Score score, Level level) {
		_numCorrect.set(Integer.toString(score.getNumberOf(Result.CORRECT)));
		_numIncorrect.set(Integer.toString(score.getNumberOf(Result.FAILED)));
		_numAttempts.set(Integer.toString(score.getNumberOfAttempts()));
		_numMistakes.set(Integer.toString(score.getNumberOfMistakes()));
		_level.set(level.toString());
		
		_properties = new ArrayList<>();
		_properties.addAll(Arrays.asList(_numCorrect, 
				_numIncorrect, _numAttempts, _numMistakes, _level));
		
		_inText = "";
		
		for (StringProperty property: _properties) {
			_inText += property.get() + "\t";
		}
		
		_inText.substring(0, _inText.length()-1);
	}
	
	public FinalScore(String inText) {
		String[] strings = inText.split("\\t");
		
		_numCorrect.set(strings[0]);
		_numIncorrect.set(strings[1]);
		_numAttempts.set(strings[2]);
		_numMistakes.set(strings[3]);
		_level.set(strings[4]);
		
		_properties = new ArrayList<>();
		_properties.addAll(Arrays.asList(_numCorrect, 
				_numIncorrect, _numAttempts, _numMistakes, _level));
		
		_inText = inText;
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
	
	@Override
	public String toString() {
		return _inText;
	}
}
