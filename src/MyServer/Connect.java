package MyServer;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Connect {
    Socket socket ;
    InputStream in;
    OutputStream out;
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

            in = socket.getInputStream();
            out = socket.getOutputStream();
        } catch (IOException e) {
            System.out.println("Не формированы потоки");
            e.printStackTrace();
        }
    }

    public byte[] getIn() throws IOException {
        return in.readAllBytes();
    }

    public  void sentOut(byte[] sent) throws IOException {
        out.write(sent);
    }
}
