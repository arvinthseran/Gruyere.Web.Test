package pageobject;

import drivers.Interface.IGruWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by arvinth seran on 02/02/2017.
 */
public class NewSnippetPage extends BasePage {
    NewSnippetPage(IGruWebDriver driver){
        super(driver);
    }

    @FindBy(how= How.NAME, using = "snippet")
    private WebElement txtNewSnippet;

    public void CreateNewSnippet(String text){
     driver.Type(txtNewSnippet,text);
        btnWithText("Submit").click();
    }
}
