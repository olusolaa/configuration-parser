import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ConfigParser extends Environment{
    private String fileName;
    private Map<String, String> map = new HashMap<>();

    public ConfigParser() {
//        "/Users/a/Downloads/Task-Two-master";
        this("/Users/a/Downloads/Task-Two-master/src/config.txt");
    }

    public ConfigParser(String fileName) {
        this.fileName = fileName;
    }

    public ConfigParser(String[] args) {
        super();
    }

    private void parseConfigFile() {
        String line = "";
        try {
            FileReader file = new FileReader(fileName);
            BufferedReader br = new BufferedReader(file);
            while ( (line = br.readLine()) != null )
            {
                if(!line.contains("=") && !line.equals("")) {
                    String prefix = line.substring(1, line.length() - 1);
                    while ((line = br.readLine()) != null  && !line.isEmpty())
                        this.populate(prefix.concat("."), line, "=");
                } else if(!line.isEmpty()) this.populate("", line, "=");
            }
            loadEnvironment(map);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * populate this class map using underlay parameters
     * @param keyPrefix, prefix to be appended to map key
     * @param data, String to be splited
     * @param delimiter to split data
     */
    public void populate(String keyPrefix, String data, String delimiter) {
        String[] parts =  data.split(delimiter);
        String key = keyPrefix + parts[0].trim();
        if( !this.map.containsKey(key) ) this.map.put(key, parts[1]);
    }

    public String get(String key){
        this.parseConfigFile();
        return this.map.get(key);
    }

}
