package com.test.openchart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class mainPage {
    public mainPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li//i[@class='fas fa-user']")
    WebElement customerMain;
    @FindBy(xpath = "//div[@class='modal-content']//button[@data-bs-dismiss='modal']")
    WebElement closePopUp;

    @FindBy(xpath = "//ul[@class='collapse show']//a[.='Customers']")
    WebElement customers ;
    public void closerPopUp(){
        closePopUp.click();
    }
    public void getCustomersPage(){
        customerMain.click();
        customers.click();
    }


}