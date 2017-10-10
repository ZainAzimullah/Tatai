package tatai.expression;

import tatai.numberModel.MaoriNumber;

public class ToStringTester {
    public static void main(String[] args) {
        Operator plus = new Add();
        Operator minus = new Subtract();
        Operator times = new Multiply();

        MaoriNumber a = new MaoriNumber(1);
        MaoriNumber b = new MaoriNumber(2);
        MaoriNumber c = new MaoriNumber(3);
        MaoriNumber d = new MaoriNumber(4);

        plus.addAllOperands(a, b);
        times.addAllOperands(plus, c);
        minus.addAllOperands(times, d);

        System.out.println(minus);
        System.out.println(minus.calculate());
    }
}
