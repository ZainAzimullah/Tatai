package tatai.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import tatai.Game;

public class FailedController extends SceneController {
	
	private Label _incorrectWord;
	private Label _correctWord;
	private Label _number;
	
	@FXML
	private void next() {
		Game.getInstance().record();
	}
	
	@FXML
	private void initialize() {
		_incorrectWord.setText(Game.getInstance().getAttempt());
		_correctWord.setText(Game.getInstance().getNumber().toString());
		_number.setText(Integer.toString(Game.getInstance().getNumber().getDigit()));
	}
	
	@FXML
	@Override
	protected void returnToMainMenu() {
		showAlertAndReturn();
	}
}
