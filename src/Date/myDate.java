package Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class myDate {
    public static void main(String[] args) throws ParseException {
        String time = "10.02.2022 10:00:34";
        DateFormat dateFormat =  new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date date = dateFormat.parse(time);
        System.out.println(date);
        System.out.println(dateFormat.format(date));
    }
}
