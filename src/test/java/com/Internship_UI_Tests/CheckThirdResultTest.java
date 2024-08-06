package com.Internship_UI_Tests;

import org.example.CheckThirdResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckThirdResultTest {
    private WebDriver driver;
    private CheckThirdResultPage checkThirdResultPage;
    private JavascriptExecutor js;
    private String URL = "https://www.google.com/ncr";
    private String searchText = "Selenium Webdriver";
    private By thirdSearchResult = By.xpath("//div[@class=\"MjjYud\"][3]//div[@class=\"kb0PBd cvP2Ce A9Y9g\"]");
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        checkThirdResultPage = new CheckThirdResultPage(driver);
        js = (JavascriptExecutor) driver;
        checkThirdResultPage.navigateToURL(URL);
    }

    @Test
    public void search() {
        checkThirdResultPage.fillSearchField(searchText);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        js.executeScript("window.scrollBy(0,800)");
        Assert.assertTrue(driver.findElement(thirdSearchResult).getText().contains("What is Selenium WebDriver"));

    }

    @AfterMethod
    public void tearDown () {
        driver.quit();
    }
}