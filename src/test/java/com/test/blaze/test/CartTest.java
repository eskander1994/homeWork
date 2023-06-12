package com.test.blaze.test;

import com.test.blaze.page.CartPage;
import com.test.blaze.page.LapTopsPage;
import com.test.blaze.page.MacBookPro;
import com.test.blaze.page.MainPage;
import org.testng.annotations.Test;

public class CartTest extends blazeTestBase {
    @Test
    public void ValidateTile() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.selectFromCategories("laptops");
        LapTopsPage lapTopsPage = new LapTopsPage(driver);
        lapTopsPage.SelectLapTops(driver,"MacBook Pro");
        MacBookPro macBookPro = new MacBookPro(driver);
        macBookPro.validateMacBookInf();
        macBookPro.validateAddButton(driver,"Product added");
        macBookPro.cartButton();
        CartPage cartPage = new CartPage(driver);
        cartPage.Title("MacBook Pro","1100");
        cartPage.placeOrderFunctionality("eskander","usa","des plaines","1234567","08","23","Thank you for your purchase!");
    }
}
