package pages;

import utilities.BrowserActions;
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
    private final By litePlanDiscoveryStatus=By.xpath("(//img[@src='https://cdn-stg.jawwy.tv/28/New Design/mlp-discovery-horizontal.svg']//parent::div[1])[1]/following-sibling::div/div[1]");
    private final By classicPlanDiscoveryStatus=By.xpath("(//img[@src='https://cdn-stg.jawwy.tv/28/New Design/mlp-discovery-horizontal.svg']//parent::div[1])[1]/following-sibling::div/div[2]");
    private final By premiumPlanDiscoveryStatus=By.xpath("(//img[@src='https://cdn-stg.jawwy.tv/28/New Design/mlp-discovery-horizontal.svg']//parent::div[1])[1]/following-sibling::div/div[3]");
    private final By litePlanFreePeriod=By.xpath("//div[text()='Free trial']/following-sibling::div/div[1]");
    private final By classicPlanFreePeriod=By.xpath("//div[text()='Free trial']/following-sibling::div/div[2]");
    private final By premiumPlanFreePeriod=By.xpath("//div[text()='Free trial']/following-sibling::div/div[3]");

    public ChooseYourPlanPage(WebDriver driver) throws Exception {
        super(driver);
        waitUntilHomePageIsLoaded();
    }

    public void waitUntilHomePageIsLoaded() throws Exception {
        BrowserActions.waitUntilWebElementIsVisible(languageBtn, this.driver);
    }

    /************************ Choose Your Plan Table Functions *********************************/

    public PaymentMethodPage clickOnPlanType(String planName) throws Exception {
        By ele=By.xpath("//strong[text()='"+planName+"']/following-sibling::a");
        BrowserActions.clickOnWebElement(ele,this.driver);
        return new PaymentMethodPage(this.driver);
    }

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

    public String getLitePlanDiscoveryStatus() throws Exception {
        return BrowserActions.getWebElementText(litePlanDiscoveryStatus,this.driver);
    }

    public String getClassicPlanDiscoveryStatus() throws Exception {
        return BrowserActions.getWebElementText(classicPlanDiscoveryStatus,this.driver);
    }

    public String getPremiumPlanDiscoveryStatus() throws Exception {
        return BrowserActions.getWebElementText(premiumPlanDiscoveryStatus,this.driver);
    }

    public String getLitePlanFreePeriod() throws Exception {
        return BrowserActions.getWebElementText(litePlanFreePeriod,this.driver);
    }

    public String getClassicPlanFreePeriod() throws Exception {
        return BrowserActions.getWebElementText(classicPlanFreePeriod,this.driver);
    }

    public String getPremiumPlanFreePeriod() throws Exception {
        return BrowserActions.getWebElementText(premiumPlanFreePeriod,this.driver);
    }



}