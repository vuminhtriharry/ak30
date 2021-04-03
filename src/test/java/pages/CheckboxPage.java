package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

public class CheckboxPage {
    WebDriver driver;
    HashMap<String,By> checkboxes;
    By checkbox1 = By.xpath("//form[@id='checkboxes']/input[1]");
    By checkbox2 = By.xpath("//form[@id='checkboxes']/input[2]");

    public CheckboxPage(WebDriver driver){
        this.driver=driver;
    }
    public void open(){
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        checkboxes.put("checkbox1",By.xpath("//form[@id='checkboxes']/input[1]"));
        checkboxes.put("checkbox2",By.xpath("//form[@id='checkboxes']/input[2]"));
    }
    private void check(String name){
        WebElement checkbox = driver.findElement(checkboxes.get(name));
        if(!checkbox.isSelected()){
            checkbox.click();
        }
    }
    private void uncheck(String name){
        WebElement checkbox = driver.findElement(checkboxes.get(name));
        if(checkbox.isSelected()){
            checkbox.click();
        }
    }
    private boolean isSelected(WebElement element){return element.isSelected();}
}
