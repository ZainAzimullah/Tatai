package tatai;

import javafx.stage.Stage;
import tatai.exceptions.OutOfItemsException;
import tatai.exceptions.TataiException;
import tatai.numberModel.MaoriNumber;
import tatai.numberModel.MaoriNumberModel;
import tatai.numberModel.MaoriNumberModelFactory;
import tatai.practiceScore.PracticeScore;
import tatai.practiceScore.PracticeScore.PracticeResult;
import tatai.util.PracticeLevel;
import tatai.util.Verifier;
import tatai.view.MainMenuLoader;
import tatai.view.SceneLoader;

/*
 * This is a singleton class which has ONE game.  There is also ONE stage
 * which any scene is to appear in.  Any game flow/logic occurs in this class.
 */
public class Practice {
	
	// The actual Practice instance
	private static Practice _practice;
	
	// Some game constants
	public static final int MAX_LIVES = 2;
	public static final int NUMBER_OF_QUESTIONS = 10;
	
	// The stage for the game scenes which can only be set once
	private final Stage _stage;
	
	// Reusable scene loader
	private SceneLoader _loader;
	
	// A record of the questions and user's guess
	private MaoriNumberModel _numbers;
	private MaoriNumber _currentNumber;
	private String _userAttempt;
	
	// A record of the level, amount of attempts left and current question number
	private PracticeLevel _level;
	private int _lives = MAX_LIVES;
	private int _questionNumber;
	
	// Current practiceScore
	private PracticeScore _score;
	
	// Set the stage of the game.
	private Practice(Stage stage) {
		_stage = stage;
	}
	
	// Use this method when first initialising the game, as the stage
	// needs to be set the first time.  If the stage has already been set
	// and this method is used, then the current Practice instance is returned.
	public static Practice getInitialInstance(Stage stage) {
		if (_practice == null) {
			_practice = new Practice(stage);
		}
		
		return _practice;
	}
	
	// Get the instance of Practice.  If Practice has not been initialised properly
	// using getInitialInstance(), then a TataiException is thrown.
	public static Practice getInstance() {
		if (_practice == null) {
			throw new TataiException("Practice not initialised");
		} else {
			return _practice;
		}
	}
	
	// Get the stage of the game
	public Stage getStage() {
		return _stage;
	}
	
	// Get the current number the user is being tested on
	public MaoriNumber getNumber() {
		return _currentNumber;
	}
	
	// Store the speech which the user said
	public void storeAttempt(String attempt) {
		_userAttempt = attempt;
	}
	
	// Get the speech which the user said
	public String getAttempt() {
		return _userAttempt;
	}
	
	// Get the question number which the user is currently on
	public int getCurrentQuestionNumber() {
		return _questionNumber;
	}
	
	// Get the level which the user is currently on
	public PracticeLevel getLevel() {
		return _level;
	}
	
	// Get the current practiceScore
	public PracticeScore getScore() {
		return _score;
	}
	
	// Start the game
	public void startGame() {
		_loader = new SceneLoader(_stage);
		_loader.loadScene("ChoosePracticeLevel.fxml");
	}
	
	// Create the number list which user will be tested on.
	// This method will be called once the user has clicked on a level.
	public void createList(PracticeLevel level) {
		_lives = MAX_LIVES;
		_score = new PracticeScore(NUMBER_OF_QUESTIONS);
		_level = level;
		_numbers = MaoriNumberModelFactory.getMaoriNumberModel(level);
		record();
	}
	
	// Returns to the main menu
	public void returnToMainMenu() {
		MainMenuLoader loader = new MainMenuLoader(_stage);
		loader.loadScene("MainMenu.fxml");
	}
	
	// Load the recording scene
	public void record() {
	
		// Advance to the next number in the numberModel, otherwise
		// if this is not possible, proceed to the end of the level
		try {
			_numbers.advance();
		} catch (OutOfItemsException e) {
			// Show EndOfLevel scene if out of numbers
			endOfLevel();
			return;
		}
		
		_questionNumber = _score.getNextUnattemptedQuestionNumber();
		_currentNumber = _numbers.getCurrentMaoriNumber();
		_loader.loadScene("PracticeRecord.fxml");
	}
	
	// Redo recording
	public void rerecord() {
		_currentNumber = _numbers.getCurrentMaoriNumber();;
		_loader.loadScene("PracticeRecord.fxml");
	}
	
	// Load a scene for the user to rerecord, playback, or submit
	public void finishedRecording() {
		_loader.loadScene("PracticeFinishedRecording.fxml");
	}
	
	public void checkAnswer() {
		Verifier verifier = new Verifier(_userAttempt,_currentNumber.toString());
		
		// Check if user said correct word on first attempt
		if ((verifier.isCorrect()) && (_lives == 2)) {
			// Refresh lives and show correct scene
			_lives = MAX_LIVES;
			_score.update(_questionNumber, PracticeResult.CORRECT);
			showCorrect();
		
		// Check if user said correct word on second attempt
		} else if (verifier.isCorrect()) {
			_lives = MAX_LIVES;
			_score.update(_questionNumber, PracticeScore.PracticeResult.INCORRECT_ONCE);
			showCorrect();
			
		// Otherwise, the user got the word wrong:
		} else if (_lives > 1) {
			// Deduct a life and show the incorrect scene
			_lives--;
			showIncorrect();
		} else if (_lives == 1) {
			// They have failed, so refresh the lives and show the Failed scene
			_score.update(_questionNumber, PracticeResult.FAILED);
			_lives = MAX_LIVES;
			showFailed();
		}
	}
	
	// Load the Correct scene
	private void showCorrect() {
		_loader.loadScene("PracticeCorrect.fxml");
	}
	
	// Load the Incorrect scene
	private void showIncorrect() {
		_loader.loadScene("PracticeIncorrect.fxml");
	}
	
	// Load the Failed scene
	private void showFailed() {
		_loader.loadScene("PracticeFailed.fxml");
	}
	
	// Load the End Of PracticeLevel scene
	public void endOfLevel() {
		_loader.loadScene("PracticeEndOfLevel.fxml");
	}
}
