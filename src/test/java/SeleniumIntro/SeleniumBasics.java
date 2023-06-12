package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumBasics {
    // first step is setting up your automation
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        // then create your driver to start automation
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.amazon.com/amazonprime");
        System.out.println(driver.getTitle());
        String actualTitle =driver.getTitle();
        String expectedTitle="Amazon.com: Amazon Prime";
        System.out.println(actualTitle.equals(expectedTitle)?"pass":"not pass");

        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.amazon.com/amazonprime";
        System.out.println(actualTitle.equals(expectedTitle)?"pass URL":"Failed URL");

        driver.close();


    }
}
