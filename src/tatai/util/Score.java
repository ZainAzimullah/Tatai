package tatai.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Score {
	
	public enum Result {
		CORRECT(1),
		INCORRECT(2),
		FAILED(2),
		UNATTEMPTED(0);
		
		private int _attempts;
		
		Result(int attempts) {
			_attempts = attempts;
		}
		
		public int attempts() {
			return _attempts;
		}
	}
	
	private Map<Integer, Result> _resultMap;
	private Map<Integer, Integer> _attemptMap;
	
	
	public Score(int numOfQuestions) {
		_resultMap = new HashMap<>();
		_attemptMap = new HashMap<>();
		
		for (int i = 1; i <= 10; i++) {
			_resultMap.put(i, Result.UNATTEMPTED);
			_attemptMap.put(i, Result.UNATTEMPTED.attempts());
		}
	}
	
	public void update(int questionNumber, Result result) {
		_resultMap.put(questionNumber, result);
		_attemptMap.put(questionNumber, result.attempts());
	}
	
	
	public int getNumberOf(Result result) {
		return Collections.frequency(_resultMap.values(), result);
	}
	
	public int getNumberOfAttempts(int questionNumber) {
		return _attemptMap.get(questionNumber);
	}
	
	public int getTotalNumberOfAttempts() {
		int sum = 0;
		
		for (Map.Entry<Integer, Integer> entry: _attemptMap.entrySet()) {
			sum += entry.getValue();
		}
		
		return sum;
	}
	
	public int getNextUnattemptedQuestionNumber() {
		int number = 1;
		
		while (_resultMap.get(number) != Result.UNATTEMPTED) {
			number++;
		}
		
		return number;
	}
	
	public void debug() {
		for (Map.Entry<Integer, Result> entry: _resultMap.entrySet()) {
			System.out.println("Key: " + entry.getKey() + "\tValue: " + entry.getValue());
		}
	}
}
