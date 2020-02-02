package org.fasttrackittest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.DriverFactory;

public class TestBase {

    protected WebDriver driver;
    @Before
    public void beforeTest(){
        String browser =  System.getProperty("browser", "chrome");
        driver = DriverFactory.initDriver(browser);
    }
    @After
    public void afterTest() {
        driver.quit();

    }
}
