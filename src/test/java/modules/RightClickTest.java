package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RightClickTest {
    private static String baseUrl = "https://the-internet.herokuapp.com/context_menu";
    private static WebDriver driver;
    @BeforeMethod
    static void setup(){
        //Step: Open browser
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver = new ChromeDriver();
        //Step: Navigate to https://the-internet.herokuapp.com/status_codes
        driver.get(baseUrl);
    }
    @Test
    static void tc01(){
        WebElement hotPot =driver.findElement(By.id("hot-spot"));
        Actions mouse = new Actions(driver);
        mouse.contextClick(hotPot).perform();

        WebDriverWait wait = new WebDriverWait(driver,10);
        Assert.assertTrue(wait.until(ExpectedConditions.alertIsPresent())!=null);

        String jsContext =driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        Assert.assertEquals(jsContext,"You selected a context menu");
    }
    @AfterMethod
    static void tearDown(){
        driver.quit();
    }
}
