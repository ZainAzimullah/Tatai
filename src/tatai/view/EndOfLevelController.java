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
	
	private boolean _mustRetry = true;
	
	@FXML
	Button _next;
	
	@FXML
	Label _numAchieved;
	
	@FXML
	Label _numFailed;
	
	@FXML
	Label _totalNumOfAttempts;
	
	@FXML
	Label _level;
	
	@FXML
	private void initialize() {
		_level.setText(Game.getInstance().getLevel().toString());
		
		Score score = Game.getInstance().getScore();
		int numAchieved = score.getNumberOf(Result.CORRECT) + score.getNumberOf(Result.INCORRECT);
		int numFailed = score.getNumberOf(Result.FAILED);
		int totalNumOfAttempts = score.getTotalNumberOfAttempts();
		
		_numAchieved.setText(Integer.toString(numAchieved));
		_numFailed.setText(Integer.toString(numFailed));
		_totalNumOfAttempts.setText(Integer.toString(totalNumOfAttempts));
		
		if ((numAchieved >= THRESHHOLD) 
				&& (Game.getInstance().getLevel() == Level.EASY)) {
			_next.setText("Next Level");
			_mustRetry = false;
		} else {
			_next.setText("Retry Level");
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
