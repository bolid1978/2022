package MyClient;

import java.io.IOException;

public class Exit extends IOException {
    public Exit() {
        System.out.println("Выход из приложения");
    }
}
