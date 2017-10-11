package tatai.expressionModel;

import tatai.exceptions.ResultOutOfRangeException;
import tatai.expression.Operand;
import tatai.expression.Operator;
import tatai.numberModel.MaoriNumber;

public class EasyExpressionModel extends ExpressionModel {


    public EasyExpressionModel(int numberOfQuestions) {

        int i = 0;

        while (i < numberOfQuestions) {
            Operator operator = OperatorFactory.getOperator(generateRandomOperation());
            MaoriNumber num1, num2;
            num1 = generateRandomMaoriNumber(10);
            num2 = generateRandomMaoriNumber(10);

            operator.addAllOperands(num1, num2);

            try {
                operator.getMaoriResult();
                i++;
            } catch (ResultOutOfRangeException e) {
                continue;
            }

            _expressions.add(operator);
        }
    }
}
