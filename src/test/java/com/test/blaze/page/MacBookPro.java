package com.test.blaze.page;

import Utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MacBookPro {
    public MacBookPro(WebDriver driver ) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h2[@class='name']")
    WebElement lopTopName;
   @FindBy(xpath = "//h3[@class='price-container']")
    WebElement LopTopPrice;
   @FindBy(xpath = "//div[@id='more-information']")
    WebElement descriptions ;
    @FindBy(xpath = "//a[@onclick='addToCart(15)']")
    WebElement addButton;
    @FindBy(xpath = "//a[@id='cartur']")
    WebElement cartButton;
   public void validateMacBookInf(){/// you can out them as expect and add me in main page
       Assert.assertEquals(BrowserUtils.getTest(lopTopName),"MacBook Pro");
       Assert.assertEquals(BrowserUtils.getTest(LopTopPrice),"$1100 *includes tax");
       Assert.assertEquals(BrowserUtils.getTest(descriptions),"Product description\n" +
               "Apple has introduced three new versions of its MacBook Pro line, including a 13-inch and 15-inch model with the Touch Bar, a thin, multi-touch strip display that sits above the MacBook Pro's keyboard.");

   }
    public void validateAddButton(WebDriver driver,String expect ) throws InterruptedException {
        addButton.click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),expect);
        alert.accept();
    }
    public void cartButton(){
       cartButton.click();
    }
    public void  addButton(){
       addButton.click();
    }

}
