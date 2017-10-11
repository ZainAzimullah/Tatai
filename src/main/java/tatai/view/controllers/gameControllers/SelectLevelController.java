package tatai.view.controllers.gameControllers;

import javafx.fxml.FXML;
import tatai.Game;
import tatai.util.Difficulty;
import tatai.view.MainMenuLoader;
import tatai.view.controllers.SceneController;

public class SelectLevelController extends SceneController {

    @FXML
    private void easy() {
        Game.getInstance().setDifficulty(Difficulty.EASY);
        Game.getInstance().question();
    }

    @FXML
    private void medium() {
        Game.getInstance().setDifficulty(Difficulty.MEDIUM);
        Game.getInstance().question();
    }

    @FXML
    private void hard() {
        Game.getInstance().setDifficulty(Difficulty.HARD);
        Game.getInstance().question();
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
