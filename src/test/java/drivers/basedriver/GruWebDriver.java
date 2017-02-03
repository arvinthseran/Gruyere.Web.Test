package drivers.basedriver;

import drivers.Interface.IGruWebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import com.google.common.base.Predicate;
import java.util.concurrent.TimeUnit;

/**
 * Created by arvinth seran on 01/02/2017.
 */
public abstract class GruWebDriver implements IGruWebDriver {

    private int _defaultTimeOutinSec;

    public GruWebDriver(WebDriver webdriver, int timeout) {
        _defaultTimeOutinSec = timeout;
        webdriver.manage().timeouts().implicitlyWait(_defaultTimeOutinSec, TimeUnit.SECONDS);
        webdriver.manage().timeouts().pageLoadTimeout(_defaultTimeOutinSec, TimeUnit.SECONDS);
        webdriver.manage().window().maximize();
        setWebDriver(webdriver);
    }

    WebDriver webDriver;

    public WebDriver getWebDriver()  {return webDriver;}

    public void setWebDriver(WebDriver driver){this.webDriver = driver;}

    public void GoToUrl(String url){
        webDriver.navigate().to(url);
    }

    public void Type(WebElement webelement, String text){
        webelement.clear();
        webelement.sendKeys(text);
    }

    public void CloseAndQuit() {
        webDriver.close();
        webDriver.quit();
    }
    public void WaitUntilDocIsReady() {

        WebDriverWait wait = new WebDriverWait(getWebDriver(), _defaultTimeOutinSec);
        Predicate<WebDriver> isReady = (drv) -> ((JavascriptExecutor)drv).executeScript("return document.readyState").equals("complete");
        wait.until(isReady);
    }
}
