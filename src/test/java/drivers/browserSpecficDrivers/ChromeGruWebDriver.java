package drivers.browserSpecficDrivers;

import drivers.basedriver.GruWebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Created by arvin on 01/02/2017.
 */
public class ChromeGruWebDriver extends GruWebDriver {

    public ChromeGruWebDriver() {
        super(new ChromeDriver(Options()),10);
    }
    public ChromeGruWebDriver(int timeout ){
        super(new ChromeDriver(Options()),timeout);
    }

    private static ChromeOptions Options(){
        System.setProperty("webdriver.chrome.driver", String.format("%s\\chromedriver.exe",System.getProperty("user.dir")));
        ChromeOptions options;
        options = new ChromeOptions();
        return options;
    }



}
