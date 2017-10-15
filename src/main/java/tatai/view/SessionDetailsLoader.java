package tatai.view;

import javafx.stage.Stage;
import tatai.score.Score;
import tatai.view.controllers.SceneController;
import tatai.view.controllers.gameControllers.SessionDetailsController;

public class SessionDetailsLoader extends SceneLoader {

    private Score _score;

    public SessionDetailsLoader(Stage stage, Score score) {
        super(stage);
        _score = score;
    }

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
