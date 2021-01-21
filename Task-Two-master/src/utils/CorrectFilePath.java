package utils;

import java.nio.file.Paths;

public class CorrectFilePath {

    public static String correctFilePath() {
        String path = "" + Paths.get("").toAbsolutePath();
        if(!path.endsWith("/src")){
            path = path +"/src/";
        }else {
            path ="";
        }
        return path;
    }
}
