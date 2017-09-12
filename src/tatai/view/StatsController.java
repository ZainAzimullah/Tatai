package tatai.view;

import javafx.fxml.FXML;

public class StatsController extends SceneController {
	
	@FXML
	private void initialize() {
		
	}
	
	@Override
	protected void returnToMainMenu() {
		MainMenuLoader loader = new MainMenuLoader();
		loader.loadScene("MainMenu.fxml");
	}

}
