package tatai.view;

import javafx.stage.Stage;
import tatai.exceptions.TataiException;
import tatai.view.controllers.SceneController;
import tatai.view.controllers.mainMenuControllers.MainMenuController;

/*
 * This class is responsible for loading any scene belonging
 * to the main menu.  This could be the main menu itself, or any
 * scene that is accessible from the main menu except for 
 * game scenes.  For loading game scenes, the ancestor class
 * SceneLoader should be used.
 */
public class MainMenuLoader extends SceneLoader {

	public MainMenuLoader(Stage stage) {
		super(stage);
	}
	
	/*
	 * This is a hook method that will be called from SceneLoader
	 * that will be used to give the stage to the controller which will
	 * be a MainMenuController in this case.
	 */
	@Override
	protected void useController(SceneController controller) {
		if (controller instanceof MainMenuController) {
			((MainMenuController) controller).setStage(_stage);
		} else {
			System.out.println(controller.getClass());
			throw new TataiException("Cannot pass non-MainMenuController to "
					+ "MainMenuLoader");
		}
	}
}
