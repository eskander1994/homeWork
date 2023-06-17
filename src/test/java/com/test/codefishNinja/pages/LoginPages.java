package com.test.codefishNinja.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPages {

    public LoginPages(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='username']")
    WebElement userName;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;
    @FindBy(xpath = "//ul//li")
    List<WebElement> locationsSession;
    @FindBy(xpath = "//input[@id='loginButton']")
    WebElement logInButton;

    public void loginAndSelectLocations(String username,String passWord,String location) throws InterruptedException {
        userName.sendKeys(username);
        password.sendKeys(passWord);
        for(WebElement loc:locationsSession){
            if(BrowserUtils.getTest(loc).equals(location)){
                loc.click();
            }
        }
        logInButton.click();
    }


}



