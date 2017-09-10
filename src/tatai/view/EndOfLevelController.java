package tatai.view;

import javafx.fxml.FXML;
import tatai.Game;

public class EndOfLevelController extends SceneController {
	
	@FXML
	@Override
	protected void returnToMainMenu() {
		Game.getInstance().returnToMainMenu();
	}
}
