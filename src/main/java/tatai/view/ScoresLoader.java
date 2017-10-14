package tatai.view;

import javafx.stage.Stage;
import tatai.score.Score;
import tatai.view.controllers.SceneController;
import tatai.view.controllers.gameControllers.EndOfLevelController;

public class ScoresLoader extends SceneLoader {

    private Score _score;

    public ScoresLoader(Stage stage, Score score) {
        super(stage);
        _score = score;
    }

    @Override
    protected void useController(SceneController controller) {
        if (controller instanceof EndOfLevelController) {
            ((EndOfLevelController) controller).setScore(_score);
            ((EndOfLevelController) controller).setStage(_stage);
        } else {
            throw new RuntimeException();
        }
    }
}
