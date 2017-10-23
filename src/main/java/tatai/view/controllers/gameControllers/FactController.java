package tatai.view.controllers.gameControllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import tatai.view.controllers.SceneController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * this class is responsible to displaying a Maori fact, and all the logic behind it
 * if the user achieves a score of 8 or higher during the game session.
 */
public class FactController extends SceneController {

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
            URL folderURL = this.getClass().getResource("facts");
            File folder = new File(folderURL.toURI());
            File[] files = folder.listFiles();

            int random = (int) (Math.random() * files.length);

            File fact = files[random];

            FileReader fileReader = new FileReader(fact);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //loading the fact from a .txt file into the space to be displayed to the user
            String info = "";
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                info += line + "\n";
            }

            _text.setText(info);

        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
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
