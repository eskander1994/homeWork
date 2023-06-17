package com.test.codeFish.test;

import com.test.codeFish.pages.Login;
import com.test.codeFish.pages.cartPage;
import com.test.codeFish.pages.main;
import org.testng.annotations.Test;

public class Cart extends testBase {

    @Test
    public void cardFunctionality() throws InterruptedException {
        Login login = new Login(driver);
        login.loginFunc("Asko81","Asko22");
        main main = new main(driver);
        Thread.sleep(1000);
        main.addItemToCart(driver,"Pfizer Vaccine");
        Thread.sleep(1000);
        main.addItemToCart(driver ,"Pfizer Vaccine");
       main.ClickCartButton();
        cartPage cartpage = new cartPage(driver);
        cartpage.validateItemInCart("Pfizer Vaccine");
    }
}
