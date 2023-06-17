package com.test.swagLabs.test;

import Utils.ConfigReader;
import com.test.blaze.page.LapTopsPage;
import com.test.swagLabs.page.LoginPage;
import com.test.swagLabs.page.MainPage;
import org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner;
import org.testng.annotations.Test;

public class validateAllItemsMainPage extends testBase {



    @Test (dataProvider = "item",dataProviderClass = NameAndPasswordData.class)
    public void validateItem(String itemName ,String expectHeader,String expectItemIfo,String expectItemPrice) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFunc(ConfigReader.readProperty("QA_login_username"),ConfigReader.readProperty("QA_login_password"));
        MainPage mainPage = new MainPage(driver);
        mainPage.findItemInventory(itemName,expectHeader,expectItemIfo,expectItemPrice);
    }
}
