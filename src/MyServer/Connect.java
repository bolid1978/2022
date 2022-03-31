package MyServer;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.*;
import java.net.Socket;

public class Connect {
    Socket socket ;
    ObjectInputStream in;
    ObjectOutputStream out;
    public static final Logger LOGGERconect = org.apache.log4j.Logger.getLogger(Connect.class);

    public Connect(Socket socket) {
        try {
            File currentDir = new File(".");
            DOMConfigurator.configure(currentDir.getCanonicalPath() + "\\src\\MyClient\\properties\\loger.xml");
        } catch (IOException e) {
            System.out.println("Не найден путь к логеру");
            e.printStackTrace();
        }
        this.socket = socket;
        try {

            in = new ObjectInputStream (socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());

        } catch (IOException e) {
            System.out.println("Не формированы потоки");
            e.printStackTrace();
        }
    }

    public MyClient.Message getIn() {
        try {
            MyClient.Message message = (MyClient.Message) in.readObject();
            return message;
        }catch (ClassNotFoundException e) {
            LOGGERconect.info("не найден обЬект message");
            e.printStackTrace();
        }
        catch (IOException e) {
            LOGGERconect.info("не отправился объект message");
            try {
                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
           // e.printStackTrace();
        }
        return null;
    }

    public  void sentOut(MyClient.Message message)  {
        try {
            out.writeObject(message);
        } catch (IOException e) {
            LOGGERconect.info("не отправился обЪект message");
            e.printStackTrace();
        }
    }
}
