package tatai.view;


import javafx.fxml.FXML;
import tatai.Game;
import tatai.util.Level;

/*
 * Controller for choosing the level the user wants to play
 */
public class ChooseLevelController extends SceneController {
	
	
	
	@FXML
	private void chooseEasy() {
		Game.getInstance().createList(Level.EASY);
	}
	
	@FXML
	private void chooseHard() {
		Game.getInstance().createList(Level.HARD);
	}
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void returnToMainMenu() {
		Game.getInstance().returnToMainMenu();
	}
}
