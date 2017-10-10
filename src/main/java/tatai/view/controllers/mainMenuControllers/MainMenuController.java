package tatai.view.controllers.mainMenuControllers;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import tatai.Game;
import tatai.view.MainMenuLoader;
import tatai.view.controllers.SceneController;

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
	
	@FXML
	private void howToPlay() {
		MainMenuLoader loader = new MainMenuLoader(_stage);
		loader.loadScene("HowToPlay.fxml");
	}
	
	@FXML
	private void about() {
		MainMenuLoader loader = new MainMenuLoader(_stage);
		loader.loadScene("About.fxml");
	}
	
	// Quit the game
	@FXML
	private void quit() {
		_stage.fireEvent(new WindowEvent(_stage, WindowEvent.WINDOW_CLOSE_REQUEST));
	}

	@Override
	protected void returnToMainMenu() {}
}