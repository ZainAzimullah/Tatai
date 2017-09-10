package tatai.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import tatai.Game;

public class EndOfLevelController extends SceneController {
	
	@FXML
	Button _next;
	
	@FXML
	Label _numCorrect;
	
	@FXML
	Label _numIncorrect;
	
	@FXML
	Label _totalNumOfAttempts;
	
	@FXML
	private void initialize() {
		
	}
	
	
	@FXML
	@Override
	protected void returnToMainMenu() {
		Game.getInstance().returnToMainMenu();
	}
}
