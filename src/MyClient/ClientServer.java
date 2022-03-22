package MyClient;

import SockeHTTP.SocketHtt;
import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.Socket;

public class ClientServer {
    public static final Logger LOGGERClientServer = LoggerFactory.getLogger(ClientServer.class);

    public static void main(String[] args) {
        DOMConfigurator.configure("C:\\Users\\bolid\\IdeaProjects\\Test\\src\\MyClient\\properties\\loger.xml");
        ClientServer clientServer = new ClientServer();
        clientServer.startClient();

    }

    //------в нем ещё должна создаваться своя нить на каждое соединение и эта нить демон
    //---эта нить класс SocketThread
    void startClient() {
        ConsolHelper.write("Введите ip адресс");
        String ip = ConsolHelper.stringIp();
        ConsolHelper.write("Введите порт");
        int port = ConsolHelper.intPort();
        try {
            Socket socket = new Socket(ip, port);
            LOGGERClientServer.info("Soccet create");
        } catch (IOException e) {
            e.printStackTrace();
            LOGGERClientServer.warn("Soccet No create");
        }


    }

    public class SocketThread extends Thread {
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

        //---------не понятная фигня что то снхронизирует
        protected void notifyConnectionStatusChanged() {

        }


        protected void clientHandshake() {

        }

        protected void clientMainLoop() {

        }

        @Override
        public void run() {

        }

    }
}



