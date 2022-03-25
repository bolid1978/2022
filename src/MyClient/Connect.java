package MyClient;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;

//--------он делает операции с сокетом преобразует полученые из сокета данные в объект messange
public class Connect {
    private static final Logger LOGGERconnect = LoggerFactory.getLogger(Connect.class);

    private final Socket socket;
    private final ObjectOutput out;
    private ObjectInput in =  null;

    public Connect(Socket socket) throws IOException {

        this.socket = socket;
        this.out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());

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
        synchronized (in) {
            try {
                Message message = (Message) in.readObject();
                LOGGERconnect.warn("Данные получены в выходной поток");
            } catch (ClassNotFoundException e) {
                LOGGERconnect.warn("Не найден класс Message");
                e.printStackTrace();
            } catch (IOException e) {
                LOGGERconnect.warn("Не удалось передать данные в входной поток");
                e.printStackTrace();
            }
        }
        return null;
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
