package tatai.score;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tatai.exceptions.OutOfItemsException;
import tatai.expression.Operand;
import tatai.expressionModel.ExpressionModel;

import java.util.HashMap;
import java.util.Map;

public class Score {

    private HashMap<Integer, Result> _results;
    private HashMap<Integer, Operand> _expressions;

    private ObservableList<FinalResult> _finalResults;

    public Score(ExpressionModel model) {
        _finalResults = FXCollections.observableArrayList();

        _results = new HashMap<>();
        _expressions = new HashMap<>();

        for (int i = 0; i < model.getSize(); i++) {
            try {
                _expressions.put(i + 1, model.getNext());
                _results.put(i + 1, new Result());
            } catch (OutOfItemsException e) {
                e.printStackTrace();
            }

            model.reset();
        }
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

    public ObservableList<FinalResult> getFinalResults() {
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

    public void debug() {
        for (Map.Entry entry: _results.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
