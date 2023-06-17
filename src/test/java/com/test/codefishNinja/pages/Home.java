package com.test.codefishNinja.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Home {
    public Home(WebDriver driver ){
        PageFactory.initElements(driver , this);
    }
    @FindBy(tagName = "h4")
    WebElement header;
    @FindBy(xpath = "//span[@id='selected-location']")
    WebElement selectedLocation;
    @FindBy(xpath = "//ul[@class='select']//li")
    List<WebElement> changeLocations;
    @FindBy(xpath = "//div[@class='logo']")
    WebElement openMRS;
    @FindBy(xpath = "//i[@class='icon-search']")
    WebElement findPatientRecord;
    @FindBy(xpath = "//a//i[@class='icon-user']")
    WebElement registerButton;

    public void clickOpenMRS(){
    openMRS.click();
}
public String header(){
    return BrowserUtils.getTest(header);

}
public String location(){
    return BrowserUtils.getTest(selectedLocation);
}

public void changeLocation(String location) throws InterruptedException {
    selectedLocation.click();
    Thread.sleep(1000);
for(WebElement loc:changeLocations){
    if(BrowserUtils.getTest(loc).equals(location)){
        loc.click();
    }
}
}
    public void clickFindPatient(){
findPatientRecord.click();
    }
public void clickRegisterButton(){
        registerButton.click();
}
}
