package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HoverPage;

public class HoverTest extends BaseTest {
    private static WebDriver driver;

    @Test
    static void hoverAvatar1() {
        HoverPage hoverPage= new HoverPage(driver);

        Actions mouse = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement avatar1 = driver.findElement(By.xpath("//div[@class='figure'][1]"));
        mouse
                .moveToElement(avatar1)
                .perform();

        String caption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='figure'][1]/div/h5"))).getText();
        Assert.assertEquals(caption,"name: user1");
    }
}