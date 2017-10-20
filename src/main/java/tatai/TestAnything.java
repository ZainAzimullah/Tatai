package tatai;

import javafx.beans.property.StringProperty;
import tatai.expressionModel.HardExpressionModel;
import tatai.expressionModel.MediumExpressionModel;
import tatai.expressionModel.custom.CustomLevelSettings;
import tatai.score.Result;
import tatai.score.Score;
import tatai.util.Difficulty;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

/**
 * This is a test class which can be used to randomly test stuff
 * on the fly, to save time having to code up another main.
 */
public class TestAnything {
    public static void main(String[] args) throws IOException, InterruptedException {
        Score score = new Score(new MediumExpressionModel(10), Difficulty.MEDIUM);
        Result result = new Result();
        result.addCorrect();
        score.updateResult(1, result);
        score.save();

        score = new Score(new HardExpressionModel(10), Difficulty.HARD);
        result = new Result();
        result.addCorrect();
        for (int i = 0; i < 7; i++) {
            score.updateResult(i, result);
        }

        score.save();

        Thread.sleep(3000);
        score = new Score(new HardExpressionModel(10), Difficulty.HARD);
        result = new Result();
        result.addCorrect();
        for (int i = 0; i < 7; i++) {
            score.updateResult(i, result);
        }

        score.save();
    }
}
