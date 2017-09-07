package tatai;

import javafx.stage.Stage;

public class Game {
	private static Game _game;
	private final Stage _stage;
	
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
}
