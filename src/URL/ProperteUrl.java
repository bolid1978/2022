package URL;

import java.net.MalformedURLException;
import java.net.URL;

//         - protocol
//        - authority
//        - file
//        - host
//        - path
//        - port
//        - default port
//        - query
//        - ref
//        схема://логин:пароль@хост:порт/(папка(и))/имя ресурса (файла)?параметры#якорь
//
//                Основные параметры Урл:
//
//                в качестве схемы  выступает обычно какой-нибудь протокол, обычно это http(s), ftp и множество других (skype, nfs)
//
//                логин-пароль нужны для прохождения одного из способов авторизации пользователя на сервере. Если авторизации не требуется, эти параметры не указываются
//
//                хост — полное доменное имя или IP-адрес компьютера в сети. Например, для Яндекса — это Yandex.ru
//
//                порт — на каком порту сервера будет производиться подключение к нему. В большинстве случаев, данный параметр не указывается,
//                т.к. по умолчанию подразумевается порт 80, которым обычно пользуются браузеры. Попробуйте к любому URL адресу сайта подставить «:80»,
//                ничего нового не произойдёт — будет совершён переход на адрес «без порта».
//                Например http://www.google.ru:80 перекинет на  http://www.google.ru.
//
//                далее идёт или сразу имя файла (например, page.php), или сначала 1 и более каталогов, а потом имя файла.
//                Если имя файла отсутствует, то открывается т.н. индексный файл — index.php (index.html, index.jsp и множество других расширений).
//                после имени файла могут указываться дополнительные параметры — после знака вопроса (?).
//                Между параметрами ставится знак амперсанда (&). К примеру, выглядеть это может так: http://www.bing.com/account/web?sh=5&ru=%2f.
//                Самих параметров может быть много, они имеют вид переменная=значение и обрабатываются на сервере с помощью языков серверного программирования
//
//                якорь в URL подставляется после решётки (#) и указывает на элемент открываемой страницы,
//                причём браузер обычно автоматически производит прокрутку до того html-элемента, id которого равно якорю.
//                Например, на созданных на WordPress сайтах при клике на «Читать далее»как раз это и происходит:
public class ProperteUrl {
    public static void main(String[] args) {
       String str = "https://www.amrood.com/index.htm?language=en#j2se";
        URL aURL = null;
        try {
            aURL = new URL(str);
            System.out.println("protocol = " + aURL.getProtocol());
            System.out.println("authority = " + aURL.getAuthority());
            System.out.println("host = " + aURL.getHost());
            System.out.println("port = " + aURL.getPort());
            System.out.println("path = " + aURL.getPath());
            System.out.println("query = " + aURL.getQuery());
            System.out.println("filename = " + aURL.getFile());
            System.out.println("ref = " + aURL.getRef());

        } catch (MalformedURLException  | NullPointerException e) {
            e.printStackTrace();
        }


    }
}
