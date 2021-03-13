package modules;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
    @Test
    public static void validCredentials(){
        //Step 1:
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        //Step 2:
        driver.get("https://the-internet.herokuapp.com/login");
        //Step 3: Fill in username with Tomsmith
        driver.findElement(By.id("username")).sendKeys("tomsmith"); //->uu tien su dung nhat
        //driver.findElement(By.tagName("input")).sendKeys("Tomsmith");
        //driver.findElement(By.name("username")).sendKeys("Tomsmith");
        //driver.findElement(By.xpath("//input")).sendKeys("tomsmith");
        //driver.findElement(By.cssSelector("input")).sendKeys("Tomsmith");
        //driver.findElement(By.cssSelector("//input/@id")).sendKeys("Tomsmith"); //not work
        //driver.findElement(By.cssSelector("//input/@name")).sendKeys("Tomsmith");//not work
        //driver.findElement(By.cssSelector("//*/@name")).sendKeys("Tomsmith");//not work

        //driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Tomsmith");
        //driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Tomsmith");
        //driver.findElement(By.xpath("//*[contains(@name='username')]")).sendKeys("Tomsmith");

        //driver.findElement(By.cssSelector("input[name=username]")).sendKeys("Tomsmith");
        //driver.findElement(By.cssSelector("[name=username]]")).sendKeys("Tomsmith");

        //driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Tomsmith");
        //driver.findElement(By.xpath("//*[@id='username']")).sendKeys("Tomsmith");
        //driver.findElement(By.xpath("//*[contains(@id='username')]")).sendKeys("Tomsmith");

        //driver.findElement(By.cssSelector("input#username")).sendKeys("Tomsmith");
        //driver.findElement(By.cssSelector("#username")).sendKeys("Tomsmith");

        //CT tong quat khi locator bang xpath //E[@A='t']
        // -> CT biến thiên thứ 2: //*[@A='t']
        // -> //*[contains(@A),'t']
        //Step 4:
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        //Step 5:
        //driver.findElement(By.className("radius")).click();
        //driver.findElement(By.cssSelector(".radius")).click();
        //driver.findElement(By.cssSelector("button.radius")).click();
        //driver.findElement(By.cssSelector("button[type=submit]")).click();
        //driver.findElement(By.xpath("//*[@type='submit']")).click();
        //driver.findElement(By.xpath("[@type='submit']")).click();

        //driver.findElement(By.xpath("//*[contains(@type,'submit')]"));
        //driver.findElement(By.xpath("//*[.=' Login']")).click();
        //driver.findElement(By.xpath("//*[text()=' Login']")).click();
        //driver.findElement(By.xpath("//*[contains(.,' Login']")).click();
        driver.findElement(By.xpath("//button[contains(.,' Login')]")).click(); //co nghia gan voi phan mo ta cua minh nhat
        //Step 6: And the homepage is appear
        String currentUrl= driver.getCurrentUrl();
        //Assert.assertEquals(currentUrl,"https://the-internet.herokuapp.com/secure");
        Assert.assertTrue(currentUrl.contains("/secure"));
        driver.quit();
        driver.close();
    }
    @Test(description = "naming")
    public static void invalidCredentials(){
        //Step 1:
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        //Step 2:
        driver.get("https://the-internet.herokuapp.com/login");
        //Step 3: Fill in username with Tomsmith
        driver.findElement(By.id("username")).sendKeys("tomsmith"); //->uu tien su dung nhat
        //driver.findElement(By.tagName("input")).sendKeys("Tomsmith");
        //driver.findElement(By.name("username")).sendKeys("Tomsmith");
        //driver.findElement(By.xpath("//input")).sendKeys("tomsmith");
        //driver.findElement(By.cssSelector("input")).sendKeys("Tomsmith");
        //driver.findElement(By.cssSelector("//input/@id")).sendKeys("Tomsmith"); //not work
        //driver.findElement(By.cssSelector("//input/@name")).sendKeys("Tomsmith");//not work
        //driver.findElement(By.cssSelector("//*/@name")).sendKeys("Tomsmith");//not work

        //driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Tomsmith");
        //driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Tomsmith");
        //driver.findElement(By.xpath("//*[contains(@name='username')]")).sendKeys("Tomsmith");

        //driver.findElement(By.cssSelector("input[name=username]")).sendKeys("Tomsmith");
        //driver.findElement(By.cssSelector("[name=username]]")).sendKeys("Tomsmith");

        //driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Tomsmith");
        //driver.findElement(By.xpath("//*[@id='username']")).sendKeys("Tomsmith");
        //driver.findElement(By.xpath("//*[contains(@id='username')]")).sendKeys("Tomsmith");

        //driver.findElement(By.cssSelector("input#username")).sendKeys("Tomsmith");
        //driver.findElement(By.cssSelector("#username")).sendKeys("Tomsmith");

        //CT tong quat khi locator bang xpath //E[@A='t']
        // -> CT biến thiên thứ 2: //*[@A='t']
        // -> //*[contains(@A),'t']
        //Step 4:
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        //Step 5:
        //driver.findElement(By.className("radius")).click();
        //driver.findElement(By.cssSelector(".radius")).click();
        //driver.findElement(By.cssSelector("button.radius")).click();
        //driver.findElement(By.cssSelector("button[type=submit]")).click();
        //driver.findElement(By.xpath("//*[@type='submit']")).click();
        //driver.findElement(By.xpath("[@type='submit']")).click();

        //driver.findElement(By.xpath("//*[contains(@type,'submit')]"));
        //driver.findElement(By.xpath("//*[.=' Login']")).click();
        //driver.findElement(By.xpath("//*[text()=' Login']")).click();
        //driver.findElement(By.xpath("//*[contains(.,' Login']")).click();
        driver.findElement(By.xpath("//button[contains(.,' Login')]")).click(); //co nghia gan voi phan mo ta cua minh nhat
        //Step 6: And the homepage is appear
        String currentUrl= driver.getCurrentUrl();
        //Assert.assertEquals(currentUrl,"https://the-internet.herokuapp.com/secure");
        Assert.assertFalse(currentUrl.contains("/secure"));
        driver.quit();
        driver.close();
    }
}