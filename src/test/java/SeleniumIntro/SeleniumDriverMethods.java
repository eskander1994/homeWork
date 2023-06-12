package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumDriverMethods {
    public static void main(String[] args) throws InterruptedException {
        //driver.get
        //driver.manage.windows.maximize
        //driver.getTitle
        //driver.getCurrentUrl
        //driver.navigate().back()
        //driver.navigate().forward()
        //driver.navigate().refresh()
        //driver.getPageSource()
        //driver.quit()
        //driver.


        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
        driver.navigate().to("https://www.youtube.com/");
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
        driver.navigate().forward();
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
        driver.navigate().refresh();
        System.out.println(driver.getPageSource());
        driver.quit();
    }
}
