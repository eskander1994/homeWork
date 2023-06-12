package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class YoutubeRealInterviewQuestion {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver =new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.youtube.com/");
        WebElement searchBar = driver.findElement(By.xpath("//input[@id='search']"));
        searchBar.sendKeys("P.O.D");
        // searchBra.sendkey(click)   short cut
        WebElement button = driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
        button.click();
        Thread.sleep(2000);
        List<WebElement> songs = driver.findElements(By.xpath("//a[@id='video-title']"));
        for(WebElement song:songs ){
           if( song.getAttribute("title").trim().equals("P.O.D. - Sleeping Awake (Official Music Video)")){
               Thread.sleep(2000);
               song.sendKeys(Keys.ARROW_DOWN);
               song.click();
               break;

           }
        }
    }
}
