package tatai.view.controllers.mainMenuControllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import tatai.practiceScore.PracticeFinalScore;
import tatai.score.ScoreHistory;
import tatai.score.ScoreProperties;
import tatai.view.MainMenuLoader;

public class ScoresController extends MainMenuController {
	
	@FXML
	private TableView<ScoreProperties> _table;
	
	@FXML
	private TableColumn<ScoreProperties, String> _date;
	
	@FXML
	private TableColumn<ScoreProperties, String> _total;

	@FXML
	private TableColumn<ScoreProperties, String> _numMistakes;
	
	@FXML
	private TableColumn<ScoreProperties, String> _level;
	
	@FXML
	private void initialize() {
		_date.setCellValueFactory(data -> data.getValue().dateProperty());
		_total.setCellValueFactory(data -> data.getValue().totalProperty());
		_numMistakes.setCellValueFactory(data -> data.getValue().numMistakesProperty());
		_level.setCellValueFactory(data -> data.getValue().difficultyProperty());

		ScoreHistory history = new ScoreHistory();
		ObservableList<ScoreProperties> data = history.getObservableList();
		_table.setItems(data);
	}
	
	@FXML
	@Override
	protected void returnToMainMenu() {
		MainMenuLoader loader = new MainMenuLoader(_stage);
		loader.loadScene("MainMenu.fxml");
	}

}
