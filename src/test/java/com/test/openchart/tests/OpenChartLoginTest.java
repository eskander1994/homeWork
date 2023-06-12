package com.test.openchart.tests;

import com.test.openchart.pages.CustomersPage;
import com.test.openchart.pages.LoginPage;
import com.test.openchart.pages.mainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenChartLoginTest extends OpenChartTestBase  {
    @Test
    public void happyPathLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFunc("demo","demo");
        Assert.assertEquals(driver.getTitle(),"Dashboard");
    }
    @Test
    public void negativeLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFunc("eqeq","fsfsd");
        Assert.assertEquals(loginPage.wrongMassage(),"No match for Username and/or Password.");

    }
    @Test
    public void negativeAddNewCustomer() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFunc("demo","demo");
        mainPage mainPage = new mainPage(driver);
        mainPage.closerPopUp();
        mainPage.getCustomersPage();
       CustomersPage customersPage = new CustomersPage(driver);
        customersPage.AddNewCustomer(driver ,"eskander","eskander",
                "eskander@gmail.com","asde","asde");
        Assert.assertEquals(customersPage.WrongText(),"Warning: You do not have permission to modify customers!");


    }

}
