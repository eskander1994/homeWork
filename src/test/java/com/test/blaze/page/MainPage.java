package com.test.blaze.page;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {
    public MainPage(WebDriver driver ) {
        PageFactory.initElements(driver ,this);
    }
    @FindBy(xpath = "//a[@id='itemc']")
    List<WebElement> categories ;

    public void selectFromCategories(String selectItem){
        for(WebElement item:categories){
            if(BrowserUtils.getTest(item).equalsIgnoreCase(selectItem)){
                item.click();
            }
        }
    }
}
