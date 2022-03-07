package Calendar;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class LocalDate {


        public  boolean isLeap(java.time.LocalDate date) {
            return date.isLeapYear();
        }

        public  boolean isBefore(LocalDateTime dateTime) {
            LocalDateTime localDateTimeNow = LocalDateTime.now();
            return dateTime.isBefore(localDateTimeNow);
        }

        public  LocalTime addTime(LocalTime time, int n, ChronoUnit chronoUnit) {
            return time.plus(n,chronoUnit);
        }

        public  Period getPeriodBetween(java.time.LocalDate firstDate, java.time.LocalDate secondDate) {

            return (! firstDate.isAfter(secondDate)) ?  Period.between(firstDate,secondDate) : Period.between(secondDate,firstDate);
        }


}
