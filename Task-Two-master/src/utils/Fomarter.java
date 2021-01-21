package utils;

import java.util.Map;

public class Fomarter {

    public Fomarter(Map config, String environment) {
        System.out.println("*******************************************");
        System.out.println("**   Loading... " + environment + " environment");
        System.out.println("**");
        System.out.println("**   dbname:" + "                   " + config.get("dbname"));
        System.out.println("**   host:" + "                     " + config.get("host"));
        System.out.println("**   application.name:" + "         " + config.get("application.name"));
        System.out.println("**   application.port:" + "         " + config.get("application.port"));
        System.out.println("**   application.context-url:" + "  " + config.get("application.context-url"));
        System.out.println("**   mode:" + "                     " + config.get("mode"));
        System.out.println("**   theme:" + "                    " + config.get("theme"));
        System.out.println("**   pipeline:" + "                 " + config.get("pipeline"));
        System.out.println("*******************************************");
    }
}
