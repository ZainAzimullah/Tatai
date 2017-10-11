package tatai.expressionModel;

import tatai.exceptions.ResultOutOfRangeException;
import tatai.expression.Multiply;
import tatai.expression.Operator;
import tatai.numberModel.MaoriNumber;

public class HardExpressionModel extends ExpressionModel {
    public HardExpressionModel(int numOfQuestions) {
        int i = 0;

        while (i < numOfQuestions) {
            Operator op1, op2, op3;
            MaoriNumber num1, num2, num3, num4;

            op1 = new Multiply();
            op2 = OperatorFactory.getOperator(generateRandomOperation());

            num1 = generateRandomMaoriNumber(99);
            num2 = generateRandomMaoriNumber(10);
            num3 = generateRandomMaoriNumber(99);

            op1.addAllOperands(num1, num2);
            op2.addAllOperands(op1, num3);

            try {
                op2.getMaoriResult();
                i++;
            } catch (ResultOutOfRangeException e) {
                continue;
            }

            _expressions.add(op2);
        }
    }
}
