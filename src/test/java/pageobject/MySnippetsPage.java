package pageobject;

import drivers.Interface.IGruWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Created by arvinth seran on 02/02/2017.
 */
public class MySnippetsPage extends MyCommonPage {
    public MySnippetsPage(IGruWebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.LINK_TEXT, using = "My Site")
    public WebElement lnkMySite;

    public Boolean IsSnippetCreated(String text) {
        return IsPresent("table tr", text);
    }

    public Boolean IsFormattedSnippetCreated(String format, String text) {
        return IsPresent(String.format("table tr %1$s", format), text);
    }

    private Boolean IsPresent(String cssSelector, String text) {
        List<WebElement> snippets = driver.getWebDriver().findElements(By.cssSelector(cssSelector));
        return snippets.stream().anyMatch(x -> x.getText().contains(text));
    }
}
