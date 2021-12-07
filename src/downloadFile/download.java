package downloadFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class download {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://pbs.twimg.com/media/D6NcGrEX4AE--oR.jpg:large");
        InputStream inputStream = url.openStream();

        Path tempFile = Files.createTempFile("temp-",".tmp");
        Files.copy(inputStream, tempFile);
    }
}
