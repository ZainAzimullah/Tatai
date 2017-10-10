package tatai.view.controllers.practiceControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import tatai.Practice;
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
		Practice.getInstance().record();
	}
	
	@FXML
	private void initialize() {
		// Set labels
		_correctWord.setText(Practice.getInstance().getNumber().toString());
		_incorrectWord.setText(Practice.getInstance().getAttempt());
		_number.setText(Integer.toString(Practice.getInstance().getNumber().getDigit()));
	}
	
	@FXML
	@Override
	protected void returnToMainMenu() {
		showAlertAndReturn();
	}
}
