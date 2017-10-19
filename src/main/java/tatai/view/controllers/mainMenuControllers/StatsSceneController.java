package tatai.view.controllers.mainMenuControllers;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import tatai.view.MainMenuLoader;

public class StatsSceneController extends MainMenuController {

    @FXML
    private LineChart<String, Integer> _chart;

    @FXML
    private void initialize() {
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();

    }

    @FXML
    private void back() {
        MainMenuLoader loader = new MainMenuLoader(_stage);
        loader.loadScene("MainMenu.fxml");
    }
}
