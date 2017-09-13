package tatai.view;

import javafx.fxml.FXML;

public class AboutController extends MainMenuController {
	
	@FXML
	@Override
	protected void returnToMainMenu() {
		MainMenuLoader loader = new MainMenuLoader(_stage);
		loader.loadScene("MainMenu.fxml");
	}
}
