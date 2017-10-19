package tatai.view.controllers.mainMenuControllers;

import javafx.fxml.FXML;
import tatai.view.MainMenuLoader;

public class StatsSceneController extends MainMenuController {

    @FXML
    private void initialize() {
        
    }

    @FXML
    private void back() {
        MainMenuLoader loader = new MainMenuLoader(_stage);
        loader.loadScene("MainMenu.fxml");
    }
}
