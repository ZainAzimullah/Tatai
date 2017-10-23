package tatai.expressionModel;

import tatai.exceptions.ResultInvalidException;
import tatai.expression.Operator;
import tatai.numberModel.MaoriNumber;

public class EasyExpressionModel extends ExpressionModel {

    // Randomly generate a collection of easy Operator objects, such that
    // each Operator object just consists of two MaoriNumbers between 1 and 10
    public EasyExpressionModel(int numberOfQuestions) {

        int i = 0;

        while (i < numberOfQuestions) {
            Operator operator = OperatorFactory.getOperator(generateRandomOperation());
            MaoriNumber num1, num2;
            num1 = generateRandomMaoriNumber(10);
            num2 = generateRandomMaoriNumber(10);

            operator.addAllOperands(num1, num2);

            // Check the answer to ensure the expression is OK for the game
            try {
                operator.getMaoriResult();
                if (operator.getMaoriResult().getDigits() > 10) {
                    throw new ResultInvalidException();
                }
                i++;
            } catch (ResultInvalidException e) {
                continue;
            }

            _expressions.add(operator);
        }
    }
}
