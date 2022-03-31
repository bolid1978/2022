package MyServer;

import com.ctc.wstx.exc.WstxOutputException;

public class Disconnect extends Exception{

    void disconnect(String str){
        System.out.println("Разрыв соединения тут что то сделать " + str);
    }
}
