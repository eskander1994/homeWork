package com.test.blaze.page;

import Utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class LapTopsPage {
    public LapTopsPage(WebDriver driver ) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@class='hrefch']")
    List<WebElement> lapTops;

    public void SelectLapTops(WebDriver driver ,String LaptopName) throws InterruptedException {
        Thread.sleep(2000);
        for(WebElement lap:lapTops){
            if(BrowserUtils.getTest(lap).equalsIgnoreCase(LaptopName)){

                BrowserUtils.scrollWithJS(driver , lap);
                lap.click();
                break;
            }

        }
    }

}
