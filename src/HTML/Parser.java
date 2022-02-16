package HTML;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;

public class Parser {

    public static void main(String args[]) throws IOException {
         Document document = Jsoup.connect("https://javarush.ru/groups/posts/2007-legkiy-parsing-html-s-pomojshjhju-jsoup").get();
        System.out.println(document.title());
        System.out.println(document);

        // Parse HTML String using JSoup library
        String HTMLSTring = "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<title>JSoup Example</title>"
                + "</head>"
                + "<body>"
                + "<table><tr><td><h1>HelloWorld</h1></tr>"
                + "</table>"
                + "</body>"
                + "</html>";

        Document html = Jsoup.parse(HTMLSTring);
        String title = html.title();
        String h1 = html.body().getElementsByTag("h1").text();

        System.out.println("Input HTML String to JSoup :" + HTMLSTring);
        System.out.println("After parsing, Title : " + title);
        System.out.println("Afte parsing, Heading : " + h1);

        // JSoup Example 2 - Reading HTML page from URL
        Document doc;
        try {
            doc = Jsoup.connect("http://google.com/").get();
            title = doc.title();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Jsoup Can read HTML page from URL, title : " + title);

        // JSoup Example 3 - Parsing an HTML file in Java
        //Document htmlFile = Jsoup.parse("login.html", "ISO-8859-1"); // wrong
        Document htmlFile = null;
        try {
            htmlFile = Jsoup.parse(new File("C:\\Users\\sergey\\IdeaProjects\\2022\\src\\HTML\\1.html"), "ISO-8859-1");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // right
        title = htmlFile.title();
        Element div = htmlFile.getElementById("login");
        String cssClass = div.className(); // getting class form HTML element

        System.out.println("Jsoup can also parse HTML file directly");
        System.out.println("title : " + title);
        System.out.println("class of div tag : " + cssClass);

    }
}
