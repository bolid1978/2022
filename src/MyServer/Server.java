package MyServer;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    public static final Logger LOGGER = org.apache.log4j.Logger.getLogger(Server.class);
    
    public static void main(String[] args) {

        try {
            File currentDir = new File(".");
            DOMConfigurator.configure(String.format("%s\\src\\MyServer\\properties\\loger.xml", currentDir.getCanonicalPath()));
        } catch (IOException e) {
            System.out.println("не удаёться найти логер");
        }
        LOGGER.info("Запуск программы");

       Server server =  new Server();
       server.createSocket();

    }

    private void createSocket() {
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

     private class Handler extends Thread{
        Socket socket;
        Connect newConnect;

        public Handler(Socket socket) {
            this.socket = socket;

        }

        @Override
        public void run() {
            LOGGER.info("Метод RUN запущен");

                newConnect = new Connect(socket);
                while (true){
                System.out.println(newConnect.getIn());
                }
               // Message message = new Message("Hello",TypeMesange.NAME_REQUEST);
               // newConnect.sentOut(message);
        }
    }
}
