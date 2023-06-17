package com.test.blaze.test;


import com.test.blaze.page.CartPage;
import com.test.blaze.page.LapTopsPage;
import com.test.blaze.page.MacBookPro;
import com.test.blaze.page.MainPage;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class laptopPAge extends blazeTestBase {

  @Test
  public void testLopTopPage() throws InterruptedException {
    MainPage mainPage = new MainPage(driver);
    mainPage.selectFromCategories("laptops");
    LapTopsPage lapTopsPage = new LapTopsPage(driver);
    lapTopsPage.SelectLapTops(driver,"MacBook Pro");
    MacBookPro macBookPro = new MacBookPro(driver);
    macBookPro.validateMacBookInf();
    macBookPro.validateAddButton(driver,"Product added");
  }


}
