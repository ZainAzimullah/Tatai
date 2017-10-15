package tatai.view.controllers.gameControllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import tatai.Game;
import tatai.score.FinalResultProperties;
import tatai.score.Score;
import tatai.view.MainMenuLoader;
import tatai.view.controllers.SceneController;

import java.io.IOException;


public class SessionDetailsController extends SceneController {

    @FXML
    private TableView<FinalResultProperties> _tableView;

    @FXML
    private TableColumn<FinalResultProperties, String> _questionNumber;

    @FXML
    private TableColumn<FinalResultProperties, String> _expression;

    @FXML
    private TableColumn<FinalResultProperties, String> _result;

    @FXML
    private TableColumn<FinalResultProperties, String> _numMistakes;

    @FXML
    private Label _total;

    @FXML
    private JFXButton _saveButton;

    private Stage _stage;
    private Score _score;
    private Boolean _saved = false;

    @FXML
    private void initialize() {
        _questionNumber.setCellValueFactory(data -> data.getValue().questionNumberProperty());
        _expression.setCellValueFactory(data -> data.getValue().expressionProperty());
        _result.setCellValueFactory(data -> data.getValue().stateProperty());
        _numMistakes.setCellValueFactory(data -> data.getValue().numMistakesProperty());
    }

    @FXML
    private void replay() {
        if (!_saved) {
            int reply = showAlert();

            if (reply == SceneController.NO) {
                return;
            }
        }

        Game.getInstance().configureLevel(Game.getInstance().getDifficulty());
        Game.getInstance().newQuestion();
    }

    @FXML
    private void save() {
        try {
            _score.save();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Scores saved");
        alert.showAndWait();

        _saveButton.setDisable(true);
        _saved = true;
    }

    @FXML
    private void back() {
        MainMenuLoader loader = new MainMenuLoader(_stage);
        loader.loadScene("ScoreHistory.fxml");
    }

    public void setScore (Score score) {
        _score = score;
        _tableView.setItems(FinalResultProperties.getObservableList(score));
        _total.setText(Integer.toString(score.getTotal()));
    }

    public void setStage(Stage stage) {
        _stage = stage;
    }

    @FXML
    @Override
    protected void returnToMainMenu() {
        showAlertAndReturnFromGame();
    }
}
