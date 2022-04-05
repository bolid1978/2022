package workFiles;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyFiles {
    public static void main(String[] args) {
        String basePath = new File("").getAbsolutePath();
        System.out.println(basePath);

        Path path = Paths.get("c:\\1\\log.txt");
        Path pathReletiv = path.relativize(Paths.get(basePath));
        System.out.println(pathReletiv.normalize());



    }

}
