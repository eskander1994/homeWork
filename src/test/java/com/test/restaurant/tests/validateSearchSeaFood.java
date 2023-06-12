package com.test.restaurant.tests;

import com.test.restaurant.pages.fishSeaFoodPage;
import com.test.restaurant.pages.mainPage;
import com.test.restaurant.pages.searchPage;
import org.testng.annotations.Test;

public class validateSearchSeaFood extends testBase {
    @Test
    public void validateSeaFoodSearchWithAdd() throws InterruptedException {
        mainPage mainPage = new mainPage(driver);
        mainPage.clickFishSeaFood(driver);
        fishSeaFoodPage fishSeaFoodPage = new fishSeaFoodPage(driver);
        fishSeaFoodPage.searchBarFunctionality(driver,"Fish for dinner");
        searchPage searchPage = new searchPage(driver);
        searchPage.validateItemWithFilterAdd("6-Ingredient Roasted Salmon Fillets");
    }
}

