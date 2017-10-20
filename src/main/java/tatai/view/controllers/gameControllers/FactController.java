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

public class FactController {

    private Stage _stage;

    @FXML
    private JFXTextArea _text;

    @FXML
    private JFXButton _ok;

    @FXML
    private void initialize() {
        _text.setEditable(false);

        try {
            URL folderURL = this.getClass().getResource("facts");
            File folder = new File(folderURL.toURI());
            File[] files = folder.listFiles();

            int random = (int) (Math.random() * files.length);

            File fact = files[random];

            FileReader fileReader = new FileReader(fact);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                _text.appendText(line);
            }

        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public void setStage(Stage stage) {
        _stage = stage;
    }

    @FXML
    private void ok() {
        if (_stage == null) {
            throw new RuntimeException("You did not set the stage for FactController");
        }

        _stage.close();
    }
}
