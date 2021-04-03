package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BmiPage extends BasePage{
    //3cach: String,By,WebElement
    WebDriver driver;
    @FindBy(className = "clearbtn")
    WebElement clearBtn;
    @FindBy(className ="//a[.,'Metric Units']")
    WebElement metricUnitTab;
    @FindBy(id ="cage")
    WebElement ageTxt;
    @FindBy(id = "csex1")
    WebElement maleRad;
    @FindBy(id = "csex2")
    WebElement femaleRad;
    @FindBy(id = "cheightmeter")
    WebElement heighTxt;
    @FindBy(id = "ckg")
    WebElement weightTxt;
    @FindBy(xpath = "//input[@value='Calculate']")
    WebElement calculateBtn;
    @FindBy(className = "bigtext")
    WebElement resultLbl;

    public BmiPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }
    public void open() {
        driver.get("https://www.calculator.net/bmi-calculator.html");
    }

    public String getResult(){
        return resultLbl.getText();
    }
    public void fillForm(String age, String gender, String height, String weight){
        clearBtn.click();
        ageTxt.click();

        if(gender.equalsIgnoreCase("male")) {
            maleRad.click();
        }
        else femaleRad.click();

        clearBtn.click();
        heighTxt.click();

        clearBtn.click();
        weightTxt.click();
        calculateBtn.click();
    }
    public void openMetricTab(){
        calculateBtn.click();
    }
}
