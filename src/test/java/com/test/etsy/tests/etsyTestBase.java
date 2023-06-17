package com.test.etsy.tests;

import Utils.BrowserUtils;
import Utils.DriverHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class etsyTestBase {
    public WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= DriverHelper.getDriver();
        driver.navigate().to("https://www.etsy.com/?source=aw&utm_source=affiliate_window&utm_medium=affiliate&utm_campaign=us_location_buyer&utm_content=578983&utm_term=0&awc=6220_1686789043_48430c000371ef6f25a1eefe785c891b");
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult){
        if(!iTestResult.isSuccess()){
            BrowserUtils.getScreenShot(driver,"blazePictures");
        }
        driver.quit();
    }
}
