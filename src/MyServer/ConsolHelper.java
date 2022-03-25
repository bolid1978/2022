package MyServer;

import java.io.*;

public class ConsolHelper implements Closeable {



    public static int setPort(){

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberPort;
        do {
            write("Введите порт");
            try {
                String str = bufferedReader.readLine();
                if(str.matches("\\d{1,5}")){
                    numberPort = Integer.parseInt(str);
                    if (numberPort > 0 && numberPort < 65535) break;
                }
            } catch (IOException e) {
                System.out.println("Ошибка ввода ");
                e.printStackTrace();
            }
        }
        while (true);
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Не удаёться закрыть поток");
        }
        return  numberPort;
    }

    public static void write(String messange){
        System.out.println(messange);
    }

    @Override
    public void close() throws IOException {

    }
}
