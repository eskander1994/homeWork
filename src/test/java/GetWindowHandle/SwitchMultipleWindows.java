package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchMultipleWindows {
    @Test
    public void practiceMultipleWindows() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('http://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");
        js.executeScript("window.open('https://www.techtorialacademy.com/courses')");
        String mainPage = driver.getWindowHandle();
        Set<String> allPages = driver.getWindowHandles();
        for(String page:allPages){
            if(!page.equals(mainPage)){
                driver.switchTo().window(page);
break;
            }
        }
        System.out.println(driver.getTitle());

        BrowserUtils.switchByTitle(driver,"Contact");
        System.out.println(driver.getTitle());
        BrowserUtils.switchByTitle(driver,"Kickstart");
        System.out.println(driver.getTitle());
        BrowserUtils.switchByTitle(driver,"Courses");
        System.out.println(driver.getTitle());
    }
    /*
1-Navigate to https://www.hyrtutorials.com/p/window-handles-practice.html
2-Click open multiple tabs under Button 4
3-the Basic Control and fill all the blanks
4-Click Register button and validate the message "Registration is Successful"
5-GO to the Window handle practice page and validate Header  which is Window Handles Practice
6- go to the alertsDemo page and click  the "Click Me" button under prompt box
7-quit all the pages.
8-Proud of yourself
*/
    @Test
    public void RealTask() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement button4 = driver.findElement(By.xpath("//button[@onclick='newBrowserTabs()']"));
        BrowserUtils.scrollWithJS(driver,button4);
        button4.click();


        BrowserUtils.switchByTitle(driver,"Basic Controls");
        WebElement firstName = driver.findElement(By.xpath("//input[@name='fName']"));
        firstName.sendKeys("Eskander");
        WebElement LastName = driver.findElement(By.xpath("//input[@name='lName']"));
        LastName.sendKeys("Eskander");
        WebElement maleBox = driver.findElement(By.xpath("//input[@id='malerb']"));
        BrowserUtils.scrollWithJS(driver,maleBox);
        maleBox.click();
        WebElement englishCheckBox = driver.findElement(By.xpath("//input[@id='englishchbx']"));
        englishCheckBox.click();
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("Eskander@gmail.com");
        WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
        passWord.sendKeys("123456");
        WebElement register = driver.findElement(By.xpath("//button[@id='registerbtn']"));
        BrowserUtils.scrollWithJS(driver,register);
        Thread.sleep(2000);
        register.click();
        WebElement message = driver.findElement(By.xpath("//label[@id='msg']"));
        Assert.assertEquals(BrowserUtils.getTest(message),"Registration is Successful");


        BrowserUtils.switchByTitle(driver,"Window Handles");
        WebElement header = driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
        Assert.assertEquals(BrowserUtils.getTest(header),"Window Handles Practice");


        BrowserUtils.switchByTitle(driver,"AlertsDemo");
        WebElement clickMe = driver.findElement(By.xpath("//button[@id='alertBox']"));
        clickMe.click();
    }
}