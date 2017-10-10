package tatai.expression;

import tatai.numberModel.MaoriNumber;

public class ToStringTester {
    public static void main(String[] args) {
        Operator op1 = new Add();

        MaoriNumber num1 = new MaoriNumber(1);
        MaoriNumber num2 = new MaoriNumber(2);

        op1.addOperand(num1);
        op1.addOperand(num2);

        Operator op2 = new Multiply();

        op2.addOperand(op1);
        op2.addOperand(new MaoriNumber(3));

        System.out.println(op2.toString());
        System.out.println(op2.calculate());
    }
}
