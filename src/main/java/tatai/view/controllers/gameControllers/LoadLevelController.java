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

/**
 * Controller for scene which loads a level which the
 * user can select from a table.  This table lists
 * customised levels the user has configured
 * and saved in the past.
 */
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
        // Prevent user from clicking play or delete when nothing selected
        _playButton.setDisable(true);
        _deleteButton.setDisable(true);

        // Set up table
        _dateCreated.setCellValueFactory(data -> data.getValue().dateCreatedProperty());
        _name.setCellValueFactory(data -> data.getValue().nameProperty());

        // Get saved custom levels
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

        // Confirm with user
        int reply = showAlert();
        if (reply == SceneController.NO) {
            return;
        }

        // Delete the file
        file.delete();
        _table.getItems().remove(_levelSelected);

        // If all the items have been deleted, disable play and delete
        if (_table.getItems().size() == 0) {
            _playButton.setDisable(true);
            _deleteButton.setDisable(true);
        }
    }

    @FXML
    @Override
    protected void returnToMainMenu() {
        Game.getInstance().selectLevel();
    }
}
