package com.test.etsy.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class SearchPage {
    public SearchPage(WebDriver driver ) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a//h3")
    List<WebElement> itemTitles;

    public void verifySearchBar(String word1 ,String word2,String word3) throws InterruptedException {
        Thread.sleep(2000);
        for(int i=1;i<itemTitles.size();i++){
          String test = BrowserUtils.getTest(itemTitles.get(i)).toLowerCase();
          Assert.assertTrue(test.contains(word1)||test.contains(word2)||test.contains(word3));{

          }
        }
    }
}
