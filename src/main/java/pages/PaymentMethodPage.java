package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserActions;

public class PaymentMethodPage extends BasePage {
    /************************ Payment Method Page Elements *********************************/

    private final By paymentMethodHeader=By.xpath("//h3[text()='Payment Method']");
    private final By planPrice=By.xpath("//span[@id='order-tier-price']/b");
    private final By planType=By.xpath("//span[@id='order-tier-name']");


    public PaymentMethodPage(WebDriver driver) throws Exception {
        super(driver);
        waitUntilPaymentMethodPageLoaded();
    }

    /************************ Payment Method Page Functions *********************************/


    public void waitUntilPaymentMethodPageLoaded() throws Exception {
        BrowserActions.waitUntilWebElementIsVisible(paymentMethodHeader, this.driver);
    }

    public String getPlanPrice() throws Exception {
        return BrowserActions.getWebElementText(planPrice, this.driver);
    }

    public String getPlanType() throws Exception {
        return BrowserActions.getWebElementText(planType, this.driver);
    }

    public Boolean isPaymentMethodPageDisplayed() throws Exception {
        return BrowserActions.isWebElementPresent(paymentMethodHeader,this.driver);
    }


}
