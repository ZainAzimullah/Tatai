package tatai.view.controllers.gameControllers;


import javafx.fxml.FXML;
import tatai.Game;
import tatai.util.Level;
import tatai.view.controllers.SceneController;

/*
 * Controller for choosing the level the user wants to play
 */
public class ChooseLevelController extends SceneController {
	
	// Handle the button for choosing easy level
	@FXML
	private void chooseEasy() {
		Game.getInstance().createList(Level.EASY);
	}
	
	// Handle the button for choosing the hard level
	@FXML
	private void chooseHard() {
		Game.getInstance().createList(Level.HARD);
	}
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	@Override
	protected void returnToMainMenu() {
		Game.getInstance().returnToMainMenu();
	}

}
