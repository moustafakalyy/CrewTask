package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = "stepdefinitions",
        features = {"src/test/resources/functionaltests/SubscriptionPackages.feature"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true)


public class SubscriptionPackagesTestRunner extends AbstractTestNGCucumberTests {

}
