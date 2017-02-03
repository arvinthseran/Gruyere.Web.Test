package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * Created by arvinth seran on 01/02/2017.
 */
@CucumberOptions(features = "src/test/cucumber/features",
        glue = "glue",
        format = {"pretty"})

public class TestRunner extends AbstractTestNGCucumberTests {
}
