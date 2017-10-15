package tatai.score;

import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tatai.Main;

import java.io.*;
import java.util.ArrayList;

public class ScoreHistory {

    public ObservableList<ScoreProperties> getObservableList() {
        ObservableList<ScoreProperties> out = FXCollections.observableArrayList();

        for (Score score: getScores()) {
            out.add(new ScoreProperties(score));
        }

        return out;
    }

    public int getHighScore() {
        ArrayList<Score> scores = getScores();

        int highScore = 0;

        for (Score score: scores) {
            if (score.getTotal() > highScore) {
                highScore = score.getTotal();
            }
        }

        return highScore;
    }

    private ArrayList<Score> getScores() {
        File scoresFolder = new File(Main.SCORES_FOLDER);
        File[] scores = scoresFolder.listFiles();

        ArrayList<Score> scoresList = new ArrayList<>();

        for (File score: scores) {
            String serialized = "";
            FileReader fileReader = null;

            try {
                fileReader = new FileReader(score);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    serialized += line;
                }

                scoresList.add(getSerializedScore(serialized));

                fileReader.close();
                bufferedReader.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return scoresList;
    }

    private Score getSerializedScore(String serialized) {
        Gson gson = new Gson();
        return gson.fromJson(serialized, Score.class);
    }
}
