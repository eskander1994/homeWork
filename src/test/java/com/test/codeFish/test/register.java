package com.test.codeFish.test;

import Utils.ConfigReader;
import com.test.codeFish.pages.Login;
import com.test.codeFish.pages.main;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class register    extends testBase {
    @Parameters({"expect"})

    @Test
    public void happyPathRegister(String expect) throws InterruptedException {
        Login login = new Login(driver);
        login.HappyPathRegister(ConfigReader.readProperty("QA_codeFish_username"),ConfigReader.readProperty("QA_codeFish_passWord"));
        main main = new main(driver);
        Assert.assertEquals(main.mainPageTitle(),expect);
    }

}
