package com.test.codeFish.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class cartPage {

    public cartPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//tbody//tr//td[2]")
    List<WebElement> itemsTitlesInCartPage;


    public void validateItemInCart(String expect){
        for(WebElement item:itemsTitlesInCartPage){

            Assert.assertEquals(BrowserUtils.getTest(item),expect);

        }
    }
}
