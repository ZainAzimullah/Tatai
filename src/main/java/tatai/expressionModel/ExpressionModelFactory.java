package tatai.expressionModel;

import tatai.exceptions.TataiException;

public class ExpressionModelFactory {
    public enum Difficulty {
        EASY,
        MEDIUM,
        HARD;
    }

    private ExpressionModel _model;

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
