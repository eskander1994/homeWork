package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class HomeWork {
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver= new ChromeDriver(options);
        driver.get("https://www.blackriflecoffee.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String actualTitle =driver.getTitle(),expectedTitle ="BLACK RIFLE COFFEE COMPANY – Black Rifle Coffee Company";
        System.out.println(actualTitle.equals(expectedTitle)?"Title is pass 1":"Title is not pass 1");
        String url =driver.getCurrentUrl(),expectedUrl="https://www.blackriflecoffee.com/";
        System.out.println(url.equals(expectedUrl)?"URL pass 1":"URL not pass 1 ");

        driver.close();
        driver= new ChromeDriver(options);
        driver.get("https://ghostenergy.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String actualTitle2 =driver.getTitle(),expectedTitle2 ="GHOST® ENERGY DRINK";
        System.out.println(actualTitle2.equals(expectedTitle2)?"Title is pass 2":"Title is not pass 2");
        String url2 =driver.getCurrentUrl(),expectedUrl2="https://ghostenergy.com/";
        System.out.println(url2.equals(expectedUrl2)?"URL pass 2 ":"URL not pass 2");

        driver.close();
        driver= new ChromeDriver(options);
        driver.get("https://www.youtube.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String actualTitle3 =driver.getTitle(),expectedTitle3 ="(42) YouTube";
        System.out.println(actualTitle3.equals(expectedTitle3)?"Title is pass 3":"Title is not pass 3");
        String url3 =driver.getCurrentUrl(),expectedUrl3="https://www.youtube.com/";
        System.out.println(url3.equals(expectedUrl3)?"URL pass 3 ":"URL not pass 3");
        driver.close();
    }
}
