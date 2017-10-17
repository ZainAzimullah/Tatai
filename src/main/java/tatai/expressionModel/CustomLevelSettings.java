package tatai.expressionModel;

import com.google.gson.Gson;
import tatai.Main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomLevelSettings {
    private int _max;
    private String _dateCreated;
    private boolean _addition, _subtraction, _multiplication, _division;

    public CustomLevelSettings(String dateCreated, int max, boolean addition, boolean subtraction, boolean multiplication, boolean division) {
        _dateCreated = dateCreated;
        _max = max;
        _addition = addition;
        _subtraction = subtraction;
        _multiplication = multiplication;
        _division = division;
    }

    public void save() throws IOException {
        // Set a nice date format to show the user, but a file-friendly format for saving
        DateFormat dateFormatForUser = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        DateFormat dateFormatForFile = new SimpleDateFormat("HH-mm_dd-MM");
        Date date = new Date();

        // Store the time the score was logged
        _dateCreated = dateFormatForUser.format(date);

        String filename = dateFormatForFile.format(date);

        // Create the new file
        File file = new File(Main.QUESTIONS_FOLDER + "/" + filename);
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

    public String getDateCreated() {
        return _dateCreated;
    }

    public int getMax() {
        return _max;
    }

    public boolean isAddition() {
        return _addition;
    }

    public boolean isSubtraction() {
        return _subtraction;
    }

    public boolean isMultiplication() {
        return _multiplication;
    }

    public boolean isDivision() {
        return _division;
    }
}
