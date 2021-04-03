package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class FrameTest {
    private static WebDriver driver;

    @BeforeMethod
    void setup(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
    }
    @Test
    void checkInnerText() {
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        Assert.assertTrue(driver.findElement(By.xpath("html/body")).getText().contains("LEFT")
                ,driver.findElement(By.xpath("html/body")).getText()
        );
        driver.switchTo().parentFrame();//you are in top frame
        driver.switchTo().frame("frame-middle");
        Assert.assertTrue(driver.findElement(By.id("content")).getText().contains("MIDDLE"));

        driver.switchTo().parentFrame();//you are in top frame
        driver.switchTo().frame("frame-right");
        Assert.assertTrue(driver.findElement(By.xpath("html/body")).getText().contains("RIGHT")
                , driver.findElement(By.xpath("html/body")).getText()
        );

        driver.switchTo().parentFrame();//you are in top frame
        driver.switchTo().parentFrame();//you are in top frame

        driver.switchTo().parentFrame();//you are in top frame
        driver.switchTo().frame("frame-bottom");
        Assert.assertTrue(driver.findElement(By.xpath("html/body")).getText().contains("BOTTOM")
                , driver.findElement(By.xpath("html/body")).getText()
        );
    }
    @AfterMethod
    static void tearDown(){
        driver.quit();
    }
}
