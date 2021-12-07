package messageForm;

import java.text.ChoiceFormat;
import java.text.DateFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.util.Date;

public class testMessageForm {


    public static void main(String[] args) {
        MessageFormat pattform = new MessageFormat("There {0} on {1}.\n{2} hfp ldf {2}\n{3}");
        int count = 0;
        Date date = new Date();
        int test = 0;
        Object[] testArgs = {count, "ADisk", date, test};

        double[] filelimits = {0,1,2};
        String[] filepart = {"are no files","is one file","are two files"};
        ChoiceFormat fileform = new ChoiceFormat(filelimits, filepart);
        pattform.setFormatByArgumentIndex(3, fileform);
        Format[] testFormats
                = {fileform, null,
                DateFormat.getDateInstance(DateFormat.SHORT), DateFormat.getTimeInstance(DateFormat.SHORT)};
        pattform.setFormats(testFormats);

      /*  String[] filepart = {"are no files","is one file","are {0} files"};
        ChoiceFormat fileform = new ChoiceFormat(filelimits, filepart);


;*/
        System.out.println(pattform.format(testArgs));

    }

}
