package com.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class bankLoginPage {
    public bankLoginPage(WebDriver driver ){
        PageFactory.initElements(driver,this);//driver.findElement
    }
    @FindBy(css=".mainHeading")
    WebElement header ;
    @FindBy(xpath = "//button[.='Customer Login']")
    WebElement customerLogin;
    @FindBy(xpath = "//button[contains(text(),'Bank Manager')]")
    WebElement ManagerLogin;
    @FindBy(xpath = "//button[.='Home']")
    WebElement HomeButton;
    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement customerLoginButton;

    public void LoginPageComponentsValidation(String expectedHeader){
        Assert.assertEquals(BrowserUtils.getTest(header),expectedHeader);
        Assert.assertTrue(customerLogin.isDisplayed()&&customerLogin.isEnabled());
        Assert.assertTrue(ManagerLogin.isDisplayed()&&ManagerLogin.isEnabled());
    }
public void clickMangerButton(){

        ManagerLogin.click();
}
public void clickHomeButton(){
        HomeButton.click();
}
public void clickCustomerLoginButton(){
        customerLoginButton.click();
}

}
