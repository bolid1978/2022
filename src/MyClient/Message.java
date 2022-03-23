package MyClient;

import MyClient.SimplyClient.ClientServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//----------------тут собствено формат сообщения всё что хотим передать
public class Message {
    public static final Logger LOGGERClientMessange = LoggerFactory.getLogger(ClientServer.class);
    String string;
    TypeMesange typeMesange;
    static public int countId;

    public Message(String string, TypeMesange typeMesange) {
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
}
