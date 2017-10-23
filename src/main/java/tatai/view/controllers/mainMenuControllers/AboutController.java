package tatai.view.controllers.mainMenuControllers;

import javafx.fxml.FXML;
import tatai.view.MainMenuLoader;

/**
 * Controller for the About scene (only needs to handle home button)
 */
public class AboutController extends MainMenuController {

	// Override to avoid NullPointerException
	@FXML
	private void initialize() {}
	
	@FXML
	@Override
	protected void returnToMainMenu() {
		MainMenuLoader loader = new MainMenuLoader(_stage);
		loader.loadScene("MainMenu.fxml");
	}
}
