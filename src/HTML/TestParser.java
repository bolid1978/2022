package HTML;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
//2.2. Получи список элементов с атрибутом по имени "data-qa" и значением "vacancy-serp__vacancy". Должно быть до 20 вакансий на странице.
//        2.3. Если данные в списке из п.2.2 есть, то для каждого элемента:
//        2.3.1. создать вакансию и заполнить все ее данные, получив данные из текущего элемента.
//        Если тег с зарплатой присутствует, то заполнить и поле salary, иначе инициализировать поле пустой строкой.
//        site и url нужно взять из атрибута со значением "vacancy-serp__vacancy-title".
public class TestParser {
    public static void main(String[] args) throws IOException {

        Document document = Jsoup.connect("https://javarush.ru/testdata/big28data.html").get();

        Elements elements= document.getElementsByAttributeValue("data-qa","vacancy-serp__vacancy");
        for (Element el:elements
             ) {
         //   System.out.println(el);
         //   System.out.println("...............................................");
         //   System.out.println(el.after("href="));
         //   System.out.println("...............................................");
        }
        int number = elements.size() - 3;
        Element element = elements.get(number);
       // Document document1 = element.ownerDocument();
        System.out.println(element);


        Elements element1 = elements.get(number).getElementsByTag("span");
       // System.out.println(element1);
        Elements elements1Cost = elements.get(number).getElementsByAttributeValue("data-qa","vacancy-serp__vacancy-compensation");
        System.out.println(elements1Cost.get(0).ownText());

        Elements elements2 = element1.get(0).getElementsByTag("a");
        System.out.println(elements2.get(0).attr("href"));
        System.out.println(elements2.get(0).ownText());



        System.out.println(element1.get(1).ownText());
        System.out.println(element1.get(2).ownText());

        //System.out.println(elements.toString());

    }
}
