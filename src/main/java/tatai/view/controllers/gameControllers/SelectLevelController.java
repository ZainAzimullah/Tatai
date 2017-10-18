package tatai.view.controllers.gameControllers;

import javafx.fxml.FXML;
import tatai.Game;
import tatai.util.Difficulty;
import tatai.view.SceneLoader;
import tatai.view.controllers.SceneController;

public class SelectLevelController extends SceneController {

    @FXML
    private void easy() {
        Game.getInstance().configureLevel(Difficulty.EASY);
        Game.getInstance().newQuestion();
    }

    @FXML
    private void medium() {
        Game.getInstance().configureLevel(Difficulty.MEDIUM);
        Game.getInstance().newQuestion();
    }

    @FXML
    private void hard() {
        Game.getInstance().configureLevel(Difficulty.HARD);
        Game.getInstance().newQuestion();
    }

    @FXML
    private void create() {
        SceneLoader loader = new SceneLoader(Game.getInstance().getStage());
        loader.loadScene("CustomLevelScene.fxml");
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
