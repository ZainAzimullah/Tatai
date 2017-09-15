package tatai.view.controllers.gameControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import tatai.Game;
import tatai.view.controllers.SceneController;

public class CorrectController extends SceneController {
	
	// The number they got correct
	@FXML
	private Label _number;
	
	// The Maori number
	@FXML
	private Label _maoriWord;
	
	// Set the labels
	@FXML
	private void initialize() {
		_number.setText(Integer.toString(Game.getInstance().getNumber().getDigit()));
		_maoriWord.setText(Game.getInstance().getNumber().toString());
	}
	
	// Go to the next number
	@FXML
	private void next() {
		Game.getInstance().record();
	}
	
	@FXML
	@Override
	protected void returnToMainMenu() {
		showAlertAndReturn();
	}
}
