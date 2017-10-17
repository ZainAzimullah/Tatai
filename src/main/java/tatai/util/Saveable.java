package tatai.util;

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Saveable {

    public void save(String filename) throws IOException {
        // Create the new file
        File file = new File(filename);
        file.createNewFile();

        // Create writers
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        // Serialize the score and save to file
        // Gson library taken from:  https://github.com/google/gson
        Gson gson = new Gson();
        String serialized = gson.toJson(this);
        bufferedWriter.append(serialized);

        // Close writers
        bufferedWriter.close();
        fileWriter.close();
    }
}
