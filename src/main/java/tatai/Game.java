package tatai;

import javafx.stage.Stage;
import tatai.exceptions.OutOfItemsException;
import tatai.exceptions.ResultOutOfRangeException;
import tatai.exceptions.TataiException;
import tatai.expression.Operand;
import tatai.expressionModel.CustomExpressionModel;
import tatai.expressionModel.ExpressionModel;
import tatai.expressionModel.ExpressionModelFactory;
import tatai.expressionModel.custom.CustomLevelSettings;
import tatai.score.Result;
import tatai.score.FinalResult;
import tatai.score.Score;
import tatai.util.Difficulty;
import tatai.view.MainMenuLoader;
import tatai.view.SceneLoader;
import tatai.view.SessionDetailsLoader;

public class Game {
    // Game settings
    public static final int NUM_OF_QUESTIONS = 10;
    public static final int MAX_ATTEMPTS = 3;

    // The Game singleton and its stage
    private static Game _game;

    private Stage _stage;


    // Game data
    private Difficulty _difficulty;

    private Score _score;
    private SceneLoader _loader;
    private String _speech;
    private Result _result;
    private ExpressionModel _model;
    private Operand _currentQuestion;
    private int _currentQuestionNumber;
    private CustomLevelSettings _settings;

    private Game(Stage stage) {
        _stage = stage;
    }

    // When the singleton is created for the first time, the stage
    // needs to be passed

    public static Game getInitialInstance(Stage stage) {
        if (_game == null) {
            _game = new Game(stage);
        }

        return _game;
    }
    // Get the game singleton
    public static Game getInstance() {
        if (_game == null) {
            throw new TataiException("Game not initialised");
        }

        return _game;
    }

    // Load the scene for choosing the level
    public void selectLevel() {
        _loader = new SceneLoader(_stage);
        _loader.loadScene("SelectLevel.fxml");
    }

    // Once the level is chosen, this method is called.  This
    // will then create an ExpressionModel and Score object accordingly.

    public void configureLevel(Difficulty difficulty) {
        _difficulty = difficulty;
        _model = ExpressionModelFactory.getExpressionModel(difficulty, NUM_OF_QUESTIONS);
        _score = new Score(_model, difficulty);
    }

    public void setCustomSettings(CustomLevelSettings settings) {
        _settings = settings;
        generateCustomLevel();
    }

    public void generateCustomLevel() {
        _model = new CustomExpressionModel(_settings);
        _difficulty = Difficulty.CUSTOM;
        _score = new Score(_model, _difficulty);
    }

    // Get the next question

    public void newQuestion() {
        _result = new Result();

        try {
            _currentQuestion = _model.getNext();
            _currentQuestionNumber = _model.getCurrentQuestionNumber();
            record();

        } catch (OutOfItemsException e) {
            endOfLevel();
        }
    }
    // Load the recording scene
    public void record() {
        _loader.loadScene("Question.fxml");
    }

    // Skip the current question, by notifying the result, updating the score and
    // getting the next question by calling newQuestion()

    public void skip() {
        _result.skip();
        _score.updateResult(_model.getCurrentQuestionNumber(), _result);

        newQuestion();
    }
    // Store what the user spoke into their microphone
    public void storeSpeech(String speech) {
        _speech = speech;
    }

    // Check the correctness of the answer
    public void checkAnswer() {

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

    // Load the scene for when the recording has finished
    public void finishedRecording() {
        _loader.loadScene("FinishedRecording.fxml");
    }

    // Display results at the end of the level
    public void endOfLevel() {
        // Reset question pointer in model
        _model.reset();

        // Iterate through model and create FinalResult objects to add to the score
        while (true) {
            try {
                Operand question = _model.getNext();
                int questionNumber = _model.getCurrentQuestionNumber();
                FinalResult result = new FinalResult(questionNumber, question,
                        _score.getResultFor(questionNumber));

                _score.addFinalResult(result);
            } catch (OutOfItemsException e) {
                break;
            }
        }

        // Load the details for this session in an EndOfLevel scene
        SessionDetailsLoader loader = new SessionDetailsLoader(_stage, _score);
        loader.loadScene("EndOfLevel.fxml");
    }

    // Return to the main menu from current screen
    public void returnToMainMenu() {
        MainMenuLoader loader = new MainMenuLoader(_stage);
        loader.loadScene("MainMenu.fxml");
    }

    public Difficulty getDifficulty() {
        return _difficulty;
    }
    public Score getScore() {
        return _score;
    }

    public String getSpeech() {
        return _speech;
    }

    public Operand getCurrentQuestion() {
        return _currentQuestion;
    }

    public int getCurrentQuestionNumber() {
        return _currentQuestionNumber;
    }

    public int getErrorCount() {
        return _result.getErrorCount();
    }

    public Stage getStage() {
        return _stage;
    }
}
