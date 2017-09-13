package tatai.view;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import tatai.util.FinalScore;
import tatai.util.FinalScoreReader;

public class ScoresController extends SceneController {
	
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
		// Initialise table columns
		_numCorrect.setCellValueFactory(data -> data.getValue().getNumberCorrect());
		_numIncorrect.setCellValueFactory(data -> data.getValue().getNumberIncorrect());
		_numAttempts.setCellValueFactory(data -> data.getValue().getNumberOfAttempts());
		_numMistakes.setCellValueFactory(data -> data.getValue().getNumberOfMistakes());
		_level.setCellValueFactory(data -> data.getValue().getLevel());
		
		// Initialise table
		_table.setItems(new FinalScoreReader("history.txt").read());
	}
	
	@FXML
	@Override
	protected void returnToMainMenu() {
		MainMenuLoader loader = new MainMenuLoader();
		loader.loadScene("MainMenu.fxml");
	}

}
