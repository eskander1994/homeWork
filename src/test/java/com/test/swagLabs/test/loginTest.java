package com.test.swagLabs.test;

import com.test.swagLabs.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class loginTest extends testBase {

    @Test(dataProvider ="login",dataProviderClass = NameAndPasswordData.class)
    public void happyPathLogin(String name,String password,String expectUrl){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFunc(name ,password);
        Assert.assertEquals(driver.getCurrentUrl(),expectUrl);
    }
    @Test(dataProvider ="naglogin",dataProviderClass = NameAndPasswordData.class)
    public void nagLogin(String name,String password,String errorMessage) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFunc(name ,password);
        Thread.sleep(1000);
        Assert.assertEquals(loginPage.errorMessage(),errorMessage);
    }

}
