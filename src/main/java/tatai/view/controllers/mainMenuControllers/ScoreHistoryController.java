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

/**
 * This is the controller for the score history scene
 */
public class ScoreHistoryController extends MainMenuController {

	// This table will list the past attempts of levels
	@FXML
	private TableView<ScoreProperties> _table;
	
	@FXML
	private TableColumn<ScoreProperties, String> _date; // date attempted
	
	@FXML
	private TableColumn<ScoreProperties, String> _total; // user score

	@FXML
	private TableColumn<ScoreProperties, String> _numMistakes; // mistakes
	
	@FXML
	private TableColumn<ScoreProperties, String> _level; // difficulty (easy/medium etc)

	@FXML
	private Label _highScore;

	@FXML
	private JFXButton _sessionDetailsButton; // button which opens the details for the selected level attempt

	private Score _scoreSelected; // the object representing the selected row in the table
	
	@FXML
	private void initialize() {
		// Disable this button because nothing is selected yet
		_sessionDetailsButton.setDisable(true);

		// Setup table
		_date.setCellValueFactory(data -> data.getValue().dateProperty());
		_total.setCellValueFactory(data -> data.getValue().totalProperty());
		_numMistakes.setCellValueFactory(data -> data.getValue().numMistakesProperty());
		_level.setCellValueFactory(data -> data.getValue().difficultyProperty());

		// Get saved score history
		ScoreHistory history = new ScoreHistory();
		ObservableList<ScoreProperties> data = history.getObservableList();

		// Put into order of most recent attempts
		Collections.reverse(data);
		_table.setItems(data);
		_highScore.setText(Integer.toString(history.getHighScore()));

		// Enable button when user selects something
		_table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			_scoreSelected = newValue.getScore();
			_sessionDetailsButton.setDisable(false);
		});
	}

	// Open up a new scene which shows which questions they got right/wrong for that level
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
