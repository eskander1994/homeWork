package com.test.restaurant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class mainPage {
    public mainPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[.='Ingredients']")
    WebElement ingredientsButton;
    @FindBy(xpath = "//a[.='Fish & Seafood']")
    WebElement fishSeaFoodButton;
public void clickFishSeaFood(WebDriver driver){
    Actions actions = new Actions(driver);
    actions.moveToElement(ingredientsButton).perform();
    fishSeaFoodButton.click();
}
}
