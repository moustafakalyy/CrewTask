package stepdefinitions;

import io.cucumber.java.en.And;
import pages.ChooseYourPlanPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

import pages.PaymentMethodPage;
import utilities.DriverObject;
import org.testng.asserts.SoftAssert;

public class SubscriptionPackagesSteps {
    private DriverObject driverObject;
    private ChooseYourPlanPage chooseYourPlanPage;
    private PaymentMethodPage paymentMethodPage;

    private SoftAssert softAssert;

    @Given("navigated to choose your plan page")
    public void navigated_to_choose_your_plan_page() throws Exception {
        driverObject = new DriverObject();
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


    @Then("discovery+ subscription should be included for all subscription packages")
    public void discoverySubscriptionShouldBeIncludedForAllSubscriptionPackages() throws Exception {
        softAssert.assertEquals(chooseYourPlanPage.getLitePlanDiscoveryStatus(), "Included", "Discovery+ status is not displayed correctly for Lite plan package");
        softAssert.assertEquals(chooseYourPlanPage.getClassicPlanDiscoveryStatus(), "Included", "Discovery+ status is not displayed correctly for classic plan package");
        softAssert.assertEquals(chooseYourPlanPage.getPremiumPlanDiscoveryStatus(), "Included", "Discovery+ status is not displayed correctly for Premium plan package");
        softAssert.assertAll();
    }

    @When("user selects saudi arabia")
    public void userSelectsSaudiArabia() throws Exception {
        chooseYourPlanPage.selectCountry("Saudi");
    }

    @Then("free trial periods should be displayed as {string} , {string} and {string}")
    public void freeTrialPeriodsShouldBeDisplayedAsAnd(String litePlanFreTrialPeriod, String classicPlanFreTrialPeriod, String premiumPlanFreTrialPeriod) throws Exception {
        System.out.println(chooseYourPlanPage.getLitePlanFreePeriod());
        softAssert.assertEquals(chooseYourPlanPage.getLitePlanFreePeriod(), "For "+litePlanFreTrialPeriod+" days", "Free period is not displayed correctly for lite plan package");
        softAssert.assertEquals(chooseYourPlanPage.getClassicPlanFreePeriod(), "For "+classicPlanFreTrialPeriod+" days", "Free period is not displayed correctly for classic plan package");
        softAssert.assertEquals(chooseYourPlanPage.getPremiumPlanFreePeriod(), "For "+premiumPlanFreTrialPeriod+" days", "Free period is not displayed correctly for premium plan package");
        softAssert.assertAll();

    }

    @Then("user is directed to payment method page")
    public void userIsDirectedToPaymentMethodPage() throws Exception {
        softAssert.assertTrue(paymentMethodPage.isPaymentMethodPageDisplayed(), "Payment method page is not displayed");
    }

    @And("selects {string}")
    public void selects(String planType) throws Exception {
        paymentMethodPage=chooseYourPlanPage.clickOnPlanType(planType);
    }

    @And("plan price should be displayed as {string}")
    public void planPriceShouldBeDisplayedAs(String planPrice) throws Exception {
        softAssert.assertEquals(paymentMethodPage.getPlanPrice(), planPrice, "Plan price is not displayed correctly");

    }

    @And("plan type should be displayed as   {string}")
    public void planTypeShouldBeDisplayedAs(String planType) throws Exception {
        softAssert.assertEquals(paymentMethodPage.getPlanType(), "Plan: "+planType, "Plan type is not displayed correctly");
        softAssert.assertAll();
    }
}
