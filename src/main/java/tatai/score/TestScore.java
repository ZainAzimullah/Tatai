package tatai.score;

import com.google.gson.Gson;

public class TestScore {
    public static void main(String[] args) {
        Score score = new Score(10);

        score.debug();

        Gson gson = new Gson();
        String string = gson.toJson(score);
        System.out.println(string);

        Score score1 = gson.fromJson(string, Score.class);
        score1.debug();
    }
}
