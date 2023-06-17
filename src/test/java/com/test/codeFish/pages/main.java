package com.test.codeFish.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class main {
    public main(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(linkText = "Codefish")
    WebElement mainTile;
    @FindBy(xpath = "//h5")
    List<WebElement> itemTitles;
    @FindBy(xpath = "//div[@class='card-body']//button")
    List<WebElement> addToCartButton;
    @FindBy(xpath = "//a[.='Cart']")
    WebElement cartButton;


public String mainPageTitle(){
    return BrowserUtils.getTest(cartButton);



}


public void addItemToCart(WebDriver driver ,String itemName){
    for(int i=0;i<itemTitles.size();i++){
        if(BrowserUtils.getTest(itemTitles.get(i)).equals(itemName)){
         BrowserUtils.clickWithJS(driver,addToCartButton.get(i));
            break;
        }
    }
}
public void ClickCartButton(){
    cartButton.click();
}
}
