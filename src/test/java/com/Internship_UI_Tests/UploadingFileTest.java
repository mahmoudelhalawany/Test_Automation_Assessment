package com.Internship_UI_Tests;

import org.example.CheckThirdResultPage;
import org.example.UploadingFilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UploadingFileTest {
    private WebDriver driver;

    private UploadingFilePage uploadingFilePage;

    private String url = "https://the-internet.herokuapp.com/" ;
    private String filePath = "C:\\Users\\LENOVO\\Downloads\\Snoop-dog-high-meme-5.jpg" ;
    private String fileName = "Snoop-dog-high-meme-5.jpg" ;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        uploadingFilePage = new UploadingFilePage(driver);
        uploadingFilePage.navigateToURL(url);
    }

    @Test
    public void uploadingFile () {
        uploadingFilePage.clickOnFileUpload();
        uploadingFilePage.uploadingFile(filePath);
    }

    public void checkTheUploadedFile () {
        uploadingFilePage.isUploadSuccessful(fileName);
    }

    @AfterMethod
    public void tearDown () {
        driver.quit();
    }


}
