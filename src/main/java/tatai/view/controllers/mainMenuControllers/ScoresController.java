package tatai.view.controllers.mainMenuControllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import tatai.score.FinalPracticeScore;
import tatai.view.MainMenuLoader;

public class ScoresController extends MainMenuController {
	
	@FXML
	private TableView<FinalPracticeScore> _table;
	
	@FXML
	private TableColumn<FinalPracticeScore, String> _numCorrect;
	
	@FXML
	private TableColumn<FinalPracticeScore, String> _numIncorrect;
	
	@FXML
	private TableColumn<FinalPracticeScore, String> _numAttempts;
	
	@FXML
	private TableColumn<FinalPracticeScore, String> _numMistakes;
	
	@FXML
	private TableColumn<FinalPracticeScore, String> _level;
	
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
