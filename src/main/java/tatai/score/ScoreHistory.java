package tatai.score;

import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tatai.Main;

import java.io.*;
import java.util.ArrayList;

/**
 * This class is used to get past Score objects that have been serialized and
 * saved to file.
 */
public class ScoreHistory {

    // Get the Score objects and create ScoreProperties objects from them
    public ObservableList<ScoreProperties> getObservableList() {
        ObservableList<ScoreProperties> out = FXCollections.observableArrayList();

        for (Score score: getScores()) {
            out.add(new ScoreProperties(score));
        }

        return out;
    }

    // Get the highest score
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

    // Get an ArrayList of Score objects by reading all the Scores from
    // file and putting them into an ArrayList
    private ArrayList<Score> getScores() {
        File scoresFolder = new File(Main.SCORES_FOLDER);
        File[] scores = scoresFolder.listFiles();  // Get all Score files in the folder

        ArrayList<Score> scoresList = new ArrayList<>();

        // Iterate through each Score file in the folder
        for (File score: scores) {
            String serialized = "";
            FileReader fileReader = null;

            try {
                fileReader = new FileReader(score);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                // Read the file into one string
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    serialized += line;
                }

                // Deserialize the Scores and add to list
                scoresList.add(deserializeScore(serialized));

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

    // This method deserializes a saved Score
    private Score deserializeScore(String serialized) {
        Gson gson = new Gson();
        return gson.fromJson(serialized, Score.class);
    }
}
