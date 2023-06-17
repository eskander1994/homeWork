package com.test.bank.tests;

import com.test.bank.pages.bankLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankLoginTest {
    @Parameters("expectHeader")
    @Test
    public void ValidateLoginPageComponents(String expectHeader){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        bankLoginPage bankLoginPage = new bankLoginPage(driver);
        bankLoginPage.LoginPageComponentsValidation(expectHeader);

    }


}
