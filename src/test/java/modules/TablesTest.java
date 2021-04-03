package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import table.Person;

import java.util.List;

import java.util.stream.Collectors;

public class TablesTest {
    private static WebDriver driver;

   @BeforeMethod
    void setup(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
    }

    @Test
    void maximumDuePerson() {
        /**
         *  //table[@id='table1']/tbody/tr
         */

        List<WebElement> cells = driver.findElements(By.xpath("//table[@id='table1']//tr/td[4]"));

        List<String> dues = cells
                .stream().map(WebElement::getText).collect(Collectors.toList());

        float max = Float.parseFloat(dues.get(0).replace("$", ""));
        int maxIndex = 0;

        for (int i = 1; i < dues.size(); i++) {
            if (Float.parseFloat(dues.get(i).replace("$", "")) > max) {
                max = Float.parseFloat(dues.get(i).replace("$", ""));
                maxIndex = i;
            }
        }
        String firstName = driver.findElement(By.xpath(String.format("//table[@id='table1']//tr[%s]/td[2]", maxIndex + 1))).getText();
        String lastName = driver.findElement(By.xpath(String.format("//table[@id='table1']//tr[%s]/td[1]", maxIndex + 1))).getText();
        Assert.assertEquals(String.format("%s %s", firstName, lastName), "Jason Doe");
    }
    @Test
    void allCellValue(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        List<Person> persons = rows.stream()
                .map(element -> {
                    return toPerson(element);
                }).collect(Collectors.toList());

        List<Float> dues = persons.stream().map(Person::getDue).collect(Collectors.toList());

        persons.stream().forEach(person -> System.out.println(person.getDue()));
    }
    /*@Test
    void minimumDuePerson(){
        Person minDuePerson = person
                .stream()
                .min(Comparator.comparing(Person::getDue))
                .orElseThrow(NoSuchElementException::new);
        Assert.assertEquals(minDuePerson.getFullName(),"John Smith");
    }
    @Test
    void deleteRow(){
        Person filterPerson = persons
                .stream()
                .filter(person -> person.getFirstName().equals("Frank"))
                .findAny()
                .orELse(null);
        assert filterPerson !=null;
    }*/
    static Person toPerson(WebElement row){
        List<WebElement> cells = row.findElements(By.tagName("td"));
        String firstName = cells.get(0).getText();
        String lastName = cells.get(1).getText();
        String email = cells.get(2).getText();
        String due = cells.get(3).getText().replace("$","");
        String website = cells.get(4).getText();
        return new Person(firstName,lastName,email,Float.parseFloat(due),website);
    }
    @AfterMethod
    static void tearDown(){driver.quit();}
}
