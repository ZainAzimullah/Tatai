package tatai.score;

import com.google.gson.Gson;
import tatai.Main;
import tatai.exceptions.OutOfItemsException;
import tatai.expressionModel.ExpressionModel;
import tatai.util.Difficulty;
import tatai.util.Saveable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Score extends Saveable implements Comparable<Score> {

    private HashMap<Integer, Result> _results;
    private HashMap<Integer, String> _expressions;
    private ArrayList<FinalResult> _finalResults;
    private Difficulty _difficulty;
    private String _time;
    private long _unixTime;

    public Score(ExpressionModel model, Difficulty difficulty) {
        _difficulty = difficulty;
        _finalResults = new ArrayList<>();
        _results = new HashMap<>();
        _expressions = new HashMap<>();

        // Initialise the expressions and set the results to unattempted
        for (int i = 0; i < model.getSize(); i++) {
            try {
                _expressions.put(i + 1, model.getNext().toString());
                _results.put(i + 1, new Result());
            } catch (OutOfItemsException e) {
                e.printStackTrace();
            }
        }

        model.reset();
    }

    // Add a new result
    public void updateResult(int questionNumber, Result result) {
        _results.put(questionNumber, result);
    }

    // Add a FinalResult (which contains more information than a Result)
    public void addFinalResult(FinalResult finalResult) {
        _finalResults.add(finalResult);
    }

    // Get the total number of mistakes the user made in the level
    public int getNumMistakes() {
        int numMistakes = 0;
        for (Result result: _results.values()) {
            numMistakes += result.getErrorCount();
        }

        return numMistakes;
    }

    // Get the total number of questions the user got correct in the level
    public int getTotal() {
        int sum = 0;
        for (Result result: _results.values()) {
            if (result.getState() == Result.State.CORRECT) {
                sum++;
            }
        }

        return sum;
    }

    // Save the score to a new file, with the filename as the current time and date.
    public void save() throws IOException {
        // Set a nice date format to show the user, but a file-friendly format for saving
        DateFormat dateFormatForUser = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        DateFormat dateFormatForFile = new SimpleDateFormat("HH-mm_dd-MM-ss");
        Date date = new Date();

        // Store the time the score was logged
        _time = dateFormatForUser.format(date);
        _unixTime = date.getTime();

        String filename = Main.SCORES_FOLDER + "/" + dateFormatForFile.format(date);

        save(filename);
    }

    public Result getResultFor(int questionNumber) {
        return _results.get(questionNumber);
    }

    public Difficulty getDifficulty() {
        return _difficulty;
    }

    public String getTime() {
        return _time;
    }

    public ArrayList<FinalResult> getFinalResults() {
        return _finalResults;
    }

    public long getUnixTime() {
        return _unixTime;
    }

    public void debug() {
        for (Map.Entry entry: _results.entrySet()) {
            System.out.println(entry.getValue());
        }

        for (Map.Entry entry: _expressions.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
    }

    @Override
    public int compareTo(Score otherScore) {
        if (otherScore.getUnixTime() < this.getUnixTime()) {
            return 1;
        } else if (otherScore.getUnixTime() > this.getUnixTime()) {
            return -1;
        } else {
            return 0;
        }
    }
}
