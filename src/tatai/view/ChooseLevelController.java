package tatai.view;


import javafx.fxml.FXML;
import javafx.stage.Stage;
import tatai.Game;
import tatai.Level;

/*
 * Controller for choosing the level the user wants to play
 */
public class ChooseLevelController extends SceneController {
	
	
	
	@FXML
	private void chooseEasy() {
		//TODO: find a way to create an easy model
		Game.getInstance().createList(Level.EASY);
		//System.out.println("Easy button working");
	}
	
	@FXML
	private void chooseHard() {
		//TODO: find a way to create a hard level model
		Game.getInstance().createList(Level.HARD);
		//System.out.println("Hard button working");
	}
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void returnToMainMenu() {
		//TODO: implement way to get back to main menu
		Stage stage = Game.getInstance().getStage();
	}
}
