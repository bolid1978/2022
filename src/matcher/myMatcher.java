package matcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class myMatcher {
    //https://javarush.ru/groups/posts/regulyarnye-vyrazheniya-v-java
    public static void main(String[] args) {
        String str = "get ip for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\".";
        System.out.println(str);
        Pattern pattern = Pattern.compile("\".+?\"");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
           // System.out.println(str.substring(matcher.start(), matcher.end()));
        }


    }
}
