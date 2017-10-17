package tatai.expressionModel;

public class CustomLevelSettings {
    private int _max;
    private boolean _addition, _subtraction, _multiplication, _division;

    public CustomLevelSettings(int max, boolean addition, boolean subtraction, boolean multiplication, boolean division) {
        _max = max;
        _addition = addition;
        _subtraction = subtraction;
        _multiplication = multiplication;
        _division = division;
    }

    public int getMax() {
        return _max;
    }

    public boolean isAddition() {
        return _addition;
    }

    public boolean isSubtraction() {
        return _subtraction;
    }

    public boolean isMultiplication() {
        return _multiplication;
    }

    public boolean isDivision() {
        return _division;
    }
}
