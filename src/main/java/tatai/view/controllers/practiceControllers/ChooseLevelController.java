package tatai.view.controllers.practiceControllers;


import javafx.fxml.FXML;
import tatai.Practice;
import tatai.util.Level;
import tatai.view.controllers.SceneController;

/*
 * Controller for choosing the level the user wants to play
 */
public class ChooseLevelController extends SceneController {
	
	// Handle the button for choosing easy level
	@FXML
	private void chooseEasy() {
		Practice.getInstance().createList(Level.EASY);
	}
	
	// Handle the button for choosing the hard level
	@FXML
	private void chooseHard() {
		Practice.getInstance().createList(Level.HARD);
	}
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	@Override
	protected void returnToMainMenu() {
		Practice.getInstance().returnToMainMenu();
	}

}
