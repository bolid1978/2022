package MyClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsolHelper {

    private static final Logger LOGGERConsolHelper = LoggerFactory.getLogger(ConsolHelper.class);
    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void write(String str) {
        System.out.println(str);
    }

    public static  String read(){


        try {
            return in.readLine();
        } catch (IOException e) {
            System.out.println("Не удалось ввести данные");
            LOGGERConsolHelper.error("Не удалось ввести данные");
            e.printStackTrace();
        }
        return null;
    }

    public static int intPort() {

      //  System.setIn(System.in);
        int port = -1;
        String str;

        try {

            do {
                str = in.readLine();
                if (str.matches("\\d{1,5}")) {
                    port = Integer.parseInt(str);
                    if (port > 0 && port < 65535) {

                        break;
                    }
                }
                ConsolHelper.write("введите правельный порт");
            } while (true);

        } catch (IOException e) {
            System.out.println("Входной поток порта не закрылся");
            LOGGERConsolHelper.error("Входной поток порта не закрылся");
        }

        return port;
    }

    public static String stringIp() {
        String ip = null;


        try {

            do {
                ip = in.readLine();
                if (ip.matches("(\\d{1,3}\\.){3}\\d{1,3}")) {
                    break;
                } else if (ip.equalsIgnoreCase("LOCALHOST")) {
                    break;
                } else if (ip.matches("^([0-9A-Fa-f]{1,4}:){7}[0-9A-Fa-f]{1,4}$")) {
                    break;
                } else ConsolHelper.write("введите правельный ip адресс");
            }
            while (true);
        } catch (Exception e) {
            System.out.println("Ошибка входного потока ip");
            LOGGERConsolHelper.error("Ошибка входного потока ip");
        }

        return ip;
    }


}
