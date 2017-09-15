package tatai.view;

import javafx.stage.Stage;
import tatai.exceptions.TataiException;
import tatai.view.controllers.SceneController;
import tatai.view.controllers.mainMenuControllers.MainMenuController;

public class MainMenuLoader extends SceneLoader {
	
	public MainMenuLoader(Stage stage) {
		super(stage);
	}
	
	public MainMenuLoader() {}
	
	@Override
	protected void useController(SceneController controller) {
		if (controller instanceof MainMenuController) {
			controller = (MainMenuController) controller;
			((MainMenuController) controller).setStage(_stage);
		} else {
			System.out.println(controller.getClass());
			throw new TataiException("Cannot pass non-MainMenuController to "
					+ "MainMenuLoader");
		}
	}
}
