package glue;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import drivers.browserSpecficDrivers.FireFoxGruWebDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Created by arvinth seran on 01/02/2017.
 */
public class Hooks extends BaseUtil {

    private BaseUtil baseUtil;

    public Hooks(BaseUtil baseUtil) {

        this.baseUtil = baseUtil;
    }

    @Before
    public void Before() throws Throwable {
        baseUtil.baseWebDriver = new FireFoxGruWebDriver(15);
    }

    @After
    public void After(Scenario scenario) throws Throwable {
        if (scenario.isFailed()){
            File screenShotFile = ((TakesScreenshot)baseUtil.baseWebDriver.getWebDriver()).getScreenshotAs(OutputType.FILE);
            String fileName = String.format("%s%s-%s%s%s%s%s.jpeg",
                    "C:\\",
                    scenario.getId(),
                    LocalDateTime.now().getDayOfMonth(),
                    LocalDateTime.now().getMonthValue(),
                    LocalDateTime.now().getYear(),
                    LocalDateTime.now().getHour(),
                    LocalDateTime.now().getMinute());
            try {
                FileUtils.copyFile(screenShotFile, new File(fileName));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        baseUtil.baseWebDriver.CloseAndQuit();
    }

}
