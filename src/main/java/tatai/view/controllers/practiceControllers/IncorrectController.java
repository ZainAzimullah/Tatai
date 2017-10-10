package tatai.view.controllers.practiceControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import tatai.Practice;
import tatai.view.controllers.SceneController;

public class IncorrectController extends SceneController {
	
	@FXML
	private Label _number;
	
	@FXML
	private Label _maoriWord;
	
	@FXML
	private void initialize() {
		// Set labels
		_number.setText(Integer.toString(Practice.getInstance().getNumber().getDigit()));
		_maoriWord.setText(Practice.getInstance().getAttempt());
	}
	
	@FXML
	private void tryAgain() {
		Practice.getInstance().rerecord();
	}

	@FXML
	@Override
	protected void returnToMainMenu() {
		showAlertAndReturn();
	}

}
