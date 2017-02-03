package drivers.browserSpecficDrivers;

import drivers.basedriver.GruWebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 * Created by arvin on 02/02/2017.
 */
public class FireFoxGruWebDriver  extends GruWebDriver {


    public FireFoxGruWebDriver() {
        super(new FirefoxDriver(Options()),10);
    }
    public FireFoxGruWebDriver(int timeout ){
        super(new FirefoxDriver(Options()),timeout);
    }

    private static FirefoxProfile Options(){

        FirefoxProfile options;
        options = new FirefoxProfile();
        options.setPreference("accessibility.force_disabled", 1);
        return options;
    }


}
