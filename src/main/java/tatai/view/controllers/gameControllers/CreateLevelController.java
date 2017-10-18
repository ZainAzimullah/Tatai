package tatai.view.controllers.gameControllers;

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

public class CreateLevelController extends SceneController{

    @FXML
    private JFXCheckBox _addition, _subtraction, _multiplication, _division;

    @FXML
    private JFXTextField _name, _max;

    @FXML
    private Label _valid;

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
        _valid.setVisible(false);
        _max.setText("10");

        _max.textProperty().addListener((observable, oldValue, newValue) -> {
            String input = newValue.toString();
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(newValue.toString());

            if (matcher.matches()) {
                _valid.setVisible(false);
            } else {
                _valid.setVisible(true);
                _valid.setText("You must enter a number between 1 and 99");
            }
        });
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
