package MyServer;

import MyClient.SimplyClient.ClientServer;
import MyClient.TypeMesange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

//----------------тут собствено формат сообщения всё что хотим передать
public class Message implements Serializable {
    public static final Logger LOGGERClientMessange = LoggerFactory.getLogger(ClientServer.class);
    String string;
    MyClient.TypeMesange typeMesange;
    static public int countId;

    public Message(String string, MyClient.TypeMesange typeMesange) {
        this.string = string;
        this.typeMesange = typeMesange;
        countId ++;
        LOGGERClientMessange.info("Сформировано новое сообщение");

    }

    public String getString() {
        return string;
    }

    public TypeMesange getTypeMesange() {
        return typeMesange;
    }

    public static int getCountId() {
        return countId;
    }

    @Override
    public String toString() {
        return "Message{" +
                "string='" + string + '\'' +
                ", typeMesange=" + typeMesange +
                '}';
    }
}
