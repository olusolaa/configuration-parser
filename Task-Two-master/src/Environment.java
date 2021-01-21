import utils.CorrectFilePath;
import utils.Fomarter;
import utils.InvalidAgumentException;

import java.util.Map;

public abstract class Environment extends CorrectFilePath {



    static String environment;
    public static String selectEnvironment(String[] args) {
        correctFilePath();
        environment = "production";
        String filename = correctFilePath() + "config.txt";
        if (args.length > 0) {
            environment = args[0].toLowerCase();
            if (args[0].equalsIgnoreCase("production")) {
                filename = correctFilePath() + "config.txt";
                System.out.println(filename);
            }
            else if (args[0].equalsIgnoreCase("development")) {
                filename = filename.concat(".dev");
                System.out.println(filename);
            } else if (args[0].equalsIgnoreCase("staging")) {
                filename = filename.concat(".staging");
                System.out.println(filename);
            }else {
               throw new InvalidAgumentException();
            }
        }
        return filename;
    }

    public static void loadEnvironment(Map config){
        new Fomarter(config, environment);

    }

}
