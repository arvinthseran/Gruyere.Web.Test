package pageobject;

import drivers.Interface.IGruWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by arvinth seran on 02/02/2017.
 */
public class SaveProfilePage extends BasePage{
    public SaveProfilePage(IGruWebDriver driver){
        super(driver);
    }

    @FindBy(how= How.CLASS_NAME, using = "message")
    private WebElement lblmessage;

    public String ReadMessage(){
        return lblmessage.getText();
    }

}
