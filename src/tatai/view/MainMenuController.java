package tatai.view;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import tatai.Game;

public class MainMenuController extends SceneController {
	
	private Stage _stage;
	
	// Set the stage
	public void setStage(Stage stage) {
		_stage = stage;
	}

	// Create game instance and start game
	@FXML
	private void play() {
		Game game = Game.getInitialInstance(_stage);
		game.startGame();
	}
	
	// Quit the game
	@FXML
	private void quit() {
		_stage.fireEvent(new WindowEvent(_stage, WindowEvent.WINDOW_CLOSE_REQUEST));
	}

	@Override
	protected void returnToMainMenu() {}
}
