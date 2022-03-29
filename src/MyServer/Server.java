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
    static protected Map<String,User> clientMap = new HashMap<String,User>();

    Message message;

    public static void main(String[] args) {
//
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
        //int port = ConsolHelper.setPort();
        int port = 900;
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
    private boolean searchPassword(Message message){
        return  message.getTypeMesange().equals(TypeMesange.USER_PASSWORD);

    }

    private String serverHandshake(Connect connection){
      //---------мы тут делаем рукопожатие
         message = connection.getIn();
        System.out.println(message);
        if (searchName(message)) {
            String nameUser = message.getString();
            //----искать в мапе имя пользователя
            if (clientMap.containsKey(nameUser)){
                //--------если пользователь найден
                message = new Message("Пользователь найден введите пароль",TypeMesange.NAME_ACCEPTED);

            }
            else {
                //----------если пользователь не найден
                System.out.println("Пользователь с именем " + nameUser + " не найден");
                LOGGER.info("Пользователь с именем " + nameUser + " не найден");

                message = new Message("Пользователь не найден введите пароль",TypeMesange.NAME_NO_ACCEPTED);
                connection.sentOut(message);

                message = connection.getIn();
                System.out.println(message);
                if(searchPassword(message)){
                    String password = message.getString();
                    //--------если сообщение с паролем
                    message = new Message("пароль установлен",TypeMesange.USER_PASSWORD_ACCEPT);
                    System.out.println(message);
                    connection.sentOut(message);
                    User user = new User();
                    user.setConnect(connection) ;
                    user.setName(nameUser);
                    user.setPassword(password);
                    clientMap.put(nameUser,user);

                }
                else {
                    //--------если ссобщение без пароля
                }
            }

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
           // LOGGER.info("Метод RUN запущен");

                 newConnect = new Connect(socket);
                 LOGGER.info("Установлено соединение с сокетом " + newConnect.socket.getPort());
                 System.out.println("Установлено соединение с сокетом " + newConnect.socket.getPort());
                 serverHandshake(newConnect);
                while (true){

                }
               // Message message = new Message("Hello",TypeMesange.NAME_REQUEST);
               // newConnect.sentOut(message);
        }
    }
}
