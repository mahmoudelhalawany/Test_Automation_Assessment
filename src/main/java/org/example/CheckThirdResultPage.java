package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CheckThirdResultPage {
    //driver
    private WebDriver driver;

    //Constructor
    public CheckThirdResultPage(WebDriver driver) {
        this.driver = driver;
    }

    //Elements
    private By searchField = By.xpath("//textarea[@id=\"APjFqb\"]");


    //Methods
    public void navigateToURL(String URL){
        driver.get(URL);
    }

    public void fillSearchField (String searchText ) {
        driver.findElement(searchField).sendKeys(searchText);
        driver.findElement(searchField).sendKeys(Keys.ENTER);
    }

}
