package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //Constructor
    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    //Elements
    By dynamicLoadingButton = By.xpath("//a[@href=\"/dynamic_loading\"]");
    By exampleTwoButton = By.xpath("//a[@href=\"/dynamic_loading/2\"]");
    By startButton = By.xpath("//div[@id=\"start\"]//button");
    By loadingText = By.xpath("//div[@id=\"loading\"]");
    By helloWorldText = By.xpath("//div[@id=\"finish\"]//h4");

    //Methods
    public void navigateToURL(String URL){
        driver.get(URL);
    }

    public void clickOnDynamicLoading () {
        driver.findElement(dynamicLoadingButton).click();
    }

    public void clickOnExampleTwo () {
        driver.findElement(exampleTwoButton).click();
    }

    public void clickOnStart () {
        driver.findElement(startButton).click();
    }

    public void waitingForHelloWorld () {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement waitingHelloWorld = driver.findElement(loadingText);
        wait.until(ExpectedConditions.invisibilityOf(waitingHelloWorld));
    }

}
