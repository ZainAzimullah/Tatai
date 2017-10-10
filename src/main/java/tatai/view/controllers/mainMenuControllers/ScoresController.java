package tatai.view.controllers.mainMenuControllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import tatai.score.FinalScore;
import tatai.view.MainMenuLoader;

public class ScoresController extends MainMenuController {
	
	@FXML
	private TableView<FinalScore> _table;
	
	@FXML
	private TableColumn<FinalScore, String> _numCorrect;
	
	@FXML
	private TableColumn<FinalScore, String> _numIncorrect;
	
	@FXML
	private TableColumn<FinalScore, String> _numAttempts;
	
	@FXML
	private TableColumn<FinalScore, String> _numMistakes;
	
	@FXML
	private TableColumn<FinalScore, String> _level;
	
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
