package tatai.view.controllers.gameControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import tatai.Game;
import tatai.view.controllers.SceneController;

public class FailedController extends SceneController {
	
	@FXML
	private Label _correctWord;
	
	@FXML
	private Label _incorrectWord;
	
	@FXML
	private Label _number;
	
	@FXML
	private void next() {
		// Show recording scene for the next question
		Game.getInstance().record();
	}
	
	@FXML
	private void initialize() {
		// Set labels
		_correctWord.setText(Game.getInstance().getNumber().toString());
		_incorrectWord.setText(Game.getInstance().getAttempt());
		_number.setText(Integer.toString(Game.getInstance().getNumber().getDigit()));
	}
	
	@FXML
	@Override
	protected void returnToMainMenu() {
		showAlertAndReturn();
	}
}
