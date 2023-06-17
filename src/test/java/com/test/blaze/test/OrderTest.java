package com.test.blaze.test;

import TestNG.AllDataPractice;
import com.test.blaze.page.CartPage;
import com.test.blaze.page.LapTopsPage;
import com.test.blaze.page.MacBookPro;
import com.test.blaze.page.MainPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrderTest extends blazeTestBase {
  @Parameters({"selectItem", "lapTop", "expectProduct", "userName", "country", "city", "cardNumber", "month", "year", "expectSuccessMessage", "expectUrl"})
    @Test(dataProvider = "orderDate" ,dataProviderClass = BlazeData.class)
    public void ValidateOrder(String selectItem, String lapTop, String expectProduct, String userName, String country, String city
            , String cardNumber, String month, String year, String expectSuccessMessage, String expectUrl) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.selectFromCategories(selectItem);
        LapTopsPage lapTopsPage = new LapTopsPage(driver);
        lapTopsPage.SelectLapTops(driver, lapTop);
        MacBookPro macBookPro = new MacBookPro(driver);
        //macBookPro.validateMacBookInf();
       // macBookPro.validateAddButton(driver, expectProduct);
        macBookPro.cartButton();
        CartPage cartPage = new CartPage(driver);
        cartPage.placeOrderFunctionality(userName, country, city, cardNumber, month, year, expectSuccessMessage);

        Assert.assertEquals(driver.getCurrentUrl(), expectUrl);
    }

    @Test(dataProvider = "orderDate" ,dataProviderClass = BlazeData.class)
    public void ValidateOrder2(String selectItem, String lapTop, String expectProduct, String userName, String country, String city
            , String cardNumber, String month, String year, String expectSuccessMessage, String expectUrl) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.selectFromCategories(selectItem);
        LapTopsPage lapTopsPage = new LapTopsPage(driver);
        lapTopsPage.SelectLapTops(driver, lapTop);
        MacBookPro macBookPro = new MacBookPro(driver);
     //   macBookPro.validateMacBookInf();
     //   macBookPro.validateAddButton(driver, expectProduct);

        macBookPro.cartButton();
        CartPage cartPage = new CartPage(driver);
     // cartPage.Title("MacBook Pro", "1100");
        cartPage.placeOrderFunctionality(userName, country, city, cardNumber, month, year, expectSuccessMessage);
        Assert.assertEquals(driver.getCurrentUrl(), expectUrl);
        //test not finish you need to click on and find url of the page

    }
}
