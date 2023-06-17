package com.test.swagLabs.page;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.sql.rowset.BaseRowSet;

public class LoginPage {
    public LoginPage(WebDriver driver ) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement username ;
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement password;
    @FindBy(xpath = "//input[@type='submit']")
    WebElement loginButton;
     @FindBy(xpath = "//h3")
    WebElement errorMessage;

     //https://www.saucedemo.com/inventory.html

    public void loginFunc(String name ,String password ){
        username.sendKeys(name);
       this.password.sendKeys(password);
       loginButton.click();

    }
    public String  errorMessage(){
        return BrowserUtils.getTest(errorMessage);

    }
}
