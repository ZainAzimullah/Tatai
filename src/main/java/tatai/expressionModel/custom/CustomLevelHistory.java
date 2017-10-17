package tatai.expressionModel.custom;

import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tatai.Main;
import tatai.score.Score;

import java.io.*;
import java.util.ArrayList;

public class CustomLevelHistory {

    public ObservableList<CustomLevelProperties> getObservableList() {
        ObservableList<CustomLevelProperties> out = FXCollections.observableArrayList();
        for (CustomLevelSettings level: getLevels()) {
            out.add(new CustomLevelProperties(level));
        }

        return out;
    }

    private ArrayList<CustomLevelSettings> getLevels() {
        File levelsFolder = new File(Main.QUESTIONS_FOLDER);
        File[] levels = levelsFolder.listFiles();

        ArrayList<CustomLevelSettings> levelsList = new ArrayList<>();

        for (File level: levels) {
            String serialized = "";
            FileReader fileReader = null;

            try {
                fileReader = new FileReader(level);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                // Read the file into one string
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    serialized += line;
                }

                // Deserialize the levels and add to list
                levelsList.add(deserializeLevel(serialized));

                fileReader.close();
                bufferedReader.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return levelsList;
    }

    // This method deserializes a saved Score
    private CustomLevelSettings deserializeLevel(String serialized) {
        // Gson library taken from:  https://github.com/google/gson
        Gson gson = new Gson();
        return gson.fromJson(serialized, CustomLevelSettings.class);
    }
}
