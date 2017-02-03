package pageobject;

import java.util.Optional;
import drivers.Interface.IGruWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Created by arvinth seran on 02/02/2017.
 */
public class CommonPage extends BasePage {
    CommonPage(IGruWebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.NAME, using = "uid")
    private WebElement txtUserName;

    @FindBy(how = How.NAME, using = "pw")
    private WebElement txtPassword;

    public SaveProfilePage CreateAccount(String username, String password){
        common(username,password,"Create account");
        return new SaveProfilePage(driver);
    }

    public MyAccountPage Login(String username, String password){
        common(username,password,"Login");
        try {
            // thread to sleep for 2000 milliseconds
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(e);
        }
        return new MyAccountPage(driver);
    }

    private void common(String username, String password, String btnText){
        driver.Type(txtUserName,username);
        driver.Type(txtPassword,password);
        btnWithText(btnText).click();
    }
}
