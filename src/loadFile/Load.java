package loadFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import javax.mail.* ;
import javax.mail.internet.*;

public class Load {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://avatars.mds.yandex.net/i?id=4611452e1b440fd146e1d2409432cc38-4831580-images-thumbs&n=13");
        InputStream inputStream = url.openStream();
        Files.copy(inputStream, new File("c:\\1\\google.png").toPath());


    }
}
