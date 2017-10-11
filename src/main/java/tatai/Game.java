package tatai;

import javafx.stage.Stage;
import tatai.exceptions.OutOfItemsException;
import tatai.exceptions.ResultOutOfRangeException;
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
    private String _speech;
    private Result _result;


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
        _result = new Result();
        try {
            _currentQuestion = _model.getNext();
            _loader.loadScene("Question.fxml");

        } catch (OutOfItemsException e) {
            endOfLevel();
        }
    }

    public void skip() {
        _result.skip();
        _score.updateResult(_model.getCurrentQuestionNumber(), _result);
        question();
    }

    public void storeSpeech(String speech) {
        _speech = speech;
    }

    public void checkAnswer() {
        // TESTING ONLY
        try {
            _speech = _currentQuestion.getMaoriResult().toString();
        } catch (ResultOutOfRangeException e) {
            e.printStackTrace();
        }

        try {
            if (_speech.equals(_currentQuestion.getMaoriResult().toString())) {
                _result.addCorrect();
                _score.updateResult(_model.getCurrentQuestionNumber(), _result);
                _loader.loadScene("Correct.fxml");
            } else {
                _result.addMistake();
                _score.updateResult(_model.getCurrentQuestionNumber(), _result);
                _loader.loadScene("Incorrect.fxml");
            }
        } catch (ResultOutOfRangeException e) {
            e.printStackTrace();
        }
    }

    public int getErrorCount() {
        return _result.getErrorCount();
    }

    public void recordAgain() {
        _loader.loadScene("Question.fxml");
    }

    public void finishedRecording() {
        _loader.loadScene("FinishedRecording.fxml");
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
