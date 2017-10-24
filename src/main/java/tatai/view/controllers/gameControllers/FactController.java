package tatai.view.controllers.gameControllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import tatai.view.controllers.SceneController;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * this class is responsible to displaying a Maori fact, and all the logic behind it
 * if the user achieves a score of 8 or higher during the game session.
 */
public class FactController extends SceneController {

    private final int NUM_FACTS = 12;

    //the stage that the fact will be displayed on
    private Stage _stage;

    //where the fact will be contained/displayed
    @FXML
    private JFXTextArea _text;

    //setting up the fact to be displayed to the audiance
    @FXML
    private void initialize() {
        _text.setEditable(false);

        //attempting to load the scene into the stage
        try {
            int random = (int) (Math.random() * NUM_FACTS);

            InputStream inputStream = getClass().getResourceAsStream("facts/" + random + ".txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            //loading the fact from a .txt file into the space to be displayed to the user
            String info = "";
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                info += line + "\n";
            }

            _text.setText(info);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setStage(Stage stage) {
        _stage = stage;
    }

    //once the user has read the face they can close the stage by clicking ok
    @FXML
    private void ok() {
        if (_stage == null) {
            throw new RuntimeException("You did not set the stage for FactController");
        }

        _stage.close();
    }

    @Override
    protected void returnToMainMenu() {}
}
