package tatai;

public abstract class SceneController {
	protected Number _number;
	protected Game _game = Game.getInstance();
	
	public void setNumber(Number number) {
		_number = number;
	}
}
