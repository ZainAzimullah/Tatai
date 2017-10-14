package tatai.score;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tatai.exceptions.OutOfItemsException;
import tatai.expression.Operand;
import tatai.expressionModel.ExpressionModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Score {

    private HashMap<Integer, Result> _results;
    private HashMap<Integer, String> _expressions;

    private ArrayList<FinalResult> _finalResults;

    public Score(ExpressionModel model) {
        _finalResults = new ArrayList<>();

        _results = new HashMap<>();
        _expressions = new HashMap<>();

        for (int i = 0; i < model.getSize(); i++) {
            try {
                System.out.println(model.getNext().toString());
//                _expressions.put(i + 1, model.getNext().toString());
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

    public void save() {

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
