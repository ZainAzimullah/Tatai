package tatai.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Score {
	
	// Constants to represent indices of attempt types in array
	public static final int ATTEMPT = 0;
	public static final int CORRECT_ATTEMPT = 1;
	public static final int INCORRECT_ATTEMPT = 2;
	
	// Result enum represents possible result types for each question.
	public enum Result {
		CORRECT(1, 1, 0),
		INCORRECT(2, 1, 1),
		FAILED(2, 0, 2),
		UNATTEMPTED(0, 0, 0);
		
		// The number of attempts, correct attempts and incorrect attempts
		// will be stored in an array which will be mapped to each question number
		private Integer[] _attempts = new Integer[3];
		
		// Store the values in the array accordingly for whatever the result type
		// is.
		Result(int attempts, int correctAttempts, int incorrectAttempts) {
			_attempts[ATTEMPT] = attempts;
			_attempts[CORRECT_ATTEMPT] = correctAttempts;
			_attempts[INCORRECT_ATTEMPT] = incorrectAttempts;
		}
	}
	
	// Maps to store result type and each attempt type
	private Map<Integer, Result> _resultMap;
	private Map<Integer, Integer[]> _attemptMap;
	
	// construct a score object for a given number of questions
	public Score(int numOfQuestions) {
		_resultMap = new HashMap<>();
		_attemptMap = new HashMap<>();
		
		// Initialise maps as unattempted
		for (int i = 1; i <= 10; i++) {
			_resultMap.put(i, Result.UNATTEMPTED);
			_attemptMap.put(i, Result.UNATTEMPTED._attempts);
		}
	}
	
	// Update maps given a particular result for one question
	public void update(int questionNumber, Result result) {
		_resultMap.put(questionNumber, result);
		_attemptMap.put(questionNumber, result._attempts);
	}
	
	// Get the number of occurrences of a particular result
	public int getNumberOf(Result result) {
		return Collections.frequency(_resultMap.values(), result);
	}
	
	// Get the number of occurrences of a particular attempt type
	public int getNumberOf(int attemptType) {
		int sum = 0;
		
		for (Entry<Integer, Integer[]> entry: _attemptMap.entrySet()) {
			sum += entry.getValue()[attemptType];
		}
		
		return sum;
	}
	
	// Get the number of attempts for a given question number
	public int getNumberOfAttempts(int questionNumber) {
		return _attemptMap.get(questionNumber)[ATTEMPT];
	}
	
	// Get the total number of attempts
	public int getTotalNumberOfAttempts() {
		int sum = 0;
		
		for (Entry<Integer, Integer[]> entry: _attemptMap.entrySet()) {
			sum += entry.getValue()[ATTEMPT];
		}
		
		return sum;
	}
	
	// Get the next question the user has not attempted.
	public int getNextUnattemptedQuestionNumber() {
		int number = 1;
		
		while (_resultMap.get(number) != Result.UNATTEMPTED) {
			number++;
		}
		
		return number;
	}
	
	// Print out maps
	public void debug() {
		System.out.println("Results:");
		for (Map.Entry<Integer, Result> entry: _resultMap.entrySet()) {
			System.out.println("Key: " + entry.getKey() + "\tValue: " + entry.getValue());
		}
		
		System.out.println();
		System.out.println("Attempts:");
		for (Map.Entry<Integer, Integer[]> entry: _attemptMap.entrySet()) {
			System.out.println("Key: " + entry.getKey() + "\tValue: " 
					+ Arrays.toString(entry.getValue()));
		}
	}
}
