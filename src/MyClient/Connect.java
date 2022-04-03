package MyClient;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;

//--------он делает операции с сокетом преобразует полученые из сокета данные в объект messange
public class Connect {
    private static final Logger LOGGERconnect = LoggerFactory.getLogger(Connect.class);

    private final Socket socket;
    private  ObjectOutputStream out  ;
    private ObjectInputStream in ;

    public Connect(Socket socket)  {

        this.socket = socket;
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        OutputStream outputStream = null;
        try {
            outputStream = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            out = new ObjectOutputStream(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            in  = new ObjectInputStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //----отсылает message метод синхронизейд
    public void send(Message message) {
        synchronized (out) {
            try {
                out.writeObject(message);
                LOGGERconnect.warn("Данные переданы в выходной поток");

            } catch (IOException e) {
                LOGGERconnect.warn("Не удалось передать данные в выходной поток");
                e.printStackTrace();
            }
        }
    }

    //---принимает message метод синхронизейд
    public Message receive() {
        Message message = null;
        synchronized (in) {
            try {
                message = (Message) in.readObject();

            } catch (ClassNotFoundException e) {
                LOGGERconnect.warn("Не найден класс Message");
                e.printStackTrace();
            } catch (IOException e) {
                LOGGERconnect.warn("Не удалось передать данные в входной поток");

            }
        }
        return message;
    }

    //----закрывает потоки и сокет--11--22
    void close() {
        try {
            in.close();
        } catch (IOException e) {
            LOGGERconnect.warn("Не удалось закрыть входной поток");
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            LOGGERconnect.warn("Не удалось закрыть выходной поток");
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            LOGGERconnect.warn("Не удалось закрыть socket" + socket.getInetAddress() + " : " + socket.getPort());
            e.printStackTrace();
        }
    }


}
