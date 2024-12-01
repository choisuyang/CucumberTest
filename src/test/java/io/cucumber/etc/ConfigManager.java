//package io.cucumber.etc;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Properties;
//
//public class ConfigManager {
//    private static ConfigManager instatnce;
//
//    private Properties properties;
//
//    private ConfigManager() {
//        properties = new Properties();
//        loadProperties();
//    }
//
//    public static ConfigManager getInstance() {
//        if (instatnce == null) {
//            synchronized (ConfigManager.class) {
//                if (instatnce == null) {
//                    instatnce = new ConfigManager();
//                }
//            }
//        }
//        return instatnce;
//    }
//
//    private void loadProperties() {
//        String configFilePath = "src/test/resources/webconfig.properties";
//        try (FileInputStream inputStream = new FileInputStream(configFilePath)) {
//            properties.load(inputStream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public String getProperty(String key) {
//        return properties.getProperty(key);
//    }
//}
