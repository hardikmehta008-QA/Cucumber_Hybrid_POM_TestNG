package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    /*
     * Loads properties from src/test/resources/config/config.properties and returns a Properties object.
     * Uses a simple file close in finally block to avoid leaving the stream open.
     */
    private Properties prop;
    public Properties init_prop() {
        prop = new Properties();
        FileInputStream ip = null;
        try {
            ip = new FileInputStream(".\\src\\test\\resources\\config\\config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            // Prefer logging the error so test runners can see why config failed to load.
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ip != null) {
                try {
                    ip.close();
                } catch (IOException ignore) {
                }
            }
        }
        return prop;
    }
}
