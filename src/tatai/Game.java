package tatai;

import javafx.stage.Stage;
import tatai.view.SceneLoader;

/*
 * This is a singleton class which has ONE game.  There is also ONE stage
 * which any scene is to appear in.  Any game flow/logic occurs in this class.
 */
public class Game {
	private static Game _game;
	private final Stage _stage;
	private SceneLoader _loader;
	
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
	
	// Start the game
	public void startGame() {
		_loader = new SceneLoader();
		_loader.loadScene("ChooseLevel.fxml");
	}
}
