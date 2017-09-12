package tatai.view;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import tatai.util.FinalScore;
import tatai.util.Reader;

public class StatsController extends SceneController {
	
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
		_numCorrect.setCellValueFactory(data -> data.getValue().getNumberCorrect());
		_numIncorrect.setCellValueFactory(data -> data.getValue().getNumberIncorrect());
		_numAttempts.setCellValueFactory(data -> data.getValue().getNumberOfAttempts());
		_numMistakes.setCellValueFactory(data -> data.getValue().getNumberOfMistakes());
		_level.setCellValueFactory(data -> data.getValue().getLevel());
		
		_table.setItems(new Reader("history.txt").read());
	}
	
	@Override
	protected void returnToMainMenu() {
		MainMenuLoader loader = new MainMenuLoader();
		loader.loadScene("MainMenu.fxml");
	}

}
