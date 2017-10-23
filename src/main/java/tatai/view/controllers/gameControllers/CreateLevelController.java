package tatai.view.controllers.gameControllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import tatai.Game;
import tatai.expressionModel.custom.CustomLevelSettings;
import tatai.view.controllers.SceneController;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class CreateLevelController extends SceneController {

    @FXML
    private JFXButton _save;

    @FXML
    private JFXCheckBox _addition, _subtraction, _multiplication, _division;

    @FXML
    private JFXTextField _name, _max;

    @FXML
    private Label _valid, _operationValid;

    @FXML
    private void save() {

        try {
            new CustomLevelSettings(_name.getText(),
                    Integer.parseInt(_max.getText()),
                    _addition.isSelected(),
                    _subtraction.isSelected(),
                    _multiplication.isSelected(),
                    _division.isSelected()).save();

            showSavedMessage("Custom level");

        } catch (IOException e) {
            e.printStackTrace();
        }

        Game.getInstance().selectLevel();
    }

    @FXML
    private void initialize() {
        _operationValid.setVisible(false);

        // Error handling for checkboxes
        _addition.setSelected(true);

        _addition.selectedProperty().addListener((observable, oldValue, newValue) -> {
            checkOperations();
        });

        _subtraction.selectedProperty().addListener((observable, oldValue, newValue) -> {
            checkOperations();
        });

        _multiplication.selectedProperty().addListener((observable, oldValue, newValue) -> {
            checkOperations();
        });

        _division.selectedProperty().addListener((observable, oldValue, newValue) -> {
            checkOperations();
        });


        // Error handling for name
        final String defaultName = "Untitled";

        _name.setText(defaultName);
        _name.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if ((newValue) && (_name.getText().equals(defaultName))) {
                _name.setText("");
                _save.setDisable(true);
                return;
            } else if (_name.getText().trim().equals("")) {
                _name.setText(defaultName);
            }

            enableSaveButton();
        });

        _name.textProperty().addListener((observable, oldValue, newValue) -> {
            if (_name.getText().equals("")) {
                _save.setDisable(true);
                return;
            }

            enableSaveButton();
        });

        // Error handling for max number
        final String maxMessage = "You must enter a number between 10 and 99";

        _valid.setVisible(false);
        _max.setText("10");

        _max.textProperty().addListener((observable, oldValue, newValue) -> {
            String input = newValue.toString();
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(newValue.toString());

            if (maxOK()) {
                _valid.setVisible(false);
                enableSaveButton();
                return;
            }
            _valid.setVisible(true);
            _valid.setText(maxMessage);
            _save.setDisable(true);
        });
    }

    private void checkOperations() {
        if (checkBoxesOK()) {
            enableSaveButton();
            _operationValid.setVisible(false);
        } else {
            _save.setDisable(true);
            _operationValid.setVisible(true);
            _operationValid.setText("Select at least one operation.");
        }
    }

    private void enableSaveButton() {
        if (nameOK() && maxOK() && checkBoxesOK()) {
            _save.setDisable(false);
        }
    }

    private boolean nameOK() {
        if (_name.getText().trim().equals("")) {
            return false;
        }

        return true;
    }

    private boolean maxOK() {
        String input = _max.getText();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(_max.getText());

        if (matcher.matches()) {
            int number = Integer.parseInt(input);
            if ((number >= 10) && (number <= 99)) {
                return true;
            }
        }

        return false;
    }

    private boolean checkBoxesOK() {
        if (_addition.isSelected()
                || _subtraction.isSelected()
                || _multiplication.isSelected()
                || _division.isSelected()) {
            return true;
        }

        return false;
    }

    // Cancel button
    @FXML
    @Override
    protected void returnToMainMenu() {
        int reply = showAlert("Changes won't be saved.");
        if (reply == SceneController.NO) {
            return;
        }

        Game.getInstance().selectLevel();
    }
}
