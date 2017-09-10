package tatai.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import tatai.Game;
import tatai.util.Level;
import tatai.util.Score;
import tatai.util.Score.Result;

public class EndOfLevelController extends SceneController {
	
	public static final int THRESHHOLD = 8;
	
	private boolean _mustRetry = false;
	
	@FXML
	Button _next;
	
	@FXML
	Label _numAchieved;
	
	@FXML
	Label _numFailed;
	
	@FXML
	Label _totalNumOfAttempts;
	
	@FXML
	private void initialize() {
		Score score = Game.getInstance().getScore();
		int numAchieved = score.getNumberOf(Result.CORRECT) + score.getNumberOf(Result.INCORRECT);
		int numFailed = score.getNumberOf(Result.FAILED);
		int totalNumOfAttempts = score.getTotalNumberOfAttempts();
		
		_numAchieved.setText(Integer.toString(numAchieved));
		_numFailed.setText(Integer.toString(numFailed));
		_totalNumOfAttempts.setText(Integer.toString(totalNumOfAttempts));
		
		if (numAchieved >= THRESHHOLD) {
			_next.setText("Next Level");
			_mustRetry = false;
		} else {
			_next.setText("Retry Level");
			_mustRetry = true;
		}
	}
	
	@FXML
	private void next() {
		if (_mustRetry) {
			Game.getInstance().createList(Level.HARD);
		} else {
			Game.getInstance().createList(Level.EASY);
		}
	}
	
	
	@FXML
	@Override
	protected void returnToMainMenu() {
		Game.getInstance().returnToMainMenu();
	}
}
