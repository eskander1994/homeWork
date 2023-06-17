package com.test.codeFish.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    public Login(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@name='username']")
    WebElement userName;
    @FindBy(xpath = "//input[@name='password']")
    WebElement passWord;
    @FindBy(xpath = "//button[.='Register']")
    WebElement registerButton;
    @FindBy(xpath = "//button[.='Login']")
    WebElement loginButton;

    public void HappyPathRegister(String name ,String password) throws InterruptedException {
        userName.clear();
        passWord.clear();
        registerButton.click();
        userName.sendKeys(name);
        passWord.sendKeys(password);
        registerButton.click();
        Thread.sleep(2000);
        userName.clear();
        Thread.sleep(2000);
        userName.sendKeys(name);
        passWord.clear();
        Thread.sleep(2000);
        passWord.sendKeys(password);
        loginButton.click();
    }
    public void loginFunc(String name ,String password){
        userName.clear();
        userName.sendKeys(name);
        passWord.clear();
        passWord.sendKeys(password);
        loginButton.click();
    }

}
