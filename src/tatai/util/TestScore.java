package tatai.util;

import tatai.util.Score.Result;

public class TestScore {
	
	public static void main(String[] args) {
		
		Score score = new Score(10);
		
		System.out.println(score.getNextUnattemptedQuestionNumber());
		
		score.update(1, Result.CORRECT);
		score.update(2, Result.CORRECT);
		score.update(3, Result.INCORRECT_ONCE);
		score.update(4, Result.CORRECT);
		score.update(5, Result.FAILED);
		
		System.out.println(score.getNextUnattemptedQuestionNumber());
		System.out.println(score.getNumberOf(Result.CORRECT));
		System.out.println(score.getNumberOf(Result.INCORRECT_ONCE));
		System.out.println(score.getNumberOf(Result.FAILED));
		
		score.debug();
		
		FinalScore finalScore = new FinalScore(score, Level.EASY);
		
		System.out.println(finalScore.getNumberIncorrect().get());
		System.out.println(finalScore);
		
		Saver saver = new Saver(finalScore);
		saver.save("history.txt");
	}
	
}
