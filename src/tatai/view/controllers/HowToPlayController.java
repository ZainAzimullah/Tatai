package tatai.view.controllers;

import javafx.fxml.FXML;
import tatai.view.MainMenuLoader;

public class HowToPlayController extends MainMenuController {

	@FXML
	@Override
	protected void returnToMainMenu() {
		MainMenuLoader loader = new MainMenuLoader(_stage);
		loader.loadScene("MainMenu.fxml");
	}
}
