package com.test.swagLabs.page;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class MainPage {
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver ,this);
    }

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    List<WebElement> inventoryItemName;
    @FindBy(xpath = "//div[@class='inventory_details_desc_container']//div[1]")
    WebElement itemHeader;
    @FindBy(xpath = "//div[@class='inventory_details_desc_container']//div[2]")
    WebElement itemInf;
    @FindBy(xpath = "//div[@class='inventory_details_desc_container']//div[3]")
    WebElement itemPrice;



    public void findItemInventory(String itemName ,String expectHeader,String expectItemIfo,String expectItemPrice) throws InterruptedException {
        for(WebElement item:inventoryItemName){
            if(BrowserUtils.getTest(item).equals(itemName)){
                item.click();
                Thread.sleep(3000);
                System.out.println(BrowserUtils.getTest(itemPrice));
                System.out.println(BrowserUtils.getTest(itemInf));
                System.out.println(BrowserUtils.getTest(itemHeader));
                Assert.assertEquals(BrowserUtils.getTest(itemHeader),expectHeader);
                Assert.assertTrue(BrowserUtils.getTest(itemInf).contains(expectItemIfo));
                Assert.assertEquals(BrowserUtils.getTest(itemPrice),expectItemPrice);
                break;
            }
        }

    }
}
