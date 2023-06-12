package iFrame;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class nestIFrame {
    @Test
    public void nestedIFrom() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        WebElement iframeLEft = driver.findElement(By.xpath("//frame[@name='frame-left']"));
        driver.switchTo().frame(iframeLEft);
        WebElement left = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        System.out.println(BrowserUtils.getTest(left));
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        WebElement middle = driver.findElement(By.xpath("//div[@id='content']"));
        System.out.println(BrowserUtils.getTest(middle));
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement right = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        System.out.println(BrowserUtils.getTest(right));
       // driver.switchTo().parentFrame();
       // driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        WebElement bottom = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        System.out.println(BrowserUtils.getTest(bottom));


    }
}