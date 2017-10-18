package tatai.view.controllers.gameControllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
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
    private JFXButton _save, _cancel;

    @FXML
    private JFXCheckBox _addition, _subtraction, _multiplication, _division;

    @FXML
    private JFXTextField _name, _max;

    @FXML
    private Label _valid, _operationValid;

    @FXML
    private void save() {

        // TODO
        // Read what the user has selected and enter the values
        // into the CustomLevelSettings constructor

        try {
            new CustomLevelSettings(null,
                    0,
                    false,
                    false,
                    false,
                    false).save();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Game.getInstance().selectLevel();
    }

    @FXML
    private void initialize() {
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
        String defaultName = "Untitled";

        _name.setText(defaultName);
        _name.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if ((newValue) && (_name.getText().equals(defaultName))) {
                _name.setText("");
            } else if (_name.getText().trim().equals("")) {
                _name.setText(defaultName);
            }
        });

        // Error handling for max number
        final String maxMessage = "You must enter a number between 1 and 99";

        _valid.setVisible(false);
        _max.setText("10");

        _max.textProperty().addListener((observable, oldValue, newValue) -> {
            String input = newValue.toString();
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(newValue.toString());

            if (matcher.matches()) {
                int number = Integer.parseInt(input);
                if ((number >= 1) && (number <= 99)) {
                    _valid.setVisible(false);
                    _save.setDisable(false);
                    return;
                }
            }
            _valid.setVisible(true);
            _valid.setText(maxMessage);
            _save.setDisable(true);
        });
    }

    private void checkOperations() {
        if (checkBoxesOK()) {
            _save.setDisable(false);
            _operationValid.setVisible(false);
        } else {
            _save.setDisable(true);
            _operationValid.setVisible(true);
            _operationValid.setText("Select at least one operation.");
        }
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
        int reply = showAlert();
        if (reply == SceneController.NO) {
            return;
        }

        Game.getInstance().selectLevel();
    }
}
