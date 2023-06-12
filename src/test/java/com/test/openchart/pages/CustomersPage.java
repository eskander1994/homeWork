package com.test.openchart.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomersPage {
    public CustomersPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//a[@aria-label='Add New']")
    WebElement addNewCustomer;
        @FindBy(xpath = "//input[@name='firstname']")
    WebElement firstName;
        @FindBy(xpath = "//input[@name='lastname']")
    WebElement lastName;
        @FindBy(xpath = "//input[@name='email']")
    WebElement email;
        @FindBy(xpath = "//input[@name='password']")
    WebElement passWord;
        @FindBy(xpath = "//input[@name='confirm']")
    WebElement confirmPassWord;
        @FindBy(xpath = "//input[@name='newsletter']")
        WebElement newsletter;
        @FindBy(xpath = "//input[@name='status']")
        WebElement status;
        @FindBy(xpath = "//input[@name='safe']")
        WebElement safe;
        @FindBy(xpath = "//button[@data-bs-original-title='Save']")
        WebElement saveButton;
        @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
        WebElement WarningText;



    public void AddNewCustomer(WebDriver driver ,String firstName, String lastName , String email, String passWord, String confirmPassWord) throws InterruptedException {
    addNewCustomer.click();
    this.firstName.sendKeys(firstName);
    this.lastName.sendKeys(lastName);
    this. email.sendKeys(email);
    this.passWord.sendKeys(passWord);
    this. confirmPassWord.sendKeys(confirmPassWord);
        BrowserUtils.scrollWithJS(driver,newsletter);
        Thread.sleep(3000);
    if(!newsletter.isSelected()){
    newsletter.click();
    }
    if(!status.isSelected()){
            status.click();
        }
    if(safe.getCssValue("background-color").equals("rgba(255, 255, 255, 1)")){
            safe.click();
        }
        BrowserUtils.scrollWithJS(driver,saveButton);
    Thread.sleep(1000);
    saveButton.click();
Thread.sleep(1000);
}
public String WrongText(){
     return    BrowserUtils.getTest(WarningText);
}

}
