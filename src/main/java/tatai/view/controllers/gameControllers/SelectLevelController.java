package tatai.view.controllers.gameControllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import tatai.Game;
import tatai.util.Difficulty;
import tatai.view.SceneLoader;
import tatai.view.controllers.SceneController;

/**
 * This controller is for the SelectLevel scene.
 * Each handler method generates a new level accordingly
 * by invoking a method on the Game singleton which then
 * goes and uses a factory to create an appropriate ExpressionModel.
 */
public class SelectLevelController extends SceneController {

    @FXML
    private JFXButton _easy, _medium, _hard, _create, _load, _return;

    @FXML
    private void initialize() {
        // Create PopOvers
        setPopOver(_easy, "Easy equations where the answer will be between 1 and 10.  4 attempts allowed.");
        setPopOver(_medium, "Equations with 3 numbers, where the answer will be between 1 and 99.  4 attempts allowed.");
        setPopOver(_hard, "Harder equations with 3 numbers, where the answer is between 1 and 99 and only 2 attempts allowed.");
        setPopOver(_create, "Create your own level, with the settings you want.");
        setPopOver(_load, "Load a previously created level.");
        setPopOver(_return, "Return to the main menu.");
    }

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

    // Load scene to configure custom level
    @FXML
    private void create() {
        SceneLoader loader = new SceneLoader(Game.getInstance().getStage());
        loader.loadScene("CreateCustomLevel.fxml");
    }

    // Load scene to load a custom level
    @FXML
    private void useSaved() {
        SceneLoader loader = new SceneLoader(Game.getInstance().getStage());
        loader.loadScene("LoadCustomLevel.fxml");
    }

    @FXML
    @Override
    protected void returnToMainMenu() {
        Game.getInstance().returnToMainMenu();
    }
}
