package tatai;

import javafx.beans.property.StringProperty;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class TestAnything {
    public static void main(String[] args) {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm dd/MM");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
    }
}
