package tatai.score;

public class Result {
    private enum State {
        CORRECT,
        INCORRECT,
        UNATTEMPTED,
        SKIPPED;
    }


    private int _numAttempts;
    private int _numMistakes;
    private State _state;

    public Result(State state, int numAttempts) {
        _state = state;
        _numAttempts = numAttempts;
        _numMistakes = numAttempts - 1;
    }

    public Result() {
        _state = State.UNATTEMPTED;
        _numAttempts = 0;
        _numMistakes = 0;
    }


    public int getNumAttempts() {
        return _numAttempts;
    }

    public int getNumMistakes() {
        return _numMistakes;
    }

    public State getState() {
        return _state;
    }

    @Override
    public String toString() {
        return _state.toString() + _numAttempts + _numMistakes;
    }
}
