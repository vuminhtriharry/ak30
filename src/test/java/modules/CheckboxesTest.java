package modules;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckboxPage;

public class CheckboxesTest extends BaseTest{
    @Test
    void validateCheckboxIsSelected(){
        CheckboxPage checkboxesPage= new CheckboxPage(driver);
        checkboxesPage.open();
        //checkboxesPage.check("checkbox1");
        //Assert.assertTrue(checkboxesPage.isSelected(),"");
    }
}
