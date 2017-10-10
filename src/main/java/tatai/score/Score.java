package tatai.score;

import tatai.expression.Operand;
import tatai.numberModel.MaoriNumber;

import java.util.HashMap;
import java.util.Map;

public class Score {

    private HashMap<Integer, Result> _results;
    private HashMap<Integer, Operand> _expressions;

    public Score(int numberOfQuestions) {
        _results = new HashMap<>();

        for (int i = 0; i < numberOfQuestions; i++) {
            _results.put(i + 1, new Result());
        }
    }

    public void debug() {
        for (Map.Entry entry: _results.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
