package tatai.view.controllers.gameControllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import tatai.Game;
import tatai.expressionModel.CustomExpressionModel;
import tatai.expressionModel.custom.CustomLevelHistory;
import tatai.expressionModel.custom.CustomLevelProperties;
import tatai.expressionModel.custom.CustomLevelSettings;
import tatai.view.controllers.SceneController;

public class LoadLevelController extends SceneController {

    @FXML
    private TableView<CustomLevelProperties> _table;

    @FXML
    private TableColumn<CustomLevelProperties, String> _dateCreated;

    @FXML
    private TableColumn<CustomLevelProperties, String> _name;

    @FXML
    private JFXButton _playButton;

    private CustomLevelProperties _levelSelected;

    @FXML
    private void initialize() {
        _playButton.setDisable(true);

        _dateCreated.setCellValueFactory(data -> data.getValue().dateCreatedProperty());
        _name.setCellValueFactory(data -> data.getValue().nameProperty());

        CustomLevelHistory history = new CustomLevelHistory();
        _table.setItems(history.getObservableList());
        _table.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            _levelSelected = newValue;
            _playButton.setDisable(false);
        }));
    }

    @FXML
    private void play() {
        CustomExpressionModel model = new CustomExpressionModel(_levelSelected.getSettings());
        Game.getInstance().setCustomLevel(model);
        Game.getInstance().newQuestion();
    }

    @FXML
    @Override
    protected void returnToMainMenu() {
        Game.getInstance().selectLevel();
    }
}
