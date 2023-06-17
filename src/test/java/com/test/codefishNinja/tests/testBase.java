package com.test.codefishNinja.tests;

import Utils.BrowserUtils;
import Utils.DriverHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class testBase {
    public WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= DriverHelper.getDriver();
        driver.navigate().to("http://codefish.ninja/openmrs/login.htm");
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult){
        if(!iTestResult.isSuccess()){
            BrowserUtils.getScreenShot(driver,"homeWorkPictures");
        }
      //  driver.quit();
    }
}
