package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class JsAlertTest {
    private static WebDriver driver;

    @BeforeMethod
    void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    void clickForJsAlert() {
        driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();
        //todo: dismiss alert via click OK button
        WebDriverWait wait = new WebDriverWait(driver, 10);

        Assert.assertTrue(wait.until(ExpectedConditions.alertIsPresent()) != null);

        driver.switchTo().alert();

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result, "You successfully clicked an alert");
    }

    @DataProvider
    static Object[][] confirmActions() {
        return new Object[][]{
                new Object[]{"Cancel"},
                new Object[]{"Ok"}

        };
    }
    @Test(dataProvider = "confirmActions")
    void clickForJSConfirm(String action) {
        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
        //todo: dismiss alert via click OK button
        WebDriverWait wait = new WebDriverWait(driver,10);

        Assert.assertTrue(wait.until(ExpectedConditions.alertIsPresent())!=null);

        if(action.contains("Cancel")){
            driver.switchTo().alert().dismiss();
        }else{
            driver.switchTo().alert().accept();
        }

        String result =driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result,String.format("You clicked: %s",action));
    }
    @Test
    static void clickForJSPrompt() {
        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();

        //todo: dismiss alert via click OK button
        WebDriverWait wait = new WebDriverWait(driver,10);
        Assert.assertTrue(wait.until(ExpectedConditions.alertIsPresent())!=null);

        driver.switchTo().alert().sendKeys("Hello");
        driver.switchTo().alert().accept();

        String result =driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result,"You entered: Hello");
    }
    @AfterMethod
    static void tearDown(){
        driver.quit();
    }
}
