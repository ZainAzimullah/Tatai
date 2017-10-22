package tatai.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verifier {

    private String _userAnswer;
    private String _actualAnswer;

    public Verifier(String userAnswer, String actualAnswer) {
        _userAnswer = userAnswer;
        _actualAnswer = actualAnswer;
    }

    public boolean isCorrect() {
        // Separate the actual answer into a word array
        String[] words = _actualAnswer.split("\\s");

        // Build a regular expression to match the user's answer with
        String regex = "(\\w*\\s)*";
        int i = 0;

        // Allow any number of words in between the correct words,
        // as long as the required words appear somewhere in the right order.
        for (String word: words) {
            if (i == words.length - 1) {
                regex += word + "(\\s\\w*)*";
            } else {
                regex += word + "((\\s?\\w*\\s)*|(\\s))";
            }

            i++;
        }

        // Check for match
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(_userAnswer);
        return matcher.matches();
    }
}
