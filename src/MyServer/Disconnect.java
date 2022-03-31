package MyServer;

import com.ctc.wstx.exc.WstxOutputException;

public class Disconnect extends Exception{

    void disconnect(){
        System.out.println("Разрыв соединения тут что то сделать");
    }
}
