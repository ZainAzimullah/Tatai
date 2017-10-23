package tatai.view.controllers.gameControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import tatai.Game;
import tatai.exceptions.ResultOutOfRangeException;
import tatai.view.controllers.SceneController;

/**
 * this class is responcible for the logic after the user gets a question correct
 * here the program only has to handle two cases, return to main menu and next question
 */
public class CorrectController extends SceneController {

    //label used to assign a question that the user was asked
    @FXML
    private Label _question;

    //label used to display to the user what the program thinks was said
    @FXML
    private Label _speech;

    //the method used when the user clicks next after getting a question correct
    @FXML
    private void next() {
        Game.getInstance().newQuestion();
    }

    //used to set up the screen, displaying the question and what the user has said
    @FXML
    private void initialize() {
        try {
            _speech.setText(Game.getInstance().getCurrentQuestion().getMaoriResult().toString());
        } catch (ResultOutOfRangeException e) {
            e.printStackTrace();
        }
        _question.setText(Game.getInstance().getCurrentQuestion().toString());
    }

    //method used to return to the main menu
    @FXML
    @Override
    protected void returnToMainMenu() {
        Game.getInstance().returnToMainMenu();
    }
}
