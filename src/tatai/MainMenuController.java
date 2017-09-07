package tatai;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class MainMenuController {
	
	private Stage _stage;
	
	@FXML
	public void play() {
		Game game = Game.getInitialInstance(_stage);
		game.run();
	}
	
	public void setStage(Stage stage) {
		_stage = stage;
	}
}
