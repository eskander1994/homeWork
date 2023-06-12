package iFrame;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Practice {
    @Test
    public void iFrame() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement header = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getTest(header));
        driver.switchTo().frame("mce_0_ifr");
        WebElement box = driver.findElement(By.cssSelector("#tinymce"));
        box.clear();
        box.sendKeys("i love selenium");
        driver.switchTo().parentFrame();
        header = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getTest(header));

    }
    /*
    TASK 1:
      1-Navigate to the website "https://skpatro.github.io/demo/iframes/"
      2-Click pavilion (new tab will be opened, consider switch window)
      3-Choose "Selenium-Java" from Selenium button (Action class is suggested)
      4-Validate the Header "Selenium-Java Tutorial – Basic to Advance"
      5-Print out(NO validation) Table of Content options on console(loop and getText())
      6-Wait for Second task
     */

    @Test
    public void Task1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://skpatro.github.io/demo/iframes/");
        WebElement pavilion = driver.findElement(By.linkText("Pavilion"));
        pavilion.click();
        BrowserUtils.switchByTitle(driver,"qavalidation");
        WebElement selenium = driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(selenium).perform();
        WebElement seleniumPython = driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium-Python']"));
        seleniumPython.click();
        WebElement header = driver.findElement(By.xpath("//div[@class='page-title-head hgroup']/h1"));
        Assert.assertEquals(BrowserUtils.getTest(header),"Selenium-Python Tutorial");
        List<WebElement> links = driver.findElements(By.xpath("//p//a"));
        for(WebElement link:links){
            System.out.println(BrowserUtils.getTest(link));
        }
        BrowserUtils.switchByTitle(driver,"iframes");
        driver.switchTo().frame("Frame1");
        WebElement category1= driver.findElement(By.xpath("//body//a[contains(text(),'Category1')]"));
        category1.click();
        BrowserUtils.switchByTitle(driver,"SeleniumTesting ");
        WebElement headerCategory =driver.findElement(By.xpath("//h1"));
        Assert.assertEquals(BrowserUtils.getTest(headerCategory),"Category Archives: SeleniumTesting");
        List <WebElement> alLTheHeaders = driver.findElements(By.xpath("//h3//a"));
        for(WebElement oneHeader:alLTheHeaders){
            System.out.println(BrowserUtils.getTest(oneHeader));
        }
        /*
TASK 3:
1-Go back mainPage
2-Click Category3
3-Validate the header "Category Archives: SoftwareTesting"

 */

        BrowserUtils.switchByTitle(driver,"iframes");
        driver.switchTo().frame("Frame1");
        WebElement inside = driver.findElement(By.xpath("//p[@id='frametext']"));
        System.out.println(BrowserUtils.getTest(inside));
        driver.switchTo().parentFrame();
        driver.switchTo().frame("Frame2");
        WebElement category3 = driver.findElement(By.xpath("//body//a[.='Category3']"));
        category3.click();
        BrowserUtils.switchByTitle(driver,"SoftwareTesting ");
        WebElement header3 = driver.findElement(By.xpath("//h1"));
        System.out.println(BrowserUtils.getTest(header3));

    }
}