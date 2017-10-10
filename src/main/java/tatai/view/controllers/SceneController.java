package tatai.view.controllers;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import tatai.Practice;

/*
 * This is the parent class of all controllers.
 */
public abstract class SceneController {
	
	// Global yes/no values
	public static final int YES = 1;
	public static final int NO = 0;
	
	// Every scene controller must implement some way
	// to get back to the main meu
	protected abstract void returnToMainMenu();

	// Show a confirmation dialog
	protected int showAlert() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Return to Main Menu");
		alert.setHeaderText("Please Confirm");
		alert.setContentText("Are you sure?");

		ButtonType yes = new ButtonType("Yes");
		ButtonType no = new ButtonType("No");
		
		alert.getButtonTypes().setAll(yes, no);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == yes){
		    return 1;
		} else {
			return 0;
		}
	}
	
	// Show a confirmation dialog but do nothing if user clicks "No"
	protected void showAlertAndReturn() {
		int reply = showAlert();
		
		if (reply == NO) {
			return;
		}
		
		Practice.getInstance().returnToMainMenu();
	}
}
