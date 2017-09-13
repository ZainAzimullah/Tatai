package tatai.view;

import javafx.fxml.FXML;

public class HowToPlayController extends MainMenuController {

	@FXML
	@Override
	protected void returnToMainMenu() {
		MainMenuLoader loader = new MainMenuLoader(_stage);
		loader.loadScene("MainMenu.fxml");
	}
}
