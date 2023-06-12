package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class realLifeExamplePractice {
    //  Test Case - Open Godaddy.com and validate it's Page title and the url.
//    Steps to Automate:
//            1. Launch browser of your choice say., Firefox, chrome etc.
//            2. Open this URL - https://www.godaddy.com/
//            3. Maximize or set size of browser window.
//4. Get Title of page and validate it.(if conditions) expected title from website
//4. Get URL of current page and validate it.          expected url from website
//            5. Close browser.(driver.close)


    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        // then create your driver to start automation
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.godaddy.com/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        String actualTitle =driver.getTitle();
        String expectedTitle="Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy";
        System.out.println(actualTitle.equals(expectedTitle)?"pass":"not pass");

        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.godaddy.com/";
        System.out.println(actualTitle.equals(expectedTitle)?"URL is pass ":"URL is Failed ");
        driver.close();
    }
}
