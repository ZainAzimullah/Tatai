package tatai.expressionModel;

import tatai.util.Difficulty;

public class TestExpressionModel {
    public static void main(String[] args) {
        ExpressionModel model = ExpressionModelFactory.getExpressionModel(Difficulty.EASY, 10);
        model.debug();

        model = ExpressionModelFactory.getExpressionModel(Difficulty.MEDIUM, 10);
        model.debug();

        model = ExpressionModelFactory.getExpressionModel(Difficulty.HARD, 10);
        model.debug();
    }
}
