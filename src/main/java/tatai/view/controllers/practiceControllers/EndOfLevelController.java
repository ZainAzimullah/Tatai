package tatai.view.controllers.practiceControllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import tatai.Practice;
import tatai.practiceScore.PracticeScore;
import tatai.practiceScore.PracticeScore.PracticeResult;
import tatai.util.PracticeLevel;
import tatai.view.controllers.SceneController;

public class EndOfLevelController extends SceneController {
	
	// Minimum amount of questions they must get
	// correct before proceeding to next level
	public static final int THRESHHOLD = 8;
	
	// Can they go to the next level?
	private boolean _mustRetry = true;
	
	@FXML
	JFXButton _next;
	
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
		// Set name of level
		_level.setText(Practice.getInstance().getLevel().toString());
		
		// Get the number of achieved, failed, and attempted questions
		PracticeScore score = Practice.getInstance().getScore();
		int numAchieved = score.getNumberOf(PracticeScore.PracticeResult.CORRECT) + score.getNumberOf(PracticeResult.INCORRECT_ONCE);
		int numFailed = score.getNumberOf(PracticeScore.PracticeResult.FAILED);
		int totalNumOfAttempts = score.getNumberOfAttempts();
		
		// Set labels accordingly
		_numAchieved.setText(Integer.toString(numAchieved));
		_numFailed.setText(Integer.toString(numFailed));
		_totalNumOfAttempts.setText(Integer.toString(totalNumOfAttempts));
		
		// Determine whether they are on the first level and have gotten over
		// 8 to continue onto the second level.
		if ((numAchieved >= THRESHHOLD) 
				&& (Practice.getInstance().getLevel() == PracticeLevel.EASY)) {
			_next.setText("Next PracticeLevel");
			_mustRetry = false;
		} else {
			_next.setText("Retry PracticeLevel");
		}
	}
	
	@FXML
	private void next() {
		
		// Redo the same level if they must retry, otherwise do the hard level.
		if (_mustRetry) {
			Practice.getInstance().createList(Practice.getInstance().getLevel());
		} else {
			Practice.getInstance().createList(PracticeLevel.HARD);
		}
	}
	
	
	@FXML
	@Override
	protected void returnToMainMenu() {
		Practice.getInstance().returnToMainMenu();
	}
}
