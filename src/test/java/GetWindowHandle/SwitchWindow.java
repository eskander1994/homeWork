package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {
    @Test
    public void contextClick() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/windows");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement clickHere = driver.findElement(By.xpath("//div[@class='example']//a"));
        clickHere.click();
        Thread.sleep(2000);
        WebElement header = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getTest(header));
        System.out.println(driver.getWindowHandle());//main page id
        Set<String> allPagesId =driver.getWindowHandles();
        String mainPageId  = driver.getWindowHandle();
        for(String id:allPagesId){
            if(!id.equals(mainPageId)){
                driver.switchTo().window(id);
                break;
            }
        }
        System.out.println(allPagesId);
       header = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getTest(header));
    }

    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement newWindow= driver.findElement(By.xpath("//button[@id='newTabBtn']"));
        BrowserUtils.scrollWithJS(driver,newWindow);
        newWindow.click();
        Set<String> allPageId = driver.getWindowHandles();
        String mainPage = driver.getWindowHandle();
        for(String id:allPageId){
            if(!id.equals(mainPage)){
                driver.switchTo().window(id);
                break;
            }
        }
        WebElement nameAlerts = driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
        Assert.assertEquals(BrowserUtils.getTest(nameAlerts),"AlertsDemo");
        Assert.assertEquals(driver.getTitle(),"AlertsDemo - H Y R Tutorials");
        WebElement clickMe = driver.findElement(By.xpath("//button[@id='alertBox']"));
        clickMe.click();
    }

}