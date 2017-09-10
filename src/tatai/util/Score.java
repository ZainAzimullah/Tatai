package tatai.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Score {
	private Map<Integer, Integer> _scoreMap;
	
	public Score(int numOfQuestions) {
		_scoreMap = new HashMap<>();
		
		for (int i = 1; i <= 10; i++) {
			_scoreMap.put(i, 0);
		}
	}
	
	public void updateIncorrectTally(int questionNumber) {
		Integer tally = _scoreMap.get(questionNumber);
		tally++;
	}
	
	public int getNumberOfCorrectOnFirstTry() {
		return Collections.frequency(_scoreMap.values(), 0);
	}
	
	public int getNumberOfCorrect() {
		return (_scoreMap.size() - Collections.frequency(_scoreMap.values(), 2));
	}
	
	public int getNumberOfIncorrect() {
		return Collections.frequency(_scoreMap.values(), 2);
	}
	
}
