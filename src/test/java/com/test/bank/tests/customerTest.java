package com.test.bank.tests;

import com.test.bank.pages.BankMangerPage;
import com.test.bank.pages.bankLoginPage;
import com.test.bank.pages.customer;
import org.testng.annotations.Test;

public class customerTest extends BankTestBase {
       /*
TASK:
 1-Click homeButton from top(You can store in Manager Page or LoginPage)
 2-Click Customer Login
 3-Find Your name from the List
 4-Click Login
 5-Validate the "Welcome Your Name" from header
 6-Click Deposit and put 500
 7-Validate "Deposit Successful
 8-Click Withdrawl and put 300
 9-Validate "Transaction successful"
 10-Get the balance from the Customer Page(200)
 11-Click Transactions
 12-get the 500 and 300 from the table and substract them
 13-Validate balance from customer page amount(200) equals to transaction amount(500-300).
 14-Quit the driver

 NOTE:YOu should have another CustomerPage class and CustomerTest class and do your validation under customerTest
 */

    @Test
    public void validateCustomerLogin() throws InterruptedException {
        bankLoginPage bankLoginPage = new bankLoginPage(driver);
        bankLoginPage.clickMangerButton();
        BankMangerPage bankMangerPage = new BankMangerPage(driver);
        bankMangerPage.addCustomerFunctionality(driver, "Eskander", "Eskander", "123456",
                "Customer added successfully with customer");
        bankMangerPage.openAccountFunctionality(driver,"Eskander Eskander","Dollar",
                "Account created successfully with account Number ");
        bankMangerPage.customerFunctionality("Eskander","Eskander","123456");
        bankLoginPage.clickHomeButton();
        bankLoginPage.clickCustomerLoginButton();
        customer customer = new customer(driver);
        customer.loginFunctionality("6","Welcome Eskander Eskander !!");
        customer.depositFunctionality("500","Deposit Successful");
        customer.WithDrawFunctionality("300","Transaction successful");
        customer.transactionFunctionality();
    }
}
