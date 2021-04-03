package modules;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class BaseTest {
    protected static WebDriver driver;
    @AfterClass
    static void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);
        driver= new ChromeDriver(chromeOptions);
    }
    @AfterMethod
    static void tearDown(){driver.quit();}
}
