package Calendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.SimpleFormatter;

public class Mycalendar {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        DateFormat formatter = new SimpleDateFormat("MM-DD-YY-HH");

//        System.out.println(calendar.getTimeInMillis());
//        System.out.println(formatter.format(calendar.getTime()));
//        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));

        String birthday ="30.05.1984";
        String year ="2015";
        DayOfWeek dow = DayOfWeek.of(2);
        Month month = Month.of(12);
        Year year1 = Year.parse(year);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        LocalDate localDate = LocalDate.parse(birthday,dateTimeFormatter);
        DayOfWeek birthDay = localDate.getDayOfWeek();
        System.out.println(birthDay.getDisplayName(TextStyle.FULL,Locale.FRENCH));


      //  Calendar calendar1 = Calendar.getInstance();
//        System.out.println(calendar.get(Calendar.DECEMBER));
//        System.out.println(dow.getDisplayName(TextStyle.FULL, Locale.ITALIAN));
//        System.out.println(month.getDisplayName(TextStyle.FULL, Locale.ITALIAN));



    }




}
