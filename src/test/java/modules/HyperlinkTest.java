package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HyperlinkTest extends BaseTest {
    private static By hereTxt = By.linkText("here");
    private static String baseUrl = "https://the-internet.herokuapp.com/status_codes";
    private static WebDriver driver;
    @BeforeMethod
    static void setup(){
        //Step: Open browser
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver = new ChromeDriver();
        //Step: Navigate to https://the-internet.herokuapp.com/status_codes
        driver.get(baseUrl);
    }
    @DataProvider
    static Object[][] pages(){
        return new Object[][]{
                new Object[]{"200","status_codes/200"} ,
                new Object[]{"301","status_codes/301"} ,
                new Object[]{"404","status_codes/404"} ,
                new Object[]{"500","status_codes/500"} ,
        };
    }
    @Test(dataProvider = "pages")
    static void navigateToPage(String name,String expected){
        driver.findElement(By.linkText(name)).click();
        //Assert.assertTrue(driver.getCurrentUrl().contains(String.format("status_code/%s",name))); //cong chuoi
        Assert.assertTrue(driver.getCurrentUrl().contains(expected));
        driver.findElement(hereTxt).click();
    }
    @AfterMethod
    static void tearDown(){
        Assert.assertTrue(driver.getCurrentUrl().contains("status_codes"));
        driver.quit();
    }
    /**
     * Description: this methode use to click on hyperlink
     *              then check the navigate page is displayed
     * @param name
     */
    private static void validateSinglePage(String name){

    }
}
