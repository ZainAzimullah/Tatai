package tatai;

import javafx.beans.property.StringProperty;
import tatai.expressionModel.custom.CustomLevelSettings;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

/**
 * This is a test class which can be used to randomly test stuff
 * on the fly, to save time having to code up another main.
 */
public class TestAnything {
    public static void main(String[] args) {
        try {
            new CustomLevelSettings("Test", 25,true,false,false,true).save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
