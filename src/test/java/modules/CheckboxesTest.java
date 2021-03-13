package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTest {
    @Test
    void validateIsChecked(){
        //Step 1
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        //Step 2:
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        //Step 3:
        check(driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]")));
        //Step 4:
        Assert.assertTrue(isSelect(driver.findElement(By.xpath("//input[1]")))); //refer binh thuong
        //Step 5:
        check(driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]")));
        //Step 6:
        Assert.assertTrue(isSelect(driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"))));
    }
    private void check(WebElement element){
        if(!element.isSelected()){
            element.click();
        }
    }
    private void uncheck(WebElement element){
        if(element.isSelected()){
            element.click();
        }
    }
    private boolean isSelect(WebElement element){
        return element.isSelected();
    }
    
}
