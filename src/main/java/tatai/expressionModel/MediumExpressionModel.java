package tatai.expressionModel;

import tatai.exceptions.ResultOutOfRangeException;
import tatai.expression.Operator;
import tatai.numberModel.MaoriNumber;

public class MediumExpressionModel extends ExpressionModel {
    public MediumExpressionModel(int numOfQuestions) {

        int i = 0;
        while (i < numOfQuestions) {
            Operator op1 = OperatorFactory.getOperator(generateRandomOperation());
            Operator op2 = OperatorFactory.getOperator(generateRandomOperation());

            MaoriNumber num1 = generateRandomMaoriNumber(10);
            MaoriNumber num2 = generateRandomMaoriNumber(10);
            MaoriNumber num3 = generateRandomMaoriNumber(10);

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
