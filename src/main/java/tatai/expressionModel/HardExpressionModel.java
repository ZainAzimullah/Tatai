package tatai.expressionModel;

import tatai.exceptions.ResultInvalidException;
import tatai.expression.Multiply;
import tatai.expression.Operator;
import tatai.numberModel.MaoriNumber;

public class HardExpressionModel extends ExpressionModel {

    // Randomly generate a collection of Operator objects such that
    // Each one also has a suboperator, and, atwo of the MaoriNumbers are
    // between 1 and 99 and 1 of them is between 1 and 10.
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
