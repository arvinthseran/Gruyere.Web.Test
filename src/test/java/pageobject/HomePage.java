package pageobject;

import drivers.Interface.IGruWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by arvinth seran on 02/02/2017.
 */
public class HomePage extends BasePage {
    public HomePage(IGruWebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.LINK_TEXT, using = "Home")
    public WebElement lnkhome;

    @FindBy(how = How.LINK_TEXT, using = "Sign in")
    private WebElement lnkSignIn;

    @FindBy(how = How.LINK_TEXT, using = "Sign up")
    private WebElement lnkSignup;

    @FindBy(how = How.LINK_TEXT, using = "Refresh")
    public WebElement lnkRefresh;

    public CommonPage NavigateToSignUp(){
        lnkSignup.click();
        return new CommonPage(driver);
    }

    public CommonPage NavigateToSignIn(){
        lnkSignIn.click();
        return new CommonPage(driver);
    }


}
