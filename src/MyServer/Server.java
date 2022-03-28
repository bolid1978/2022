package MyServer;

import MyClient.Message;
import MyClient.TypeMesange;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;


public class Server {

    public static final Logger LOGGER = org.apache.log4j.Logger.getLogger(Server.class);
    static protected Map<Integer,User> clientMap = new HashMap<Integer,User>();
    static int counIntegerUser ;
    
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

    private boolean searchName(Message message){
        return  message.getTypeMesange().equals(TypeMesange.USER_NAME);

    }

    private String serverHandshake(Connect connection){
      //---------мы тут делаем рукопожатие
        Message message = connection.getIn();
        System.out.println(message);
        if (searchName(message)) {
            String nameUser = message.getString();
            //----искать в мапе имя пользователя

        }

        return null;
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
                 System.out.println("Установлено соединение с сокетом");
                serverHandshake(newConnect);
                while (true){

                }
               // Message message = new Message("Hello",TypeMesange.NAME_REQUEST);
               // newConnect.sentOut(message);
        }
    }
}
