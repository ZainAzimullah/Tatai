package tatai.view.controllers.gameControllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import tatai.Game;
import tatai.score.FinalResult;
import tatai.score.Score;
import tatai.view.controllers.SceneController;


public class EndOfLevelController extends SceneController {

    @FXML
    private TableView<FinalResult> _tableView;

    @FXML
    private TableColumn<FinalResult, String> _questionNumber;

    @FXML
    private TableColumn<FinalResult, String> _expression;

    @FXML
    private TableColumn<FinalResult, String> _result;

    @FXML
    private TableColumn<FinalResult, String> _numMistakes;

    @FXML
    private Label _total;

    @FXML
    private void initialize() {
        _questionNumber.setCellValueFactory(data -> data.getValue().questionNumberProperty());
        _expression.setCellValueFactory(data -> data.getValue().expressionProperty());
        _result.setCellValueFactory(data -> data.getValue().stateProperty());
        _numMistakes.setCellValueFactory(data -> data.getValue().numMistakesProperty());

        Game game = Game.getInstance();
        Score score = game.getScore();
        ObservableList<FinalResult> res = score.getFinalResults();
        _tableView.setItems(res);

//        _tableView.setItems(Game.getInstance().getScore().getFinalResults());

        _total.setText(Integer.toString(Game.getInstance().getScore().getTotal()));
    }

    @FXML
    @Override
    protected void returnToMainMenu() {
        Game.getInstance().returnToMainMenu();
    }
}
