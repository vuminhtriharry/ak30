package modules;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest{
    @DataProvider
    static Object[][] credentials(){
        return new Object[][]{
                new Object[]{"tomsmith","SuperSecretPassword!","/secure"},
                new Object[]{"tomsmith","SuperSecretPassword@","/login"},
        };
    }
    @Test(dataProvider = "credentials")
    public static void check(String username,String password,String expectedUrl){
        LoginPage loginPage =new LoginPage(driver);
        loginPage.open();
        loginPage.login(username,password);

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(expectedUrl));
    }
}