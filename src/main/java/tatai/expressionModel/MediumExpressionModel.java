package tatai.expressionModel;

import tatai.exceptions.ResultInvalidException;
import tatai.expression.Operator;
import tatai.numberModel.MaoriNumber;

public class MediumExpressionModel extends ExpressionModel {

    // Randomly generate a collection of Operator objects such that
    // each Operator has a sub Operator as well, there fore there are
    // three numbers in the equation (however all are between 1 and 10)
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

            // Check the answer to ensure the expression is OK for the game
            try {
                op2.getMaoriResult();
                i++;
            } catch (ResultInvalidException e) {
                continue;
            }

            _expressions.add(op2);
        }
    }
}
