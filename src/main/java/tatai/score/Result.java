package tatai.score;

/**
 * A Result object stores the result only for a given question.
 * It is not concerned with the question number, or the question itself.
 */
public class Result {
    enum State {
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

    public State getState() {
        return _state;
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
        return "Result: " + _state.toString() + " #Mistakes: " + _numMistakes + " #Attempts: " + _numAttempts;
    }
}
