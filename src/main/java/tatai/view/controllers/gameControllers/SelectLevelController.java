package tatai.view.controllers.gameControllers;

import javafx.fxml.FXML;
import tatai.Game;
import tatai.util.Difficulty;
import tatai.view.controllers.SceneController;

public class SelectLevelController extends SceneController {

    @FXML
    private void easy() {
        Game.getInstance().setDifficulty(Difficulty.EASY);
        Game.getInstance().newQuestion();
    }

    @FXML
    private void medium() {
        Game.getInstance().setDifficulty(Difficulty.MEDIUM);
        Game.getInstance().newQuestion();
    }

    @FXML
    private void hard() {
        Game.getInstance().setDifficulty(Difficulty.HARD);
        Game.getInstance().newQuestion();
    }

    @FXML
    private void create() {

    }

    @FXML
    private void useSaved() {

    }

    @FXML
    @Override
    protected void returnToMainMenu() {
        Game.getInstance().returnToMainMenu();
    }
}
