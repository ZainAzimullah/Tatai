package tatai;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class MainMenuController {
	
	private Stage _stage;
	
	// Set the stage
	public void setStage(Stage stage) {
		_stage = stage;
	}

	// Create game instance and start game
	@FXML
	public void play() {
		Game game = Game.getInitialInstance(_stage);
		game.run();
	}
	
	// Quit the game
	@FXML
	public void quit() {
		_stage.close();
	}
}
