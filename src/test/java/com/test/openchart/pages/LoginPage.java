package com.test.openchart.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@name='username']")
    WebElement userName;
    @FindBy(xpath = "//input[@name='password']")
    WebElement passWord;
    @FindBy(tagName = "title")
    WebElement header;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement noMatchText;
    public void loginFunc(String name ,String passWord) throws InterruptedException {
        userName.sendKeys(name);
        this.passWord.sendKeys(passWord);
        loginButton.click();
        Thread.sleep(2000);
    }
    public String  wrongMassage(){
       return  BrowserUtils.getTest(noMatchText);
    }
    public void  test(){

    }



}
