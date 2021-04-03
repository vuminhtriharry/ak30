package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By usernameTxt = By.id("username");
    By passwordTxt = By.id("username");
    By loginBtn = By.xpath("//button[contains(.,'Login')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/login");
    }
    public void login(String username,String password){
        driver.findElement(usernameTxt).sendKeys(username); //->uu tien su dung nhat
        driver.findElement(passwordTxt).sendKeys(password);
        driver.findElement(loginBtn).click();
    }
}
