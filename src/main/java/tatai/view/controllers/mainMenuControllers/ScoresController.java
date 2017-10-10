package tatai.view.controllers.mainMenuControllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import tatai.score.PracticeFinalScore;
import tatai.view.MainMenuLoader;

public class ScoresController extends MainMenuController {
	
	@FXML
	private TableView<PracticeFinalScore> _table;
	
	@FXML
	private TableColumn<PracticeFinalScore, String> _numCorrect;
	
	@FXML
	private TableColumn<PracticeFinalScore, String> _numIncorrect;
	
	@FXML
	private TableColumn<PracticeFinalScore, String> _numAttempts;
	
	@FXML
	private TableColumn<PracticeFinalScore, String> _numMistakes;
	
	@FXML
	private TableColumn<PracticeFinalScore, String> _level;
	
	@FXML
	private void initialize() {

	}
	
	@FXML
	@Override
	protected void returnToMainMenu() {
		MainMenuLoader loader = new MainMenuLoader(_stage);
		loader.loadScene("MainMenu.fxml");
	}

}
