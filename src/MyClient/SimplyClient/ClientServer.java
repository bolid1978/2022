package MyClient.SimplyClient;

import MyClient.*;
import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLOutput;

public class ClientServer {
    public static final Logger LOGGERClientServer = LoggerFactory.getLogger(ClientServer.class);
    protected Connect connection;
    private volatile boolean clientConnected = false;

    public static void main(String[] args)  {
      //  DOMConfigurator.configure("C:\\Users\\bolid\\IdeaProjects\\Test\\src\\MyClient\\properties\\loger.xml");

        try {
            File currentDir = new File(".");

            DOMConfigurator.configure(currentDir.getCanonicalPath() + "\\src\\MyClient\\properties\\loger.xml");
        } catch (IOException e) {
            System.out.println("Не найден путь к логеру");
            e.printStackTrace();
        }

        ClientServer clientServer = new ClientServer();
        clientServer.startClient();


    }

    //------в нем ещё должна создаваться своя нить на каждое соединение и эта нить демон
    //---эта нить класс SocketThread
    void startClient() {
        //----если нужно много клиентов разных типа боты то надо  socketThread потомков понаделать разных через фабрику выбирать например
        SocketThread socketThread = new SocketThread();
        socketThread.setDaemon(true);
        socketThread.start();

        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //-------вайт отпуститься как только прошла проверка пароля и можно передавать сообщения
        //------а отсылаться они будут в нити socketThread в методе луп то есть это как бы начнёт работать паралельно
        ConsolHelper.write("Введите сообщения для выходна нажмите EXIT");
        String sendString ;
        while (!(sendString = ConsolHelper.read()).equalsIgnoreCase("EXIT")){
            connection.send(new Message(sendString, TypeMesange.TEXT));
        }



    }

    public class SocketThread extends Thread {
        Message message;
        //------он будет создавать сокет
        //------он будет осуществлять рукопожатие
        //--------- в нём будет осной цыкл Loop
        //----- и пускаеться это всё из run()

        //-------выводит сообщение в ча что написал пользователь любой это входящее сообщение с сервера
        protected void processIncomingMessage() {
        }

        //-------выводит информацию о пользователе тех кто пирсоединился к чату это инфа с сервера
        protected void informAboutAddingNewUser() {
        }

        //-------выводит информацию о пользователе тех кто вышел из чата
        protected void informAboutDeletingNewUser() {

        }

        //---------'эта фигня освобождает обЬек от вайт то есть по идеи пока не законектиться или не вылетит к клиенту нет доступа'
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            synchronized (ClientServer.this) {
                ClientServer.this.notify();
                ClientServer.this.clientConnected = clientConnected;
            }

        }


        protected void clientHandshake() throws Exit{
            LOGGERClientServer.info("clientHandshake start");

            while (true) {
                ConsolHelper.write("Введите имя пользователя или exit для выхода");
                String userName = ConsolHelper.read();
                if (userName.toUpperCase().matches("EXIT")) throw new Exit();

                message = new Message(userName, TypeMesange.USER_NAME);
                connection.send(message);

                message = connection.receive();
                System.out.println(message);
                //-------если такое имя Не найдено он его прописывает то есть логин и пароль
                if (message.getTypeMesange().equals(TypeMesange.NAME_NO_ACCEPTED)) {
                    ConsolHelper.write("Такого пользователя не существует введите пароль для нового пользователя");
                    if (inputPassword()) {
                        notifyConnectionStatusChanged(true);
                        break;
                    } else System.out.println("Пароль не принят");
                }
                //-----------------если имя найдено
                else if (message.getTypeMesange().equals(TypeMesange.NAME_ACCEPTED)) {
                    System.out.println(message.getString());
                    if (inputPassword()) {
                        notifyConnectionStatusChanged(true);
                        break;
                    } else System.out.println("Пароль не принят");
                }
            }

        }

        protected boolean inputPassword() {
            ConsolHelper.write("Введите пароль");
            String namePassword = ConsolHelper.read();
            message = new Message(namePassword, TypeMesange.USER_PASSWORD);
            connection.send(message);
            message = connection.receive();
            System.out.println(message);
            return message.getTypeMesange().equals(TypeMesange.USER_PASSWORD_ACCEPT);
        }

        protected void clientMainLoop() {
            Message message;
           while (true){
               message = connection.receive();
               if(message.getTypeMesange() == TypeMesange.TEXT){
                   System.out.println(message.getString());
               }
           }
        }

        @Override
        public void run() {
//            ConsolHelper.write("Введите ip адресс");
//            String ip = ConsolHelper.stringIp();
//            ConsolHelper.write("Введите порт");
//            int port = ConsolHelper.intPort();
//            ConsolHelper.write("Подождите устанавливается соединение");
            String ip = "127.0.0.1";
            int port = 900;
            try {
                Socket socket = new Socket(ip, port);
                LOGGERClientServer.info("Soccet create");
                connection = new Connect(socket);
                LOGGERClientServer.info("Connect create  in SocketThread");
                //----потом запускаем проверку пароля и основной цыкл
                clientHandshake();
                clientMainLoop();
            }
            catch (Exit e) {

                LOGGERClientServer.error("EXIT соединение с чатом не установлено");
                e.printStackTrace();

            }
            catch (RuntimeException e) {
                LOGGERClientServer.error("RuntimeException соединение с чатом не установлено");
                e.printStackTrace();

            }


            catch (IOException e) {
                e.printStackTrace();
                LOGGERClientServer.error("Soccet No create");


            }


        }

    }


}



