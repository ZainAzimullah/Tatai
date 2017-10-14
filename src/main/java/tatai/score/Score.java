package tatai.score;

import com.google.gson.Gson;
import tatai.Main;
import tatai.exceptions.OutOfItemsException;
import tatai.expressionModel.ExpressionModel;
import tatai.util.Difficulty;

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

public class Score {

    private HashMap<Integer, Result> _results;
    private HashMap<Integer, String> _expressions;
    private Difficulty _difficulty;
    private ArrayList<FinalResult> _finalResults;

    private String _time;

    public Score(ExpressionModel model, Difficulty difficulty) {
        _difficulty = difficulty;
        _finalResults = new ArrayList<>();
        _results = new HashMap<>();
        _expressions = new HashMap<>();

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

    public void updateResult(int questionNumber, Result result) {
        _results.put(questionNumber, result);
    }

    public Result getResultFor(int questionNumber) {
        return _results.get(questionNumber);
    }

    public void addFinalResult(FinalResult finalResult) {
        _finalResults.add(finalResult);
    }

    public ArrayList<FinalResult> getFinalResults() {
        return _finalResults;
    }

    public int getTotal() {

        int sum = 0;

        for (Result result: _results.values()) {
            if (result.getState() == Result.State.CORRECT) {
                sum++;
            }
        }

        return sum;
    }

    public void save() throws IOException {


        DateFormat dateFormatForUser = new SimpleDateFormat("HH/mm dd/MM");
        DateFormat dateFormatForFile = new SimpleDateFormat("HH-mm_dd-MM");
        Date date = new Date();

        _time = dateFormatForUser.format(date);
        String filename = dateFormatForFile.format(date);

        File file = new File(Main.SCORES_FOLDER + "/" + filename);
        file.createNewFile();

        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        Gson gson = new Gson();
        String serialized = gson.toJson(this);

        bufferedWriter.append(serialized);
        bufferedWriter.close();
    }

    public void debug() {
        for (Map.Entry entry: _results.entrySet()) {
            System.out.println(entry.getValue());
        }

        for (Map.Entry entry: _expressions.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
    }
}
