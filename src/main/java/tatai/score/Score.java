package tatai.score;

import tatai.exceptions.OutOfItemsException;
import tatai.expression.Operand;
import tatai.expressionModel.ExpressionModel;

import java.util.HashMap;
import java.util.Map;

public class Score {

    private HashMap<Integer, Result> _results;
    private HashMap<Integer, Operand> _expressions;

    public Score(ExpressionModel model) {
        _results = new HashMap<>();
        _expressions = new HashMap<>();

        for (int i = 0; i < model.getSize(); i++) {
            try {
                _expressions.put(i + 1, model.getNext());
                _results.put(i + 1, new Result());
            } catch (OutOfItemsException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateResult(int questionNumber, Result result) {
        _results.put(questionNumber, result);
    }

    public void debug() {
        for (Map.Entry entry: _results.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
