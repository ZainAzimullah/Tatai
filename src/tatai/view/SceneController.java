package tatai.view;

import tatai.Game;
import tatai.Number;

/*
 * This is the parent class of all controllers.
 * Every controller gets the Game singleton so that it can be 
 * notified of changes in game progress.
 * Every controller gets the number which the user is being tested on.
 */
public abstract class SceneController {
	protected Number _number;
	protected Game _game = Game.getInstance();
	
	public void setNumber(Number number) {
		_number = number;
	}
}
