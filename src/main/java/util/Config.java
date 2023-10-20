package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final String SETUP_PROPERTIES = "/application.properties";

    private static final Properties properties;

    static {
        properties = new Properties();
        InputStream inputStream = Config.class.getResourceAsStream(SETUP_PROPERTIES);
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getConfigValue(String key) {


        return ((System.getProperty(key) == null) ? properties.getProperty(key) : System.getProperty(key));
    }
}
