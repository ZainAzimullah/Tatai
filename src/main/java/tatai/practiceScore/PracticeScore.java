package tatai.practiceScore;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PracticeScore {
	
	// PracticeResult enum represents possible result types for each question, as
	// well as the number of attempts or mistakes that would be associated
	// with that result type.
	public enum PracticeResult {
		CORRECT(1, 0),
		INCORRECT_ONCE(2, 1),
		FAILED(2, 2),
		UNATTEMPTED(0, 0);
		
		private int _attempts;
		private int _mistakes;
		
		PracticeResult(int attempts, int mistakes) {
			_attempts = attempts;
			_mistakes = mistakes;
		}
	}
	
	// Maps for storing practiceScore information for each question
	private Map<Integer, PracticeResult> _resultMap;
	private Map<Integer, Integer> _attemptsMap;
	private Map<Integer, Integer> _mistakesMap;
	
	// construct a practiceScore object for a given number of questions
	public PracticeScore(int numOfQuestions) {
		_resultMap = new HashMap<>();
		_attemptsMap = new HashMap<>();
		_mistakesMap = new HashMap<>();
		
		// Initialise maps as unattempted
		for (int i = 1; i <= numOfQuestions; i++) {
			update(i, PracticeResult.UNATTEMPTED);
		}
	}
	
	// Update maps given a particular result for one question
	public void update(int questionNumber, PracticeResult result) {
		_resultMap.put(questionNumber, result);
		_attemptsMap.put(questionNumber, result._attempts);
		_mistakesMap.put(questionNumber, result._mistakes);
	}
	
	// Get the number of occurrences of a particular result
	public int getNumberOf(PracticeResult result) {
		return Collections.frequency(_resultMap.values(), result);
	}
	
	// Get number of attempts
	public int getNumberOfAttempts() {
		int sum = 0;
		
		for (Integer value: _attemptsMap.values()) {
			sum += value;
		}
		
		return sum;
	}
	
	// Get number of mistakes
	public int getNumberOfMistakes() {
		int sum = 0;
		
		for (Integer value: _mistakesMap.values()) {
			sum += value;
		}
		
		return sum;
	}
	
	// Get the next question the user has not attempted.
	public int getNextUnattemptedQuestionNumber() {
		int number = 1;
		
		while (_resultMap.get(number) != PracticeResult.UNATTEMPTED) {
			number++;
		}
		
		return number;
	}
	
	// Print out maps
	public void debug() {
		System.out.println("Results:");
		for (Map.Entry<Integer, PracticeResult> entry: _resultMap.entrySet()) {
			System.out.println("Key: " + entry.getKey() + "\tValue: " + entry.getValue());
		}
		
	}
}
