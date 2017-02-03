package pageobject;
import drivers.Interface.IGruWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Optional;

/**
 * Created by arvinth seran on 01/02/2017.
 */
public abstract class BasePage {

    public IGruWebDriver driver;

    BasePage(IGruWebDriver gruWebDriver){
        driver = gruWebDriver;
        driver.WaitUntilDocIsReady();
        PageFactory.initElements(driver.getWebDriver(), this);
    }

    WebElement btnWithText(String text){
        List<WebElement> inputelements = driver.getWebDriver().findElements(By.tagName("input"));
        Optional<WebElement> btncreate;
        if (inputelements.stream().anyMatch(x-> x.getAttribute("value").equalsIgnoreCase(text))){
            btncreate = inputelements.stream().filter(x-> x.getAttribute("value").equalsIgnoreCase(text)).findFirst();
        }
        else{
            btncreate = inputelements.stream().filter(x-> !(isNullOrEmpty(x.getAttribute("value")))).findFirst();
        }
        return btncreate.get();
    }

    static boolean isNullOrEmpty(String s) {
        return s == null || s.length() == 0;
    }


}
