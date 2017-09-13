package tatai.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import tatai.Game;

public class MainMenuController extends SceneController {
	
	protected Stage _stage;
	
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
	
	@FXML
	private void scores() {
		MainMenuLoader loader = new MainMenuLoader(_stage);
		loader.loadScene("Scores.fxml");
	}
	
	// Quit the game
	@FXML
	private void quit() {
		_stage.fireEvent(new WindowEvent(_stage, WindowEvent.WINDOW_CLOSE_REQUEST));
	}

	@Override
	protected void returnToMainMenu() {}
}
