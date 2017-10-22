package tatai.view.controllers;

import java.util.Optional;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import org.controlsfx.control.PopOver;
import tatai.Game;
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
		alert.setTitle("Notice");
		alert.setHeaderText("Please Confirm");
		alert.setContentText("Are you sure? Progress will be lost.");

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
	protected void showAlertAndReturnFromGame() {
		int reply = showAlert();

		if (reply == NO) {
			return;
		}

		Game.getInstance().returnToMainMenu();
	}
	
	// Show a confirmation dialog but do nothing if user clicks "No"
	protected void showAlertAndReturnFromPractice() {
		int reply = showAlert();
		
		if (reply == NO) {
			return;
		}
		
		Practice.getInstance().returnToMainMenu();
	}

	protected void showSavedMessage(String whatWasSaved) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setContentText(whatWasSaved + " saved");
		alert.showAndWait();
	}

	protected void setPopOver(Node node, String message) {
		PopOver popOver = new PopOver();
		Label label = new Label(message);
		popOver.setArrowLocation(PopOver.ArrowLocation.LEFT_CENTER);
		popOver.setContentNode(label);

		node.setOnMouseEntered(event -> popOver.show(node));
		node.setOnMouseExited(event -> popOver.hide());
	}

	protected void disablePopOver(Node node) {
		node.setOnMouseEntered(event -> {});
	}
}
