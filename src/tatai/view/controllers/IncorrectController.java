package tatai.view.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import tatai.Game;

public class IncorrectController extends SceneController {
	
	@FXML
	private Label _number;
	
	@FXML
	private Label _maoriWord;
	
	@FXML
	private void initialize() {
		_number.setText(Integer.toString(Game.getInstance().getNumber().getDigit()));
		_maoriWord.setText(Game.getInstance().getAttempt());
	}
	
	@FXML
	private void tryAgain() {
		Game.getInstance().rerecord();
	}

	@FXML
	@Override
	protected void returnToMainMenu() {
		showAlertAndReturn();
	}

}
