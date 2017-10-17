package tatai.expressionModel;

import tatai.Game;
import tatai.exceptions.ResultOutOfRangeException;
import tatai.exceptions.TataiException;
import tatai.expression.Operator;
import tatai.expressionModel.custom.CustomLevelSettings;
import tatai.numberModel.MaoriNumber;

public class CustomExpressionModel extends ExpressionModel {

    public CustomExpressionModel(CustomLevelSettings settings) {
        int i = 0;

        while (i < Game.NUM_OF_QUESTIONS) {
            Operator operator = generateRandomOperator(settings);
            MaoriNumber num1, num2;
            num1 = generateRandomMaoriNumber(settings.getMax());
            num2 = generateRandomMaoriNumber(settings.getMax());

            operator.addAllOperands(num1, num2);

            // Check the answer to ensure the expression is OK for the game
            try {
                operator.getMaoriResult();
                i++;
            } catch (ResultOutOfRangeException e) {
                continue;
            }

            _expressions.add(operator);
        }
    }

    private Operator generateRandomOperator(CustomLevelSettings settings) {
        while (true) {
            Operation operation = generateRandomOperation();

            switch (operation) {
                case ADD:
                    if (settings.isAddition()) {
                        return OperatorFactory.getOperator(Operation.ADD);
                    }

                    break;
                case SUBTRACT:
                    if (settings.isSubtraction()) {
                        return OperatorFactory.getOperator(Operation.SUBTRACT);
                    }

                    break;
                case MULTIPLY:
                    if (settings.isMultiplication()) {
                        return OperatorFactory.getOperator(Operation.MULTIPLY);
                    }

                    break;
                case DIVIDE:
                    if (settings.isDivision()) {
                        return OperatorFactory.getOperator(Operation.DIVIDE);
                    }

                    break;

                default:
                    throw new TataiException("Unsupported operation");
            }
        }
    }
}
