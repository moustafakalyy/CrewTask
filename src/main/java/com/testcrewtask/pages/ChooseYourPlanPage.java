package com.testcrewtask.pages;

import com.testcrewtask.utilities.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChooseYourPlanPage extends BasePage {
    /************************ Choose Your Plan Table Elements *********************************/

    private final By litePlanHeader=By.xpath("//div[@class='plan-names']//strong[@id='name-lite' or @id='name-لايت']");
    private final By classicPlanHeader=By.xpath("//div[@class='plan-names']//strong[@id='name-classic' or @id='name-الأساسية']");
    private final By premiumPlanHeader=By.xpath("//div[@class='plan-names']//strong[@id='name-premium' or @id='name-بريميوم']");
    private final By litePlanPrice=By.xpath("//div[@id='currency-lite' or @id='currency-لايت']/b");
    private final By classicPlanPrice=By.xpath("//div[@id='currency-classic' or @id='currency-الأساسية']/b");
    private final By premiumPlanPrice=By.xpath("//div[@id='currency-premium' or @id='currency-بريميوم']/b");
    private final By litePlanCurrencyPerMonth=By.xpath("//div[@id='currency-lite' or @id='currency-لايت']/i");
    private final By classicPlanCurrencyPerMonth=By.xpath("//div[@id='currency-classic' or @id='currency-الأساسية']/i");
    private final By premiumPlanCurrencyPerMonth=By.xpath("//div[@id='currency-premium' or @id='currency-بريميوم']/i");

    public ChooseYourPlanPage(WebDriver driver) {
        super(driver);
        waitUntilHomePageIsLoaded();
    }

    public void waitUntilHomePageIsLoaded(){
        BrowserActions.waitUntilWebElementIsVisible(languageBtn, this.driver);
    }

    /************************ Choose Your Plan Table Functions *********************************/

    public String getLitePlanText() throws Exception {
        return BrowserActions.getWebElementText(litePlanHeader,this.driver);
    }

    public String getClassicPlanText() throws Exception {
        return BrowserActions.getWebElementText(classicPlanHeader,this.driver);
    }

    public String getPremiumPlanText() throws Exception {
        return BrowserActions.getWebElementText(premiumPlanHeader,this.driver);
    }

    public String getLitePlanPrice() throws Exception {
        return BrowserActions.getWebElementText(litePlanPrice,this.driver);
    }

    public String getClassicPlanPrice() throws Exception {
        return BrowserActions.getWebElementText(classicPlanPrice,this.driver);
    }

    public String getPremiumPlanPrice() throws Exception {
        return BrowserActions.getWebElementText(premiumPlanPrice,this.driver);
    }

    public String getLitePlanCurrency() throws Exception {
        String result=BrowserActions.getWebElementText(litePlanCurrencyPerMonth,this.driver);
        return result.substring(0,result.indexOf('/'));
    }

    public String getClassicPlanCurrency() throws Exception {
        String result=BrowserActions.getWebElementText(classicPlanCurrencyPerMonth,this.driver);
        return result.substring(0,result.indexOf('/'));
    }

    public String getPremiumPlanCurrency() throws Exception {
        String result=BrowserActions.getWebElementText(premiumPlanCurrencyPerMonth,this.driver);
        return result.substring(0,result.indexOf('/'));
    }



}