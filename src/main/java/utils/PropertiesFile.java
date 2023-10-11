package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertiesFile {

    public static Properties prop;

    public static String getProperties(String key) {
        prop = new Properties();
        try {
            Log.info("Loading Property file");
            prop.load(Files.newInputStream(Paths.get("./src/test/resources/config/devtest.properties")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop.getProperty(key);

    }





}
