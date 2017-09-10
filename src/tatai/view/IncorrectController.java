package tatai.view;

import javafx.fxml.FXML;

public class IncorrectController extends SceneController {
	
	@FXML
	@Override
	protected void returnToMainMenu() {
		showAlertAndReturn();
	}

}
