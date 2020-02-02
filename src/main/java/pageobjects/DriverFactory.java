package pageobjects;

import org.fasttrackittest.AppConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static WebDriver driver;
    public static WebDriver initDriver (String browser){
        switch (browser.toLowerCase()){
            default:
            case "chrome":
                System.setProperty("webdriver.chrome.driver",
                        AppConfig.getChromeDriverPath());
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver",AppConfig.getGeckoDriverPath());
                driver = new FirefoxDriver();
                break;
        }
        return driver;
    }
    public static WebDriver getDriver(){
        return driver;

    }
}
