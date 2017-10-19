package tatai.view.controllers.gameControllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import tatai.Game;
import tatai.Main;
import tatai.expressionModel.CustomExpressionModel;
import tatai.expressionModel.custom.CustomLevelHistory;
import tatai.expressionModel.custom.CustomLevelProperties;
import tatai.expressionModel.custom.CustomLevelSettings;
import tatai.view.controllers.SceneController;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class LoadLevelController extends SceneController {

    @FXML
    private TableView<CustomLevelProperties> _table;

    @FXML
    private TableColumn<CustomLevelProperties, String> _dateCreated;

    @FXML
    private TableColumn<CustomLevelProperties, String> _name;

    @FXML
    private JFXButton _playButton, _deleteButton;

    private CustomLevelProperties _levelSelected;

    @FXML
    private void initialize() {
        _playButton.setDisable(true);
        _deleteButton.setDisable(true);

        _dateCreated.setCellValueFactory(data -> data.getValue().dateCreatedProperty());
        _name.setCellValueFactory(data -> data.getValue().nameProperty());

        CustomLevelHistory history = new CustomLevelHistory();
        _table.setItems(history.getObservableList());
        _table.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            _levelSelected = newValue;
            _playButton.setDisable(false);
            _deleteButton.setDisable(false);
        }));
    }

    @FXML
    private void play() {
        Game.getInstance().setCustomSettings(_levelSelected.getSettings());
        Game.getInstance().newQuestion();
    }

    @FXML
    private void delete() {
        File file = new File(_levelSelected.getSettings().getFilename());
        file.delete();
    }

    @FXML
    @Override
    protected void returnToMainMenu() {
        Game.getInstance().selectLevel();
    }
}
