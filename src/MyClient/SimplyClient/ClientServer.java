package MyClient.SimplyClient;

import MyClient.Connect;
import MyClient.ConsolHelper;
import MyClient.Message;
import MyClient.TypeMesange;
import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.Socket;

public class ClientServer {
    public static final Logger LOGGERClientServer = LoggerFactory.getLogger(ClientServer.class);
    protected Connect connection;
    private volatile boolean clientConnected = false;

    public static void main(String[] args) {
        DOMConfigurator.configure("C:\\Users\\bolid\\IdeaProjects\\Test\\src\\MyClient\\properties\\loger.xml");
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


        protected void clientHandshake() throws IOException {
            while (true) {
                ConsolHelper.write("Введите имя пользователя или exit для выхода");

                String userName = ConsolHelper.read();
                if (userName.toUpperCase().matches("EXIT")) throw new IOException();
                message = new Message(userName, TypeMesange.USER_NAME);
                connection.send(message);

                message = connection.receive();
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
            if (message.getTypeMesange().equals(TypeMesange.USER_PASSWORD_ACCEPT)) {
                return true;
            }
            return false;
        }

        protected void clientMainLoop() {

        }

        @Override
        public void run() {
            ConsolHelper.write("Введите ip адресс");
            String ip = ConsolHelper.stringIp();
            ConsolHelper.write("Введите порт");
            int port = ConsolHelper.intPort();
            try {
                Socket socket = new Socket(ip, port);
                LOGGERClientServer.info("Soccet create");
                Connect connect = new Connect(socket);
                LOGGERClientServer.info("Connect creat in SocketThread");
                //----потом запускаем проверку пароля и основной цыкл
                clientHandshake();
                //  clientMainLoop();
            } catch (IOException e) {
                LOGGERClientServer.error("Soccet No create");
                e.printStackTrace();

            }


        }

    }


}



