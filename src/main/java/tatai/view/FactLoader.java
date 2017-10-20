package tatai.view;

import javafx.stage.Stage;
import tatai.exceptions.TataiException;
import tatai.view.controllers.SceneController;
import tatai.view.controllers.gameControllers.FactController;

public class FactLoader extends SceneLoader {
    public FactLoader(Stage stage) {
        super(stage);
    }

    @Override
    protected void useController(SceneController controller) {
        if (controller instanceof FactController) {
            ((FactController) controller).setStage(_stage);
        } else {
            throw new TataiException("Trying to load non-FactController using FactLoader");
        }
    }
}
