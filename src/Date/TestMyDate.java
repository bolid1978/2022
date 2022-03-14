package Date;

import java.text.FieldPosition;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
//         "дата" - отправить сообщение содержащее текущую дату в формате "d.MM.YYYY";
//        "день" - в формате "d";
//        "месяц" - "MMMM";
//        "год" - "YYYY";
//        "время" - "H:mm:ss";
//        "час" - "H";
//        "минуты" - "m";
//        "секунды" - "s".

public class TestMyDate {
    public static void main(String[] args) {
        String str = "время";
        String res = "";
        StringBuilder stringBuilder = new StringBuilder(res);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d.MM.YYYY");
        Date date = Calendar.getInstance().getTime();
       switch (str){
           case  "дата":{
               res = simpleDateFormat.format(date);
               break;
           }
           case  "день":{

               res = getString("d", date);
               break;
           }
           case  "месяц":{
               res = getString("MMMM", date);
               break;
           }
           case  "год":{
               res = getString("YYYY",date);
               break;
           }
           case  "время":{
               res = getString("H:mm:ss",date);
               break;
           }
           case  "час":{
               res = getString("H",date);
               break;
           }
           case  "минуты":{
               res = getString("m",date);
               break;
           }
           case  "секунды":{
               res = getString("s",date);
               break;
           }
       }

        System.out.println(res);
    }

    private static String getString(String str,Date date) {
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
       return  simpleDateFormat.format(date);
//
    }


}
