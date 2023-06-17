package com.test.codefishNinja.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class FindPatientPage {

    public FindPatientPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tr//td[2]")
    List<WebElement> patientName;
    @FindBy(xpath = "//tr//td[1]")
    List<WebElement> patientIdentifier;

    public void checkPatientIdentifierUn(String name) {
        String temp = "";
        int num = 0;
        for (int i = 0; i < patientName.size(); i++) {
            if (BrowserUtils.getTest(patientName.get(i)).equals(name)) {
                temp = BrowserUtils.getTest(patientIdentifier.get(i));
            }
            for (int j = 0; j < patientIdentifier.size(); j++) {
                if (BrowserUtils.getTest(patientIdentifier.get(i)).equals(temp)) {
                    num++;
                }

            }
            Assert.assertTrue(num > 1);
        }
    }

    public void findNewPatientByName(String name) {
        for (int i = 0; i < patientName.size(); i++) {
            Assert.assertEquals(BrowserUtils.getTest(patientName.get(i)),name);
        }
    }
}
