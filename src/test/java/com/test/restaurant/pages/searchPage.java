package com.test.restaurant.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class searchPage {
    public searchPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "//input[@id='starRating_score_4Star']")
    WebElement starRating4AndMore;
    @FindBy(xpath = "//div[contains(text(),'Editor')]")
    WebElement editorChoiceBox;
    @FindBy(xpath = "//span[@class='card__underline']")
    WebElement itemName;
  public void validateItemWithFilterAdd(String expectItemName) throws InterruptedException {
      if(starRating4AndMore.isDisplayed()&&!starRating4AndMore.isSelected()){
          starRating4AndMore.click();
      }
      if(editorChoiceBox.isDisplayed()&&!editorChoiceBox.isSelected()){
          editorChoiceBox.click();
      }
      Thread.sleep(1000);
      Assert.assertEquals(BrowserUtils.getTest(itemName),expectItemName);
  }
}
