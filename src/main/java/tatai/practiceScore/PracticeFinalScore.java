package tatai.practiceScore;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import tatai.practiceScore.PracticeScore.PracticeResult;
import tatai.util.PracticeLevel;

public class PracticeFinalScore {
	
	// Properties:
	private StringProperty _numCorrect = new SimpleStringProperty();
	private StringProperty _numIncorrect = new SimpleStringProperty();
	private StringProperty _numAttempts = new SimpleStringProperty();
	private StringProperty _numMistakes = new SimpleStringProperty();
	private StringProperty _level = new SimpleStringProperty();
	
	// All properties:
	private ArrayList<StringProperty> _properties;
	
	// String representatin of instance
	private String _inText;
	
	// Create PracticeFinalScore object given a PracticeScore object
	public PracticeFinalScore(PracticeScore score, PracticeLevel level) {
		
		// Set properties
		_numCorrect.set(Integer.toString(score.getNumberOf(PracticeResult.CORRECT) +
				score.getNumberOf(PracticeResult.INCORRECT_ONCE)));
		_numIncorrect.set(Integer.toString(score.getNumberOf(PracticeScore.PracticeResult.FAILED)));
		_numAttempts.set(Integer.toString(score.getNumberOfAttempts()));
		_numMistakes.set(Integer.toString(score.getNumberOfMistakes()));
		_level.set(level.toString());
		
		// Put all properties in list
		_properties = new ArrayList<>();
		_properties.addAll(Arrays.asList(_numCorrect, 
				_numIncorrect, _numAttempts, _numMistakes, _level));
		
		// Create String representation
		_inText = "";
		
		for (StringProperty property: _properties) {
			_inText += property.get() + "\t";
		}
		
		// Remove last tab character
		_inText.substring(0, _inText.length()-1);
	}
	
	// Create PracticeFinalScore object given a string
	public PracticeFinalScore(String inText) {
		
		// Divide String into parts
		String[] strings = inText.split("\\t");
		
		// Assign properties
		_numCorrect.set(strings[0]);
		_numIncorrect.set(strings[1]);
		_numAttempts.set(strings[2]);
		_numMistakes.set(strings[3]);
		_level.set(strings[4]);
		
		// Put properties in list
		_properties = new ArrayList<>();
		_properties.addAll(Arrays.asList(_numCorrect, 
				_numIncorrect, _numAttempts, _numMistakes, _level));
		
		// Lastly, store the string itself
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
