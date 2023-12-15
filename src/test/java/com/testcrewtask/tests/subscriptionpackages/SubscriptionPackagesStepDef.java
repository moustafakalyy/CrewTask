package com.testcrewtask.tests.subscriptionpackages;

import com.testcrewtask.pages.ChooseYourPlanPage;
import com.testcrewtask.utilities.PropertyFileObject;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

import com.testcrewtask.utilities.DriverObject;
import org.testng.asserts.SoftAssert;

public class SubscriptionPackagesStepDef {
    private DriverObject driverObject;
    private PropertyFileObject propertyFileObject;
    private ChooseYourPlanPage chooseYourPlanPage;
    private SoftAssert softAssert;

    @Given("navigated to choose your plan page")
    public void navigated_to_choose_your_plan_page() throws Exception {
        propertyFileObject = new PropertyFileObject();
        driverObject = new DriverObject("Chrome", propertyFileObject.getProperties());
        chooseYourPlanPage = new ChooseYourPlanPage(driverObject.getDriver());
        softAssert = new SoftAssert();
    }

    @When("user selects {string}")
    public void user_selects(String countryName) throws Exception {
        chooseYourPlanPage.selectCountry(countryName);
    }

    @Then("all subscription packages should be displayed")
    public void all_subscription_packages_should_be_displayedEng() throws Exception {
        softAssert.assertEquals(chooseYourPlanPage.getLitePlanText(), "LITE", "Lite package is not displayed correctly");
        softAssert.assertEquals(chooseYourPlanPage.getClassicPlanText(), "CLASSIC", "Classic package is not displayed correctly");
        softAssert.assertEquals(chooseYourPlanPage.getPremiumPlanText(), "PREMIUM", "Premium package is not displayed correctly");

    }

    @Then("plan prices should be displayed as {string} , {string},{string} for Lite, Classic and Premium plans respectively")
    public void plan_prices_should_be_displayed_as_respectively(String litePlanPrice, String classicPlanPrice, String premiumPlanPrice) throws Exception {
        softAssert.assertEquals(chooseYourPlanPage.getLitePlanPrice(), litePlanPrice, "Lite plan price is not displayed correctly");
        softAssert.assertEquals(chooseYourPlanPage.getClassicPlanPrice(), classicPlanPrice, "Classic plan price is not displayed correctly");
        softAssert.assertEquals(chooseYourPlanPage.getPremiumPlanPrice(), premiumPlanPrice, "Premium plan price is not displayed correctly");

    }

    @Then("all plans currencies displayed as {string}")
    public void all_plans_currencies_displayed_as(String currency) throws Exception {
        softAssert.assertEquals(chooseYourPlanPage.getLitePlanCurrency(), currency, "Lite plan currency is not displayed correctly");
        softAssert.assertEquals(chooseYourPlanPage.getClassicPlanCurrency(), currency, "Classic plan currency is not displayed correctly");
        softAssert.assertEquals(chooseYourPlanPage.getPremiumPlanCurrency(), currency, "Premium plan currency is not displayed correctly");
        softAssert.assertAll();

    }


    @AfterStep
    public void addScreenshot(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driverObject.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }

    }

    @After
    public void tearDown() {
        driverObject.getDriver().close();
    }


}
