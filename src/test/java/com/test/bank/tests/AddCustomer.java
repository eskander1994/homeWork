package com.test.bank.tests;

import Utils.ConfigReader;
import com.test.bank.pages.BankMangerPage;
import com.test.bank.pages.bankLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddCustomer  extends BankTestBase{
    @Test
    public void validateAddCustomer() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        bankLoginPage bankLoginPage = new bankLoginPage(driver);
        bankLoginPage.clickMangerButton();
        BankMangerPage bankMangerPage = new BankMangerPage(driver);
        bankMangerPage.addCustomerFunctionality(driver, "Eskander", "Eskander", "123456",
                "Customer added successfully with customer");

    }

    @Test
    public void validateOpenCustomerFunctionality() throws InterruptedException {

        bankLoginPage bankLoginPage = new bankLoginPage(driver);
        bankLoginPage.clickMangerButton();
        BankMangerPage bankMangerPage = new BankMangerPage(driver);
        bankMangerPage.addCustomerFunctionality(driver, "Eskander", "Eskander", "123456",
                "Customer added successfully with customer");
        bankMangerPage.openAccountFunctionality(driver,"6","Dollar",
                "Account created successfully");



    }
@Test
public void validateCustomerFunctionality() throws InterruptedException {
//    WebDriverManager.chromedriver().setup();
  //  ChromeOptions options = new ChromeOptions();
   // options.addArguments("--remote-allow-origins=*");
    //WebDriver driver = new ChromeDriver(options);
//    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  //  driver.manage().window().maximize();
    //driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

    bankLoginPage bankLoginPage = new bankLoginPage(driver);
    bankLoginPage.clickMangerButton();
    BankMangerPage bankMangerPage = new BankMangerPage(driver);
    bankMangerPage.addCustomerFunctionality(driver, ConfigReader.readProperty("QA_openChart_firstname"), "QA_openChart_lastname", "QA_postcode",
            "QA_alertmassage");
    bankMangerPage.openAccountFunctionality(driver,"Eskander Eskander","Dollar",
            "Account created successfully with account Number ");
    bankMangerPage.customerFunctionality("Eskander","Eskander","123456");

}

}
