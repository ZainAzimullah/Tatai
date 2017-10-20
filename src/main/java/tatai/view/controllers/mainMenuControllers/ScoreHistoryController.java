package tatai.view.controllers.mainMenuControllers;

import com.jfoenix.controls.JFXButton;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import tatai.score.Score;
import tatai.score.ScoreHistory;
import tatai.score.ScoreProperties;
import tatai.view.MainMenuLoader;
import tatai.view.SessionDetailsLoader;

import java.util.Collections;

public class ScoreHistoryController extends MainMenuController {
	
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
	private Label _highScore;

	@FXML
	private JFXButton _sessionDetailsButton;

	private Score _scoreSelected;
	
	@FXML
	private void initialize() {
		_sessionDetailsButton.setDisable(true);

		_date.setCellValueFactory(data -> data.getValue().dateProperty());
		_total.setCellValueFactory(data -> data.getValue().totalProperty());
		_numMistakes.setCellValueFactory(data -> data.getValue().numMistakesProperty());
		_level.setCellValueFactory(data -> data.getValue().difficultyProperty());

		ScoreHistory history = new ScoreHistory();
		ObservableList<ScoreProperties> data = history.getObservableList();
		Collections.reverse(data);
		_table.setItems(data);
		_highScore.setText(Integer.toString(history.getHighScore()));

		_table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			_scoreSelected = newValue.getScore();
			_sessionDetailsButton.setDisable(false);
		});
	}

	@FXML
	private void showDetails() {
		SessionDetailsLoader loader = new SessionDetailsLoader(_stage, _scoreSelected);
		loader.loadScene("SessionDetails.fxml");
	}
	
	@FXML
	@Override
	protected void returnToMainMenu() {
		MainMenuLoader loader = new MainMenuLoader(_stage);
		loader.loadScene("MainMenu.fxml");
	}

}
