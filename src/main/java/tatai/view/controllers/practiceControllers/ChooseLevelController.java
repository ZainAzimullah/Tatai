package tatai.view.controllers.practiceControllers;


import javafx.fxml.FXML;
import tatai.Practice;
import tatai.util.PracticeLevel;
import tatai.view.controllers.SceneController;

/*
 * Controller for choosing the level the user wants to play
 */
public class ChooseLevelController extends SceneController {
	
	// Handle the button for choosing easy level
	@FXML
	private void chooseEasy() {
		Practice.getInstance().createList(PracticeLevel.EASY);
	}
	
	// Handle the button for choosing the hard level
	@FXML
	private void chooseHard() {
		Practice.getInstance().createList(PracticeLevel.HARD);
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
