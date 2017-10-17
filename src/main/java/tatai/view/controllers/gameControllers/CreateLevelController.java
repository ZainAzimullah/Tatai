package tatai.view.controllers.gameControllers;

import javafx.fxml.FXML;
import tatai.Game;
import tatai.expressionModel.CustomLevelSettings;
import tatai.view.controllers.SceneController;

import java.io.IOException;

public class CreateLevelController extends SceneController{

    @FXML
    private void save() {

        // TODO
        // Read what the user has selected and enter the values
        // into the CustomLevelSettings constructor

        try {
            new CustomLevelSettings(0,
                    false,
                    false,
                    false,
                    false).save();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Game.getInstance().selectLevel();
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
