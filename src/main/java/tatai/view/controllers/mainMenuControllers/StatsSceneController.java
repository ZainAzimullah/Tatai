package tatai.view.controllers.mainMenuControllers;

import com.jfoenix.controls.JFXRadioButton;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
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
    private JFXRadioButton _all, _easy, _medium, _hard, _custom;



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

        ToggleGroup group = new ToggleGroup();
        _easy.setToggleGroup(group);
        _medium.setToggleGroup(group);
        _hard.setToggleGroup(group);
        _custom.setToggleGroup(group);
        _all.setToggleGroup(group);

        _all.selectedProperty().addListener((observable, oldValue, newValue) -> {
            generateChart(history.getScores());
        });

        _easy.selectedProperty().addListener((observable, oldValue, newValue) -> {
            generateChart(history.getScores(Difficulty.EASY));
        });

        _medium.selectedProperty().addListener((observable, oldValue, newValue) -> {
            generateChart(history.getScores(Difficulty.MEDIUM));
        });

        _hard.selectedProperty().addListener((observable, oldValue, newValue) -> {
            generateChart(history.getScores(Difficulty.HARD));
        });

        _custom.selectedProperty().addListener((observable, oldValue, newValue) -> {
            generateChart(history.getScores(Difficulty.CUSTOM));
        });

        _all.selectedProperty().setValue(true);
    }

    private void generateChart(ArrayList<Score> scores) {
        _chart.getData().clear();

        XYChart.Series series = new XYChart.Series();
        for (Score score: scores) {
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
