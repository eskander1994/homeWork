package com.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class customer {
    public customer(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//select[@name='userSelect']")
    WebElement yourName;
    @FindBy(xpath = "//button[.='Login']")
    WebElement loginButton;
    @FindBy(xpath = "//div[@class='borderM box padT20 ng-scope']//strong[contains(text(),'Welcome')]")
    WebElement header;
    @FindBy(xpath = "//button[@ng-click='deposit()']")
    WebElement depositButton;
    @FindBy(xpath = "//input[@type='number']")
    WebElement amountBra;
    @FindBy(xpath = "//button[contains(text(),'Withdrawl')]")
    WebElement withdraw;
    @FindBy(xpath = "//span[@ng-show='message']")
    WebElement successMessage;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;

    @FindBy(xpath = "//div[@class='center']//strong[2]")
    WebElement balance;
    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    WebElement transactions;
   @FindBy(xpath = "//tr[@id='anchor0']//td[2]")
   WebElement depositAmount;
   @FindBy(xpath = "//tr[@id='anchor1']//td[2]")
   WebElement withdrawAmount;
    public void loginFunctionality(String number , String expectMessage){
        BrowserUtils.selectBy(yourName,number,"index");
        loginButton.click();
        Assert.assertEquals(BrowserUtils.getTest(header),expectMessage);
    }

   public  void depositFunctionality(String amount,String expectMessage){
        depositButton.click();
        amountBra.sendKeys( amount );
       submitButton.click();
       Assert.assertEquals(BrowserUtils.getTest(successMessage),expectMessage);

   }
   public void WithDrawFunctionality(String amount,String expect) throws InterruptedException {
        withdraw.click();
        Thread.sleep(1000);
        amountBra.sendKeys(amount);
        submitButton.click();
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getTest(successMessage),expect);

   }
   public void transactionFunctionality() throws InterruptedException {
        int actualBalance = Integer.parseInt(BrowserUtils.getTest(balance));
        transactions.click();
        Thread.sleep(3000);
        int expectedBalance=Integer.parseInt(BrowserUtils.getTest(depositAmount))-
                Integer.parseInt(BrowserUtils.getTest(withdrawAmount));
        Assert.assertEquals(actualBalance,expectedBalance);
   }

}

