package tatai.score;

public class Result {
    private enum State {
        CORRECT,
        INCORRECT,
        UNATTEMPTED,
        SKIPPED;
    }


    private int _numAttempts = 0;
    private int _numMistakes = 0;
    private State _state;

    public Result() {
        _state = State.UNATTEMPTED;
    }

    public void addMistake() {
        _numAttempts++;
        _numMistakes++;
    }

    public void addCorrect() {
        _numAttempts++;
        _state = State.CORRECT;
    }

    public void skip() {
        _state = State.SKIPPED;
    }

    public int getErrorCount() {
        return _numMistakes;
    }
}
