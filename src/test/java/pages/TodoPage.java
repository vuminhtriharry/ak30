package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TodoPage extends BasePage{
    By todoList = By.cssSelector("ul.todo-list >li");
    By newTodoTxt = By.className("new-todo");
    WebDriverWait wait;
    Actions actions;
    public TodoPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver,10);
        actions = new Actions(driver);
    }
    @Override
    public void open(){
        driver.get("https://todomvc.com/examples/vanillajs");
    }
    public int getItemsLeft(){
        return driver.findElements(todoList).size();
    }
    public void addNew(String todoList){
        driver.findElement(newTodoTxt).sendKeys(todoList+"\n");
    }
    public By getTodo(String todoList){ return By.xpath(String.format("")); }
    public void removeTodo(String todoList){
        actions.moveToElement(driver.findElement(getTodo(todoList)));
        By destroyBtn = By.xpath(String.format("//lable[.='%s']/following"));
        driver.findElement(destroyBtn).click();
    }
    public void markDoneTodo(String todoList){
        actions.moveToElement(driver.findElement(getTodo(todoList)));
        By markBtn = By.xpath(String.format("//lable[.='%s']/precending"));
        driver.findElement(markBtn).click();
    }
}
