package MyServer;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;


public class Server {

    public static final Logger LOGGER = org.apache.log4j.Logger.getLogger(Server.class);
    public static void main(String[] args) {

        File currentDir = new File(".");

        try {
            DOMConfigurator.configure(String.format("%s\\src\\MyClient\\properties\\loger.xml", currentDir.getCanonicalPath()));
        } catch (IOException e) {
            System.out.println("не удаёться найти логер");
        }

        LOGGER.info("Запуск программы");

        int port = ConsolHelper.setPort();

        try {

            ServerSocket socketServer = new ServerSocket(port);
            LOGGER.info("Сервер запущен порт " + port);
            while (true){

                Socket socketin = socketServer.accept();

                new Handler(socketin).start();

            }


        } catch (IOException e) {
            LOGGER.info("Сервер не запущен");
            e.printStackTrace();
        }




    }

    static private class Handler extends Thread{
        Socket socket;
        Connect newConnect;

        public Handler(Socket socket) {
            this.socket = socket;
            newConnect = new Connect(socket);
        }

        @Override
        public void run() {
            LOGGER.info("Метод RUN запущен");
            try {
                while (true){
                    while(true) {
                        newConnect.sentOut("Привет".getBytes());
                    }
               // String resiver =  Arrays.toString(newConnect.getIn());
               // System.out.println(resiver);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
