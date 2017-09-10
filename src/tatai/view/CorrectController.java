package tatai.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import tatai.Game;

public class CorrectController extends SceneController {
	
	
	@FXML
	private Label _number;
	
	@FXML
	private Label _maoriWord;
	
	@FXML
	private void initialize() {
		_number.setText(Integer.toString(Game.getInstance().getNumber().getDigit()));
		_number.setText(Game.getInstance().getNumber().toString());
	}
	
	@FXML
	private void next() {
		Game.getInstance().record();
	}
	
	@FXML
	@Override
	protected void returnToMainMenu() {
		// TODO Auto-generated method stub
		
	}
}
