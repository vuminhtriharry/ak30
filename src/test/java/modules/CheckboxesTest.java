package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CheckboxesTest {
    @Test
    public static void validCredentials(){
        //Step 1
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        //Step 2:
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        //Step 3:
        driver.findElement(By.xpath("//form[@id='checkboxes']/input[@type='checkbox']")).click();
        //Step 4:
        driver.findElement(By.xpath("//form[@id='checkboxes']/input[@type='checkbox']")).click();
    }
}
