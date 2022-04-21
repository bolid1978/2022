package MyServer;

import MyClient.Message;
import MyClient.TypeMesange;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;


public class Server {

    public static final Logger LOGGER = org.apache.log4j.Logger.getLogger(Server.class);
    static protected Map<String,User> clientMap = new HashMap<String,User>();



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

    private void notifyUsers(Connect connection, String userName) {
        Message message = new Message("Пользователь " + userName + "присоединился к чату", TypeMesange.TEXT);
        for (Map.Entry<String,User> el : clientMap.entrySet() ){
            if(!el.getKey().equals(userName)){
                connection.sentOut(message);
            }

        }
    }
    private void serverMainLoop(Connect connection, String userName) throws Disconnect{
        Message messageText;
        try {


            while (true) {

                messageText = connection.getIn();
                if (messageText.getTypeMesange() == TypeMesange.TEXT) {
                    sendBroadcastMessage(messageText);
                    System.out.println("Пользователь " + userName + ": написал " + messageText.getString() );
                } else {
                    System.out.println("Ошибка принятия сообщения");
                }
            }
        }
        catch (NullPointerException  e ){
            LOGGER.error(" объект message не принят");
        }


    }
      //--------отсылает месагу всем клиентам
    void sendBroadcastMessage(Message message) {

        for (Map.Entry<String,User> el : clientMap.entrySet() ){
               el.getValue().getConnect().sentOut(message);
        }
    }
     //--------проверяет тип сообщения на USER_NAME
    private boolean searchName(Message message){
        return  message.getTypeMesange().equals(TypeMesange.USER_NAME);

    }
    //---------проверяет тип сообщения на USER_PASSWORD
    private boolean searchPassword(Message message){
        return  message.getTypeMesange().equals(TypeMesange.USER_PASSWORD);

    }
     //------рукопажатие и возвращает имя пользователя каторо присоединили
    private String serverHandshake(Connect connection) throws Disconnect{
        Message message;
        String nameUser = "";
      //---------мы тут делаем рукопожатие
         message = connection.getIn();
        System.out.println(message);
        if (searchName(message)) {
            nameUser = message.getString();
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
                    //----------------
                    //--------если ссобщение без пароля
                }
            }

        }

        return nameUser;
    }

     private class Handler extends Thread{
        Socket socket;
        Connect newConnect;

        public Handler(Socket socket) {
            this.socket = socket;

        }

        @Override
        public void run() {
            String user = "";
           // LOGGER.info("Метод RUN запущен");
                  try {


                      newConnect = new Connect(socket);
                      LOGGER.info("Установлено соединение с сокетом " + newConnect.socket.getPort());
                      System.out.println("Установлено соединение с сокетом " + newConnect.socket.getPort());
                      user = serverHandshake(newConnect);
                      notifyUsers(newConnect, user);
                      serverMainLoop(newConnect, user);
                      // дальше по идеии нужно обработать все эксепшены но я их обрабатывал в каждом методе отдельно  по методам
                      // не надо было наверное блин . Попробывать отловить и описать все в каждом методе отдельно
                  }
                  //-------все рантаймы сюда в процессе видно будет---------все не рантайм там в методах то есть IOexeption например
                  // в методах остались и какие то рантайм сюда вылятят в процесс хз как и когда NullpointEXption ArifmeticExeption и т д

                  catch (RuntimeException e){
                      System.out.println("-----RuntimeExeption");
                      e.printStackTrace();
                      System.out.println("-----------------------");
                  }
                  catch(Disconnect e){

                      e.disconnect(user + ".Пользователь отключён от чата");
                      try {
                          socket.close();
                      } catch (IOException ex) {
                          ex.printStackTrace();
                      }
                  }

        }

    }
}
