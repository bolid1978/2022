package MyClient;

import java.awt.*;

//----------------тут собствено формат сообщения всё что хотим передать
public class Message {
    String string;
    TypeMesange typeMesange;
    static public int countId;

    public Message(String string, TypeMesange typeMesange) {
        this.string = string;
        this.typeMesange = typeMesange;
        countId ++;
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
