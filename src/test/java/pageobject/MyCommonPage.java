package pageobject;

import drivers.Interface.IGruWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;
import java.util.Optional;

/**
 * Created by arvinth seran on 02/02/2017.
 */
public class MyCommonPage extends BasePage {
    MyCommonPage(IGruWebDriver driver){
        super(driver);
    }

    @FindBy(how = How.LINK_TEXT, using = "Home")
    public WebElement lnkhome;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Snippets")
    public WebElement lnkMySnippets;

    String lnkNewSnippet = "New Snippet";

    @FindBy(how = How.LINK_TEXT, using = "Upload")
    public WebElement lnkUpload;

    @FindBy(how = How.LINK_TEXT, using = "Profile")
    public WebElement lnkProfile;

    @FindBy(how = How.LINK_TEXT, using = "Sign out")
    public WebElement lnkSignout;

    @FindBy(how = How.CLASS_NAME, using = "has-refresh")
    private WebElement lnkh2;

    @FindBy(how = How.CLASS_NAME, using = "menu")
    private WebElement divmenu;

    WebElement FindlnkWithText(String text){
        List<WebElement> inputelements = driver.getWebDriver().findElements(By.tagName("a"));
        Optional<WebElement> lnkcreate;
        if (inputelements.stream().anyMatch(x-> x.getText().equalsIgnoreCase(text))){
            lnkcreate = inputelements.stream().filter(x-> x.getText().equalsIgnoreCase(text)).findFirst();
        }
        else{
            lnkcreate = inputelements.stream().filter(x-> !(isNullOrEmpty(x.getText()))).findFirst();
        }
        return lnkcreate.get();
    }

    public String ReadMessage(){
        return lnkh2.getText();
    }

    public String ReadMenu(){
        return divmenu.getText();
    }


}
