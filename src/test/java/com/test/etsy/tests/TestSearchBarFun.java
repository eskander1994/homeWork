package com.test.etsy.tests;

import com.test.etsy.pages.MainPage;
import com.test.etsy.pages.SearchPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestSearchBarFun  extends etsyTestBase{
    @Parameters ({"searchBra","word1","word2","word3"})
    @Test
            public void testSearchBra(String searchBra,String word1,String word2,String word3) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.searchBarFun(driver,searchBra);
        SearchPage searchPage = new SearchPage(driver);
        searchPage.verifySearchBar(word1,word2,word3);
    }
}
