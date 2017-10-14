package tatai.view.controllers.gameControllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import tatai.Game;
import tatai.score.FinalResult;
import tatai.score.FinalResultProperties;
import tatai.score.Score;
import tatai.view.controllers.SceneController;


public class EndOfLevelController extends SceneController {

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
    private void initialize() {
        _questionNumber.setCellValueFactory(data -> data.getValue().questionNumberProperty());
        _expression.setCellValueFactory(data -> data.getValue().expressionProperty());
        _result.setCellValueFactory(data -> data.getValue().stateProperty());
        _numMistakes.setCellValueFactory(data -> data.getValue().numMistakesProperty());
    }

    public void setScore (Score score) {
        _tableView.setItems(FinalResultProperties.getObservableList(score));
        _total.setText(Integer.toString(score.getTotal()));
    }

    @FXML
    @Override
    protected void returnToMainMenu() {
        Game.getInstance().returnToMainMenu();
    }
}
