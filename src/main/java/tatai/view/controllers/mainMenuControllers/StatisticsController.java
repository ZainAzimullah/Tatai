package tatai.view.controllers.mainMenuControllers;

import com.jfoenix.controls.JFXRadioButton;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import tatai.score.Score;
import tatai.score.ScoreHistory;
import tatai.util.Difficulty;
import tatai.view.MainMenuLoader;
import java.util.ArrayList;

/**
 * This is the controller the statistics scene
 */
public class StatisticsController extends MainMenuController {

    @FXML
    private AreaChart<String, Number> _chart;

    @FXML
    private Label _average, _best;

    @FXML
    private JFXRadioButton _all, _easy, _medium, _hard, _custom;

    private ScoreHistory _history = new ScoreHistory();

    @FXML
    private void initialize() {
        // Display the overall average and highscore
        _average.setText(Double.toString(_history.getMean()));
        _best.setText(Integer.toString(_history.getHighScore()));

        setUpChart();

        // Group the radiobuttons together
        group();

        // Set colours
        setRadioButtonColors(_all);
        setRadioButtonColors(_easy);
        setRadioButtonColors(_medium);
        setRadioButtonColors(_hard);
        setRadioButtonColors(_custom);

        // Make radiobuttons responsive to selections
        addRadioButtonListeners();

        // Set the default selection to "all"
        _all.selectedProperty().setValue(true);
    }

    // Create a chart with the score on the y-axis
    // and time on the x-axis
    private void setUpChart() {
        _chart.getXAxis().setTickLabelsVisible(false);
        _chart.legendVisibleProperty().setValue(false);
        ((NumberAxis) _chart.getYAxis()).setLowerBound(0);
        ((NumberAxis) _chart.getYAxis()).setUpperBound(10);
        ((NumberAxis) _chart.getYAxis()).setTickUnit(1);
        _chart.getYAxis().setAutoRanging(false);
        _chart.getYAxis().setLabel("Score");
        _chart.getXAxis().setLabel("Time");
    }

    // Link radiobuttons together
    private void group() {
        ToggleGroup group = new ToggleGroup();
        _easy.setToggleGroup(group);
        _medium.setToggleGroup(group);
        _hard.setToggleGroup(group);
        _custom.setToggleGroup(group);
        _all.setToggleGroup(group);
    }

    // Display new data in the graph for each radiobutton selection
    // When a particular radio button is clicked, the history for that level
    // will be graphed on the chart
    private void addRadioButtonListeners() {
        // "All" button
        _all.selectedProperty().addListener((observable, oldValue, newValue) -> {
            generateChart(_history.getScores());
            _average.setText(Double.toString(_history.getMean()));
            _best.setText(Integer.toString(_history.getHighScore()));
        });

        // "Easy" button
        _easy.selectedProperty().addListener((observable, oldValue, newValue) -> {
            generateChart(_history.getScores(Difficulty.EASY));
            _average.setText(Double.toString(_history.getMean(Difficulty.EASY)));
            _best.setText(Integer.toString(_history.getHighScore(Difficulty.EASY)));
        });

        // "Medium" button
        _medium.selectedProperty().addListener((observable, oldValue, newValue) -> {
            generateChart(_history.getScores(Difficulty.MEDIUM));
            _average.setText(Double.toString(_history.getMean(Difficulty.MEDIUM)));
            _best.setText(Integer.toString(_history.getHighScore(Difficulty.MEDIUM)));
        });

        // "Hard" button
        _hard.selectedProperty().addListener((observable, oldValue, newValue) -> {
            generateChart(_history.getScores(Difficulty.HARD));
            _average.setText(Double.toString(_history.getMean(Difficulty.HARD)));
            _best.setText(Integer.toString(_history.getHighScore(Difficulty.HARD)));
        });

        // "Custom" button
        _custom.selectedProperty().addListener((observable, oldValue, newValue) -> {
            generateChart(_history.getScores(Difficulty.CUSTOM));
            _average.setText(Double.toString(_history.getMean(Difficulty.CUSTOM)));
            _best.setText(Integer.toString(_history.getHighScore(Difficulty.CUSTOM)));
        });
    }

    private void setRadioButtonColors(JFXRadioButton button) {
        button.setUnSelectedColor(Color.WHITE);
        button.setSelectedColor(Color.LIGHTGREEN);
    }

    // Plot a chart for a given list of scores
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
