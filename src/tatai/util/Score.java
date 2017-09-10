package tatai.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Score {
	
	public enum Result {
		CORRECT,
		INCORRECT,
		FAILED,
		UNATTEMPTED;
	}
	
	private Map<Integer, Result> _scoreMap;
	
	
	public Score(int numOfQuestions) {
		_scoreMap = new HashMap<>();
		
		for (int i = 1; i <= 10; i++) {
			_scoreMap.put(i, Result.UNATTEMPTED);
		}
	}
	
	public void update(int questionNumber, Result result) {
		_scoreMap.put(questionNumber, result);
	}
	
	
	public int getNumberOf(Result result) {
		return Collections.frequency(_scoreMap.values(), result);
	}
	
	public int getNextUnattemptedQuestionNumber() {
		int number = 1;
		
		while (_scoreMap.get(number) != Result.UNATTEMPTED) {
			number++;
		}
		
		return number;
	}
	
	public void debug() {
		for (Map.Entry<Integer, Result> entry: _scoreMap.entrySet()) {
			System.out.println("Key: " + entry.getKey() + "\tValue: " + entry.getValue());
		}
	}
}
