package tatai;

import javafx.stage.Stage;
import tatai.exceptions.OutOfItemsException;
import tatai.expression.Operand;
import tatai.expressionModel.ExpressionModel;
import tatai.expressionModel.ExpressionModelFactory;
import tatai.score.Result;
import tatai.score.Score;
import tatai.util.Difficulty;
import tatai.view.MainMenuLoader;
import tatai.view.SceneLoader;

public class Game {
    public static final int NUM_OF_QUESTIONS = 10;

    private static Game _game;
    private static Stage _stage;

    private SceneLoader _loader;

    private Difficulty _difficulty;
    private Score _score;

    public Operand getCurrentQuestion() {
        return _currentQuestion;
    }

    private Operand _currentQuestion;

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
        _score = new Score(_model);
    }

    public void question() {
        try {
            _currentQuestion = _model.getNext();
            _loader.loadScene("Question.fxml");

        } catch (OutOfItemsException e) {
            endOfLevel();
        }
    }

    public void skip() {
        Result result = new Result();
        result.skip();
        _score.updateResult(_model.getCurrentQuestionNumber(), result);
    }

    public void recordAgain() {
        _loader.loadScene("Question.fxml");
    }

    public void finishedRecording() {
        _loader.loadScene("PracticeFinishedRecording.fxml");
    }

    public void endOfLevel() {
        System.out.println("end of level");
    }

    public Stage getStage() {
        return _stage;
    }

    public void returnToMainMenu() {
        MainMenuLoader loader = new MainMenuLoader(_stage);
        loader.loadScene("MainMenu.fxml");
    }
}
