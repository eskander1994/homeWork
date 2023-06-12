package com.test.blaze.page;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartPage {
    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//tr[@class='success']//td")
    List<WebElement> titles;
    @FindBy(xpath = "//button[@class='btn btn-success']")
    WebElement placeOrderButton;
@FindBy(xpath = "//input[@id='name']")
WebElement inputName;
@FindBy(xpath = "//input[@id='country']")
WebElement inputCountry;
@FindBy(xpath = "//input[@id='city']")
WebElement inputCity;
@FindBy(xpath = "//input[@id='card']")
WebElement inputCard;
@FindBy(xpath = "//input[@id='month']")
WebElement inputMonth;
@FindBy(xpath = "//input[@id='year']")
WebElement inputYear;
@FindBy(xpath = "//button[@onclick='purchaseOrder()']")
WebElement purchaseButton;
    @FindBy(xpath = "//div[@class='sweet-alert  showSweetAlert visible']//h2")
    WebElement successMessage;
    public void Title(String lapTopName ,String price  ){
      List<String > list = Arrays.asList("",lapTopName,price,"");
        for(int i=1;i<titles.size()-1;i++){
            Assert.assertEquals(BrowserUtils.getTest(titles.get(i)),list.get(i));
        }
    }
    public void placeOrderFunctionality(String name,String country,String city,String cardNamber,String month,String Year,String expectSuccessMessage){
        placeOrderButton.click();
        inputName.sendKeys(name);
        inputCountry.sendKeys(country);
        inputCity.sendKeys(city);
        inputCard.sendKeys(cardNamber);
        inputMonth.sendKeys(month);
        inputYear.sendKeys(Year);
        purchaseButton.click();
        Assert.assertEquals(BrowserUtils.getTest(successMessage),expectSuccessMessage);


    }

}
