package tatai.view;

import javafx.fxml.FXML;

public class FailedController extends SceneController {
	
	@FXML
	@Override
	protected void returnToMainMenu() {
		showAlertAndReturn();
	}
}
