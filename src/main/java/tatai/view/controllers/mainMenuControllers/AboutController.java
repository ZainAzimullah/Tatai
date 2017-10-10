package tatai.view.controllers.mainMenuControllers;

import javafx.fxml.FXML;
import tatai.view.MainMenuLoader;

public class AboutController extends MainMenuController {
	
	@FXML
	@Override
	protected void returnToMainMenu() {
		MainMenuLoader loader = new MainMenuLoader(_stage);
		loader.loadScene("MainMenu.fxml");
	}
}
