package tatai.score;

import tatai.numberModel.MaoriNumber;

import java.util.HashMap;
import java.util.Map;

public class Score {

    private HashMap<Integer, Result> _results;
    private MaoriNumber[] _numbers;

    public Score(int numberOfQuestions) {
        _results = new HashMap<>();
        _numbers = new MaoriNumber[numberOfQuestions];

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
