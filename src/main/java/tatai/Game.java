package tatai;

import javafx.stage.Stage;
import tatai.expressionModel.ExpressionModel;
import tatai.expressionModel.ExpressionModelFactory;
import tatai.util.Difficulty;
import tatai.view.MainMenuLoader;
import tatai.view.SceneLoader;

public class Game {
    public static final int NUM_OF_QUESTIONS = 10;

    private static Game _game;
    private static Stage _stage;

    private SceneLoader _loader;
    private Difficulty _difficulty;
    private ExpressionModel _model;

    private Game(Stage stage) {
        _stage = stage;
    }

    private Game() {
        // Singleton
    }

    public static Game getInitialInstance(Stage stage) {
        if (_game == null) {
            _game = new Game(stage);
        }

        return _game;
    }

    public static Game getInstance() {
        if (_game == null) {
            _game = new Game();
        }

        return _game;
    }

    public void selectLevel() {
        _loader = new SceneLoader(_stage);
        _loader.loadScene("SelectLevel.fxml");
    }



    public void setDifficulty(Difficulty difficulty) {
        _difficulty = difficulty;
        _model = ExpressionModelFactory.getExpressionModel(difficulty, NUM_OF_QUESTIONS);
    }

    public void question() {
        _model.debug();
    }

    public Stage getStage() {
        return _stage;
    }

    public void returnToMainMenu() {
        MainMenuLoader loader = new MainMenuLoader(_stage);
        loader.loadScene("MainMenu.fxml");
    }
}
