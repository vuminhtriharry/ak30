package modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BmiPage;

public class BmiTest extends BaseTest{
    private static WebDriver driver;
    @Test
    static void tc01() {
        BmiPage bmiPage = new BmiPage(driver);
        bmiPage.open();
        bmiPage.openMetricTab();
        bmiPage.fillForm("25","male","180","58");
        Assert.assertEquals(bmiPage.getResult(),"BMI=20.1 kg/m2 (Normal)");
    }
}
