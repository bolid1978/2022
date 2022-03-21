package MyClient;


import java.io.*;
import java.net.Socket;

//--------он делает операции с сокетом преобразует полученые из сокета данные в объект messange
public class Connect {
     private final Socket socket;
     private final ObjectInput in;
     private final ObjectOutput out;

    public Connect(Socket socket) throws IOException {
        this.socket = socket;
        this.in = new ObjectInputStream(socket.getInputStream());
        this.out = new ObjectOutputStream(socket.getOutputStream());
    }

    //----отсылает message метод синхронизейд
    public void  send(Message message){}

  //---принимает message метод синхронизейд
     public  Message receive() {
        return null;
     }

     //----закрывает потоки и сокет--


}
