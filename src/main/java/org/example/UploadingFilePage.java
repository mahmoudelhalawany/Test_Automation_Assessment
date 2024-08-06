package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class UploadingFilePage {
    //driver
    private WebDriver driver;

    //Constructor
    public UploadingFilePage(WebDriver driver) {
        this.driver = driver;
    }

    //Elements
    By fileUploadButton = By.xpath("//a[@href=\"/upload\"]");
    By browseButton = By.xpath("//input[@id=\"file-upload\"]");
    By uploadButton = By.xpath("//input[@id=\"file-submit\"]");

    By uploadedFile = By.xpath("//div[@id=\"uploaded-files\"]");
    //Methods
    public void navigateToURL(String URL){
        driver.get(URL);
    }

    public void clickOnFileUpload () {
        driver.findElement(fileUploadButton).click();
    }

    public void uploadingFile (String filePath) {
        File uploadFile = new File(filePath);
        driver.findElement(browseButton).sendKeys(uploadFile.getAbsolutePath());
        driver.findElement(uploadButton).click();
    }

    //Assertion
    public boolean isUploadSuccessful(String fileName) {
        return driver.findElement(uploadedFile).getText().contains(fileName);
    }

}
