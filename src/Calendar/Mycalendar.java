package Calendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.SimpleFormatter;

public class Mycalendar {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        DateFormat formatter = new SimpleDateFormat("MM-DD-YY-HH");

        System.out.println(calendar.getTimeInMillis());
        System.out.println(formatter.format(calendar.getTime()));
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));

    }




}
