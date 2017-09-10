package tatai.view;

import tatai.exceptions.TataiException;

public class MainMenuLoader extends SceneLoader {
	
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
