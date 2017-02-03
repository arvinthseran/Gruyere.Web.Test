package drivers.Interface;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by arvinth seran on 01/02/2017.
 */
public interface IGruWebDriver {

    WebDriver getWebDriver();

    void setWebDriver(WebDriver driver);

    void GoToUrl(String url);

    void Type(WebElement webelement, String text);

    void WaitUntilDocIsReady() ;

    void CloseAndQuit() ;

}
