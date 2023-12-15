package com.testcrewtask.tests.subscriptionpackages;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = "com.testcrewtask.tests.subscriptionpackages",
        features = {"src/test/java/com/testcrewtask/tests/subscriptionpackages/subscriptionpackages.feature"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true)


public class SubscriptionPackagesRunner extends AbstractTestNGCucumberTests {

}
