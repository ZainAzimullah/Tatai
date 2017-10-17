package tatai.expressionModel;

import tatai.expressionModel.custom.CustomLevelSettings;
import tatai.util.Difficulty;

public class TestExpressionModel {
    public static void main(String[] args) {
        ExpressionModel model = ExpressionModelFactory.getExpressionModel(Difficulty.EASY, 10);
        model.debug();

        model = ExpressionModelFactory.getExpressionModel(Difficulty.MEDIUM, 10);
        model.debug();

        model = ExpressionModelFactory.getExpressionModel(Difficulty.HARD, 10);
        model.debug();

        CustomLevelSettings settings = new CustomLevelSettings(30, true, false, false, true);
        model = new CustomExpressionModel(settings);

        model.debug();
    }
}
