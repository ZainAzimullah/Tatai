package tatai.view;

import javafx.stage.Stage;
import tatai.exceptions.TataiException;
import tatai.view.controllers.SceneController;
import tatai.view.controllers.gameControllers.FactController;

/**
 * Loader for loading the Reward scene (it gets given a separate stage)
 */
public class FactLoader extends SceneLoader {
    public FactLoader(Stage stage) {
        super(stage);
    }

    // Pass the stage to the controller
    @Override
    protected void useController(SceneController controller) {
        if (controller instanceof FactController) {
            ((FactController) controller).setStage(_stage);
        } else {
            throw new TataiException("Trying to load non-FactController using FactLoader");
        }
    }
}
