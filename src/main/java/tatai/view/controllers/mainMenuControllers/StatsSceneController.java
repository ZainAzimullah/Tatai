package tatai.view.controllers.mainMenuControllers;

import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import tatai.score.Score;
import tatai.score.ScoreHistory;
import tatai.score.ScoreProperties;
import tatai.util.Difficulty;
import tatai.view.MainMenuLoader;
import java.util.ArrayList;
import java.util.Collections;

public class StatsSceneController extends MainMenuController {

    @FXML
    private AreaChart<String, Number> _chart;

    @FXML
    private Label _average, _best;

    @FXML
    private void initialize() {

        ScoreHistory history = new ScoreHistory();

        _average.setText(Double.toString(history.getMean()));
        _best.setText(Integer.toString(history.getHighScore()));

        _chart.getXAxis().setTickLabelsVisible(false);
        _chart.legendVisibleProperty().setValue(false);
        ((NumberAxis) _chart.getYAxis()).setLowerBound(0);
        ((NumberAxis) _chart.getYAxis()).setUpperBound(10);
        ((NumberAxis) _chart.getYAxis()).setTickUnit(1);
        _chart.getYAxis().setAutoRanging(false);
        _chart.getYAxis().setLabel("Score");

        XYChart.Series series = new XYChart.Series();
        populateSeries(series, history.getScores());

        _chart.getData().add(series);
    }

    private void populateSeries(XYChart.Series series, ArrayList<Score> scores) {
        for (Score score: scores) {
            series.getData().add(new XYChart.Data(score.getTime(), score.getTotal()));
        }
    }

    @FXML
    private void back() {
        MainMenuLoader loader = new MainMenuLoader(_stage);
        loader.loadScene("MainMenu.fxml");
    }
}
