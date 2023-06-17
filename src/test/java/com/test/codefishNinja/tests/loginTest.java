package com.test.codefishNinja.tests;

import com.test.codefishNinja.pages.FindPatientPage;
import com.test.codefishNinja.pages.Home;
import com.test.codefishNinja.pages.LoginPages;
import org.testng.Assert;
import org.testng.annotations.Test;

public class loginTest extends  testBase {

    @Test
    public void HappyPathLogin(String expectLocation,String expectHeader) throws InterruptedException {
        LoginPages loginPages = new LoginPages(driver);
        loginPages.loginAndSelectLocations("admin","Admin123","Laboratory");
        Home home = new Home(driver);
        Assert.assertEquals(home.location(),"Laboratory");
        Assert.assertEquals(home.header(),"Logged in as Super User (admin) at Laboratory.");

    }

    @Test
    public void validateHeaderAndLocationChange() throws InterruptedException {
        LoginPages loginPages = new LoginPages(driver);
        loginPages.loginAndSelectLocations("admin","Admin123","Laboratory");
        Home home  = new Home(driver);
        home.changeLocation("Pharmacy");
      home.clickOpenMRS();
        Assert.assertEquals(home.location(),"Pharmacy");
        Assert.assertEquals(home.header(),"Logged in as Super User (admin) at Pharmacy.");

    }

@Test
    public void findPatientRecordTest() throws InterruptedException {
    LoginPages loginPages = new LoginPages(driver);
    loginPages.loginAndSelectLocations("admin","Admin123","Laboratory");
    Home home = new Home(driver);
    home.clickFindPatient();
    FindPatientPage findPatientPage = new FindPatientPage(driver);
    findPatientPage.checkPatientIdentifierUn("John johnes");



}
@Test
    public void ValidateAddNewPatient() throws InterruptedException {
    LoginPages loginPages = new LoginPages(driver);
    loginPages.loginAndSelectLocations("admin","Admin123","Laboratory");
    Home home = new Home(driver);
    home .clickRegisterButton();

}


}
