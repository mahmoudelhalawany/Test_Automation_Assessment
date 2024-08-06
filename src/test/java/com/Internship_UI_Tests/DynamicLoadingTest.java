package com.Internship_UI_Tests;

import org.checkerframework.dataflow.qual.AssertMethod;
import org.example.DynamicLoadingPage;
import org.example.UploadingFilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.time.Duration;

public class DynamicLoadingTest {
    private WebDriver driver;
    private DynamicLoadingPage dynamicLoadingPage;
    private String url ="https://the-internet.herokuapp.com/" ;
    //private WebDriverWait wait;

    private By helloWorldText = By.xpath("//div[@id=\"finish\"]//h4");

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        //wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        dynamicLoadingPage = new DynamicLoadingPage(driver);
        dynamicLoadingPage.navigateToURL(url);
    }

    @Test
    public void dynamicLoading () {
        dynamicLoadingPage.clickOnDynamicLoading();
        dynamicLoadingPage.clickOnExampleTwo();
        dynamicLoadingPage.clickOnStart();
        dynamicLoadingPage.waitingForHelloWorld();
        Assert.assertTrue(driver.findElement(helloWorldText).isDisplayed());
    }



    @AfterMethod
    public void tearDown () {
        driver.quit();
    }
}
