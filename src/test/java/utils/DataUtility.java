package utils;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class DataUtility {
    private static String path = "src/test/resources/data.properties";

    public static void setPropertyValue(String key, String value) {
        try {
            FileInputStream fin = new FileInputStream(path);
            Properties prop = new Properties();
            prop.load(fin);
            prop.setProperty(key, value);
            prop.store(new FileWriter(path), "response data");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getPropertyValue(String key) {
        String value = null;
        try {
            FileInputStream fin = new FileInputStream(path);
            Properties prop = new Properties();
            prop.load(fin);
            value = prop.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static void removePropertyValue(String key) {
        try {
            FileInputStream fin = new FileInputStream(path);
            Properties prop = new Properties();
            prop.load(fin);
            prop.remove(key);
            prop.store(new FileWriter(path), "Removed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
