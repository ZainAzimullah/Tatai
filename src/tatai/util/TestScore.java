package tatai.util;

import tatai.util.Score.Result;

public class TestScore {
	
	public static void main(String[] args) {
		Score score = new Score(10);
		
		System.out.println(score.getNextUnattemptedQuestionNumber());
		
		score.update(1, Result.CORRECT);
		score.update(2, Result.CORRECT);
		score.update(3, Result.INCORRECT);
		score.update(4, Result.CORRECT);
		score.update(5, Result.FAILED);
		
		System.out.println(score.getNextUnattemptedQuestionNumber());
		System.out.println(score.getNumberOf(Result.CORRECT));
		System.out.println(score.getNumberOf(Result.INCORRECT));
		System.out.println(score.getNumberOf(Result.FAILED));
		
		score.debug();

	}
	
}
