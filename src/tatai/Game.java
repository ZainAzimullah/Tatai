package tatai;

import javafx.stage.Stage;
import tatai.exceptions.OutOfNumbersException;
import tatai.exceptions.TataiException;
import tatai.model.MaoriNumber;
import tatai.model.MaoriNumberModel;
import tatai.model.MaoriNumberModelFactory;
import tatai.view.SceneLoader;

/*
 * This is a singleton class which has ONE game.  There is also ONE stage
 * which any scene is to appear in.  Any game flow/logic occurs in this class.
 */
public class Game {
	
	public static final int MAX_LIVES = 2;
	
	private static Game _game;
	private final Stage _stage;
	private SceneLoader _loader;
	
	private MaoriNumberModel _numbers;
	private MaoriNumber _currentNumber;
	private String _userAttempt;
	
	private int _lives = MAX_LIVES;
	
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
	
	public void storeAttempt(String attempt) {
		_userAttempt = attempt;
	}
	
	// Start the game
	public void startGame() {
		_loader = new SceneLoader();
		_loader.loadScene("ChooseLevel.fxml");
	}
	
	// Create the number list which user will be tested on.
	// This method will be called once the user has clicked on a level.
	public void createList(Level level) {
		_numbers = MaoriNumberModelFactory.getMaoriNumberModel(level);
		_currentNumber = _numbers.getCurrentMaoriNumber();
		record();
	}
	
	// Returns to the main menu
	public void returnToMainMenu() {
		_loader.loadScene("MainMenu.fxml");
	}
	
	// Load the recording scene
	public void record() {
		_loader.loadScene("Record.fxml");
	}
	
	// Load a scene for the user to rerecord, playback, or submit
	public void finishedRecording() {
		_loader.loadScene("FinishedRecording.fxml");
	}
	
	public void checkAnswer() {
		
		// Check if user said correct word
		if (_userAttempt.equals(_currentNumber.toString())) {
			
			// Show the Correct scene and refresh lives
			showCorrect();
			_lives = MAX_LIVES;
			
			// Advance to the next number in the model, otherwise
			// if this is not possible, proceed to the end of the level
			try {
				_numbers.advance();
				_currentNumber = _numbers.getCurrentMaoriNumber();
			} catch (OutOfNumbersException e) {
				endOfLevel();
			}
			
		// Otherwise, the user got the word wrong:
		} else if (_lives > 1) {
			// Deduct a life and show the incorrect scene
			_lives--;
			showIncorrect();
		} else if (_lives == 1) {
			// They have failed, so refresh the lives and show the Failed scene
			_lives = MAX_LIVES;
			showFailed();
		}
	}
	
	private void showCorrect() {
		System.out.println("Load Correct.fxml");
	}
	
	private void showIncorrect() {
		System.out.println("Load Incorrect.fxml");
	}
	
	private void showFailed() {
		System.out.println("Load Failed.fxml");
	}
	
	public void endOfLevel() {
		System.out.println("Load EndOfLevel.fxml");
	}
}
