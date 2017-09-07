package tatai;

import javafx.stage.Stage;
import tatai.view.SceneLoader;

public class Game {
	private static Game _game;
	private final Stage _stage;
	private SceneLoader _loader;
	
	private Game(Stage stage) {
		_stage = stage;
	}
	
	public static Game getInstance(Stage stage) {
		if (_game == null) {
			_game = new Game(stage);
		}
		
		return _game;
	}
	
	public static Game getInstance() {
		if (_game == null) {
			throw new TataiException("Game not initialised");
		} else {
			return _game;
		}
	}
	
	public Stage getStage() {
		return _stage;
	}
	
	public void run() {
		_loader = new SceneLoader();
		_loader.loadScene("ChooseLevel.fxml");
	}
}
