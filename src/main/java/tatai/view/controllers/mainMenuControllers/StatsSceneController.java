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

        _chart.getXAxis().setTickLabelsVisible(false);
        _chart.legendVisibleProperty().setValue(false);
        ((NumberAxis) _chart.getYAxis()).setLowerBound(0);
        ((NumberAxis) _chart.getYAxis()).setUpperBound(10);
        ((NumberAxis) _chart.getYAxis()).setTickUnit(1);
        _chart.getYAxis().setAutoRanging(false);


        XYChart.Series series = new XYChart.Series();

        ArrayList<Score> scores = history.getScores();
        Collections.reverse(scores);

        for (Score score: scores) {
            System.out.println(score.getTotal());
            series.getData().add(new XYChart.Data(score.getTime(), score.getTotal()));
        }

        _chart.getData().add(series);
    }

    @FXML
    private void back() {
        MainMenuLoader loader = new MainMenuLoader(_stage);
        loader.loadScene("MainMenu.fxml");
    }
}
