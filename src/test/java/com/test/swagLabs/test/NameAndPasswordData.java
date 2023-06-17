package com.test.swagLabs.test;

import org.testng.annotations.DataProvider;

public class NameAndPasswordData {
    @DataProvider(name = "login")
    public Object[][] getData() {
        return new Object[][]{
                {"standard_user", "secret_sauce","https://www.saucedemo.com/inventory.html"},
                {"problem_user", "secret_sauce","https://www.saucedemo.com/inventory.html"},
                {"performance_glitch_user", "secret_sauce","https://www.saucedemo.com/inventory.html"},

        };
    }
    @DataProvider(name = "naglogin")
    public Object[][] getData1() {
        return new Object[][]{
                {"", "secret_uce","Epic sadface: Username is required"},
                {"problem_user", "","Epic sadface: Password is required"},
                {"", "","Epic sadface: Username is required"},
                {"sjksdg", "kfsfgd","Epic sadface: Username and password do not match any user in this service"},

        };
    }
    @DataProvider(name = "item")
    public Object[][] getData2() {
        return new Object[][]{
                {"Sauce Labs Backpack", "Sauce Labs Backpack","streamlined","$29.99"},
                {"Sauce Labs Bike Light", "Sauce Labs Bike Light","the desired state in testing","$9.99"},
                {"Sauce Labs Bolt T-Shirt", "Sauce Labs Bolt T-Shirt","Get your testing superhero","$15.99"},
                {"Sauce Labs Fleece Jacket", "Sauce Labs Fleece Jacket","It's not every day that you come across","$49.99"},
                {"Sauce Labs Onesie", "Sauce Labs Onesie","Rib snap infant onesie for the junior","$7.99"},
                {"Test.allTheThings() T-Shirt (Red)", "Test.allTheThings() T-Shirt (Red)","This classic Sauce Labs t-shirt","$15.99"},
        };
    }
}
