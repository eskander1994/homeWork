package com.test.codefishNinja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegisterButton {
    public RegisterButton(WebDriver driver) {
        PageFactory.initElements(driver,this);

    }@FindBy(xpath = "//input[@name='givenName']")
    WebDriver name ;
    @FindBy(xpath = "//input[@name='familyName']")
    WebDriver familyName ;
    @FindBy(xpath = "//select[@id='gender-field']")
    WebDriver selectGander;//Male
    @FindBy(xpath = "//input[@name='birthdateDay']")
    WebDriver getBirthdayDay ;
    @FindBy(xpath = "//select[@name='birthdateMonth']")
    WebDriver  birthdayMonth ;//select
    @FindBy(xpath = "//input[@name='birthdateYear']")
    WebDriver getBirthdayYear ;
    @FindBy(xpath = "//input[@name='address1']")
    WebDriver address1 ;
    @FindBy(xpath = "//input[@name='cityVillage']")
    WebDriver cityVillage ;
    @FindBy(xpath = "//input[@name='stateProvince']")
    WebDriver state ;
    @FindBy(xpath = "//input[@name='country']")
    WebDriver country ;
    @FindBy(xpath = "//input[@name='postalCode']")
    WebDriver postalCode ;
    @FindBy(xpath = "//input[@name='phoneNumber']")
    WebDriver phoneNumber ;
    @FindBy(xpath = "//div[@id='dataCanvas']//p")
    List<WebDriver> allInfo ;
    @FindBy(xpath = "//input[@id='submit']")
    WebDriver submitButton ;








}
