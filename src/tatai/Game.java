package tatai;

import javafx.stage.Stage;
import tatai.exceptions.OutOfNumbersException;
import tatai.exceptions.TataiException;
import tatai.model.MaoriNumber;
import tatai.model.MaoriNumberModel;
import tatai.model.MaoriNumberModelFactory;
import tatai.score.FinalScore;
import tatai.score.FinalScoreSaver;
import tatai.score.Score;
import tatai.score.Score.Result;
import tatai.util.Level;
import tatai.view.MainMenuLoader;
import tatai.view.SceneLoader;

/*
 * This is a singleton class which has ONE game.  There is also ONE stage
 * which any scene is to appear in.  Any game flow/logic occurs in this class.
 */
public class Game {
	
	// The actual Game instance
	private static Game _game;
	
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
	private Level _level;
	private int _lives = MAX_LIVES;
	private int _questionNumber;
	
	// Current score
	private Score _score;
	
	// Set the stage of the game.
	private Game(Stage stage) {
		_stage = stage;
	}
	
	// Use this method when first initialising the game, as the stage
	// needs to be set the first time.  If the stage has already been set
	// and this method is used, then the current Game instance is returned.
	public static Game getInitialInstance(Stage stage) {
		if (_game == null) {
			_game = new Game(stage);
		}
		
		return _game;
	}
	
	// Get the instance of Game.  If Game has not been initialised properly
	// using getInitialInstance(), then a TataiException is thrown.
	public static Game getInstance() {
		if (_game == null) {
			throw new TataiException("Game not initialised");
		} else {
			return _game;
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
	public Level getLevel() {
		return _level;
	}
	
	// Get the current score
	public Score getScore() {
		return _score;
	}
	
	// Start the game
	public void startGame() {
		_loader = new SceneLoader();
		_loader.loadScene("ChooseLevel.fxml");
	}
	
	// Create the number list which user will be tested on.
	// This method will be called once the user has clicked on a level.
	public void createList(Level level) {
		_lives = MAX_LIVES;
		_score = new Score(NUMBER_OF_QUESTIONS);
		_level = level;
		_numbers = MaoriNumberModelFactory.getMaoriNumberModel(level);
		record();
	}
	
	// Returns to the main menu
	public void returnToMainMenu() {
		MainMenuLoader loader = new MainMenuLoader();
		loader.loadScene("MainMenu.fxml");
	}
	
	// Load the recording scene
	public void record() {
	
		// Advance to the next number in the model, otherwise
		// if this is not possible, proceed to the end of the level
		try {
			_numbers.advance();
		} catch (OutOfNumbersException e) {
			// Show EndOfLevel scene if out of numbers
			endOfLevel();
			return;
		}
		
		_questionNumber = _score.getNextUnattemptedQuestionNumber();
		_currentNumber = _numbers.getCurrentMaoriNumber();
		_loader.loadScene("Record.fxml");
	}
	
	// Redo recording
	public void rerecord() {
		_currentNumber = _numbers.getCurrentMaoriNumber();;
		_loader.loadScene("Record.fxml");
	}
	
	// Load a scene for the user to rerecord, playback, or submit
	public void finishedRecording() {
		_loader.loadScene("FinishedRecording.fxml");
	}
	
	public void checkAnswer() {
		
		// Check if user said correct word on first attempt
		if ((_userAttempt.equals(_currentNumber.toString())) && (_lives == 2)) {
			// Refresh lives and show correct scene
			_lives = MAX_LIVES;
			_score.update(_questionNumber, Result.CORRECT);
			showCorrect();
		
		// Check if user said correct word on second attempt
		} else if (( _userAttempt.equals(_currentNumber.toString()))) {
			_lives = MAX_LIVES;
			_score.update(_questionNumber, Result.INCORRECT_ONCE);
			showCorrect();
			
		// Otherwise, the user got the word wrong:
		} else if (_lives > 1) {
			// Deduct a life and show the incorrect scene
			_lives--;
			showIncorrect();
		} else if (_lives == 1) {
			// They have failed, so refresh the lives and show the Failed scene
			_score.update(_questionNumber, Result.FAILED);
			_lives = MAX_LIVES;
			showFailed();
		}
	}
	
	// Load the Correct scene
	private void showCorrect() {
		_loader.loadScene("Correct.fxml");
	}
	
	// Load the Incorrect scene
	private void showIncorrect() {
		_loader.loadScene("Incorrect.fxml");
	}
	
	// Load the Failed scene
	private void showFailed() {
		_loader.loadScene("Failed.fxml");
	}
	
	// Load the End Of Level scene
	public void endOfLevel() {
		// Save final score
		new FinalScoreSaver(new FinalScore(_score, _level)).save("history.txt");
		_loader.loadScene("EndOfLevel.fxml");
	}
}
