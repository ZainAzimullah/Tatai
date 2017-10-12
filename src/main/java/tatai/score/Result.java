package tatai.score;

public class Result {
    enum State {
        CORRECT,
        INCORRECT,
        UNATTEMPTED,
        SKIPPED;
    }


    private int _numAttempts = 0;
    private int _numMistakes = 0;

    public State getState() {
        return _state;
    }

    private State _state;

    public Result() {
        _state = State.UNATTEMPTED;
    }

    public void addMistake() {
        _numAttempts++;
        _numMistakes++;
        _state = State.INCORRECT;
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

    @Override
    public String toString() {
        return _state.toString() + " " + _numMistakes + _numAttempts;
    }
}
