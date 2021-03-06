package org.fasttrackittest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
    private static Properties properties = new Properties();
    static{
        InputStream inputStream = AppConfig.class.getClassLoader().getResourceAsStream("production.properties") ;
        try{
            properties.load(inputStream);
        }catch (IOException e){
            System.out.println("Failed to load properties from configuration file");
        }
    }
    private static String chromeDriverPath = properties.getProperty("chrome.driver.path");
    private static String geckoDriverPath = (String) properties.get("gecko.driver.path");
    private static String siteUrl = properties.getProperty(properties.getProperty("site.url"));

    public static String getChromeDriverPath() {
        return chromeDriverPath;
    }
   // public static String getGeckoDriverPath() {  return geckoDriverPath; }
    public static String siteUrl()         {  return properties.getProperty("site.url");    }

    public static String getGeckoDriverPath() {
        return geckoDriverPath;
    }
   // public static String siteUrl()         {  return properties.getProperty("site.url");    }
}
