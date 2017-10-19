package tatai.view.controllers.mainMenuControllers;

import javafx.fxml.FXML;
import javafx.scene.chart.*;
import tatai.score.Score;
import tatai.score.ScoreHistory;
import tatai.score.ScoreProperties;
import tatai.view.MainMenuLoader;

import java.util.ArrayList;
import java.util.Collections;

public class StatsSceneController extends MainMenuController {

    @FXML
    private AreaChart<String, Number> _chart;

    @FXML
    private void initialize() {
        ScoreHistory history = new ScoreHistory();

        NumberAxis yAxis = new NumberAxis(0, 10, 1);
        CategoryAxis xAxis = new CategoryAxis();

        AreaChart<String, Number> chart = new AreaChart(xAxis, yAxis);

        XYChart.Series series = new XYChart.Series();

        ArrayList<Score> scores = history.getScores();
        Collections.reverse(scores);

        for (Score score: scores) {
            series.getData().add(new XYChart.Data(score.getTime(), score.getTotal()));
        }

        chart.getData().add(series);
        _chart = chart;
    }

    @FXML
    private void back() {
        MainMenuLoader loader = new MainMenuLoader(_stage);
        loader.loadScene("MainMenu.fxml");
    }
}
