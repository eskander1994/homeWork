package com.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class BankMangerPage {
    public BankMangerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
        WebElement addCustomerButton;
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitAddCustomer;
    @FindBy(xpath = "//button[contains(text(),'Open Account')]")
    WebElement openAccountButton;
    @FindBy(css="#userSelect")
    WebElement customerName;
    @FindBy(css="#currency")
    WebElement currency;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement processButton;
    @FindBy(xpath = "//button[contains(text(),'Customers')]")
    WebElement customerButton;
    @FindBy(tagName = "input")
    WebElement searchBox;
    @FindBy(xpath = "//td[@class='ng-binding']")
    List<WebElement> allInformation;
    public void addCustomerFunctionality(WebDriver driver ,String firstName,String lastName,String postCode,String expectedMessage){
        addCustomerButton.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postCode.sendKeys(postCode);
        submitAddCustomer.submit();
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(expectedMessage));
        alert.accept();
    }
    public void openAccountFunctionality(WebDriver driver , String name, String  currency, String alertMessage ) throws InterruptedException {
        openAccountButton.click();
        Thread.sleep(1000);
        BrowserUtils.selectBy(customerName,name.trim() ,"index");
        BrowserUtils.selectBy(this.currency,currency,"value");
        processButton.click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(alertMessage));
        alert.accept();
    }
    public void  customerFunctionality(String customerName , String lastname ,String postCode ){
        customerButton.click();
        searchBox.sendKeys(customerName);
        List<String> expectedNames = Arrays.asList(customerName,lastname,postCode);
        for(int i=0;i<allInformation.size();i++){
            Assert.assertEquals(BrowserUtils.getTest(allInformation.get(i)),expectedNames.get(i));
        }
    }
}
