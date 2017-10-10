package tatai.expressionModel;

import tatai.exceptions.TataiException;

public class ExpressionModelFactory {
    public enum Difficulty {
        EASY,
        MEDIUM,
        HARD;
    }

    private ExpressionModel _model;

    public static ExpressionModel getExpressionModel(Difficulty difficulty) {
        switch (difficulty) {
            case EASY:
                return new EasyExpressionModel();

            case MEDIUM:
                return new MediumExpressionModel();
                
            case HARD:
                return new HardExpressionModel();

            default:
                throw new TataiException("Difficulty not supported");
        }
    }
}
