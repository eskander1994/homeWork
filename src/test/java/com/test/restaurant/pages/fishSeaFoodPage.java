package com.test.restaurant.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class fishSeaFoodPage {
    public fishSeaFoodPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@id='mntl-document-spotlight_1-0']")
    WebElement searchBraView;
    @FindBy(xpath = "//form[@action='/search/']//button[@type='submit']")
    WebElement searchButtonLikeToCoke;
    @FindBy (xpath = "//input[@id='search-form-input']")
    WebElement findRecipeSearchBra;
public void searchBarFunctionality(WebDriver driver,String itemName) throws InterruptedException {
    Thread.sleep(2000);
    BrowserUtils.scrollWithJS(driver,searchBraView);
    Thread.sleep(2000);
    findRecipeSearchBra.sendKeys(itemName);
    Thread.sleep(1000);
    searchButtonLikeToCoke.click();
}
}
