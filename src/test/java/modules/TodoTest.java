package modules;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TodoPage;

public class TodoTest extends BaseTest{
    @Test
    void createNew(){
        TodoPage todoPage = new TodoPage(driver);
        todoPage.open();

        int itemLeftBefore = todoPage.getItemsLeft();
        todoPage.addNew("task 1");

        int itemLeftAfter = todoPage.getItemsLeft();
        Assert.assertEquals(itemLeftAfter-itemLeftBefore,1);
    }
    @Test
    void removeTodo(){
        TodoPage todoPage = new TodoPage(driver);
        todoPage.open();

        todoPage.addNew("task 1");
        int itemLeftBefore = todoPage.getItemsLeft();

        todoPage.removeTodo("task 1");
        int itemLeftAfter = todoPage.getItemsLeft();
        Assert.assertEquals(itemLeftAfter - itemLeftBefore,-1);
    }
    @Test
    void markTodoComplete(){
        TodoPage todoPage = new TodoPage(driver);
        todoPage.open();

        todoPage.addNew("task 1");
        int itemLeftBefore = todoPage.getItemsLeft();

        todoPage.addNew("task 1");
        int itemLeftAfter = todoPage.getItemsLeft();
        Assert.assertEquals(itemLeftAfter - itemLeftBefore,-1);
    }
}
