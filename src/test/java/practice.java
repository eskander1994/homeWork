import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class practice {
    public static  void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("file:///C:/Users/eskan/OneDrive/Desktop/SELENIUM/Techtorial.html");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        WebElement firstname = driver.findElement(By.name("firstName"));
        firstname.sendKeys("Eskander");
        WebElement javaBox=driver.findElement(By.id("cond1"));
    if(javaBox.isDisplayed()&&!javaBox.isSelected()){
        javaBox.click();
        System.out.println("java box is select now");
    }
    
    }
}
