package org.fasttrackittest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.Header;
import pageobjects.ProductsGrid;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class SearchTest extends TestBase {
    @Test
    //annotarea Test din pachetul org.junit, biblioteca junit se va ocupa de aceasta metoda va face ca testul sa poata fi "run"(executat)
    public void simpleSearchWithOneKeyword() {

        //Chrome and Login test script
System.setProperty("webdriver.chrome.driver", AppConfig.getChromeDriverPath());
        WebDriver driver = new ChromeDriver();

        driver.get(AppConfig.siteUrl());
//        driver.get("http://testfasttrackit.info/selenium-test/");
        String searchKeyword = "vase";

        Header header = PageFactory.initElements(driver, Header.class);
        header.search(searchKeyword);
        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);
        for (WebElement productNameElement : productsGrid.getProductNames()){
            assertThat("Some of the returned product's names do not contain the searched keyword.",
                    productNameElement.getText(),
                    containsString(searchKeyword.toUpperCase()));
        }

        List<WebElement> productNames = driver.findElements(By.cssSelector(".product-name > a"));

        System.out.println("Stored " + productNames.size() + " product-name a");


        for (WebElement productName : productNames) {
            assertThat("Some of the product's names do not contain the searched keyword.",
                    productName.getText(), containsString(searchKeyword.toUpperCase()));

        }
    }
}
