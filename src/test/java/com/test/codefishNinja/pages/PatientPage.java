package com.test.codefishNinja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientPage {
    public PatientPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[@class='PersonName-givenName']")
    WebDriver firstNameNewCustomer ;
    @FindBy(xpath = "//div[@class='identifiers']//span")
    WebDriver ideaNewCustomer ;
}
