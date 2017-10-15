package tatai.expressionModel;

import tatai.exceptions.TataiException;
import tatai.util.Difficulty;

/**
 * This factory will generate an appropriate concrete ExpressionModel implementation
 * given a certain Difficulty.
 */
public class ExpressionModelFactory {

    private ExpressionModel _model;

    // Instantiate _model based on the Difficulty
    public static ExpressionModel getExpressionModel(Difficulty difficulty, int numQuestions) {
        switch (difficulty) {
            case EASY:
                return new EasyExpressionModel(numQuestions);

            case MEDIUM:
                return new MediumExpressionModel(numQuestions);
                
            case HARD:
                return new HardExpressionModel(numQuestions);

            default:
                throw new TataiException("Difficulty not supported");
        }
    }
}
