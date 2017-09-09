package tatai.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class RecordController extends SceneController {
	
	@FXML
	private Label _label;
	
	@FXML
	private Button _button;
	
	@FXML
	private void record() {
		_button.setText("RECORDING");
		_button.setDisable(true);
		_label.setText("Recording");
	}
}
