package tatai.util;

public class TestScore {
	
	public static void main(String[] args) {
		Score score = new Score(10);
		
		score.updateIncorrectTally(1);
		score.updateIncorrectTally(1);
		score.updateIncorrectTally(5);
		score.updateIncorrectTally(7);
		
		score.debug();
		
		System.out.println(score.getNumberOfCorrect());
		System.out.println(score.getNumberOfCorrectOnFirstTry());
		System.out.println(score.getNumberOfIncorrect());
		System.out.println(score.getNumberOfIncorrectOnFirstTry());
	}
	
}
