package tatai.view;

import javafx.stage.Stage;
import tatai.score.Score;
import tatai.view.controllers.SceneController;
import tatai.view.controllers.gameControllers.SessionDetailsController;

/**
 * This class is used especially for the loading of the
 * SessionDetails scene, since its controller needs to have special objects
 * given to it, and, it needs to be able to be loaded from anywhere.
 */
public class SessionDetailsLoader extends SceneLoader {

    private Score _score;

    public SessionDetailsLoader(Stage stage, Score score) {
        super(stage);
        _score = score;
    }

    // Pass the stage and score to the controller
    @Override
    protected void useController(SceneController controller) {
        if (controller instanceof SessionDetailsController) {
            ((SessionDetailsController) controller).setScore(_score);
            ((SessionDetailsController) controller).setStage(_stage);
        } else {
            throw new RuntimeException();
        }
    }
}
