package pages;

import utilities.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

/************************ Page Header Elements ************************/

private final By changeCountryArrow = By.xpath("//span[@id='arrow']");
protected By languageBtn=By.xpath("//a[@id='translation-btn']");

/************************ Select Your Country popUp Elements ************************/

private final By bahrainImg = By.xpath("//div[@id='bh-contry-flag']/img");
private final By saudiImg = By.xpath("//div[@id='sa-contry-flag']/img");
private final By kuwaitImg = By.xpath("//div[@id='kw-contry-flag']/img");
private final By selectYourCountryAnchor=By.xpath("//body[@class='form-active has-scrollbar countries']");



protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


/************************ Page Header Function ************************/

public void clickOnChangeCountryArrow() throws Exception {
    BrowserActions.clickOnWebElement(changeCountryArrow, this.driver);
    BrowserActions.waitUntilWebElementIsVisible(selectYourCountryAnchor,this.driver);
}

/************************ Select Your Country popUp Functions ************************/


public void selectCountry(String country) throws Exception {
    clickOnChangeCountryArrow();
    switch (country){
        case "Bahrain":BrowserActions.clickOnWebElement(bahrainImg,this.driver);break;
        case "Saudi":BrowserActions.clickOnWebElement(saudiImg,this.driver);break;
        case "Kuwait":BrowserActions.clickOnWebElement(kuwaitImg,this.driver);break;
        default: System.out.println("Country not found");
    }
    BrowserActions.waitUntilWebElementIsNotVisible(selectYourCountryAnchor,this.driver);
}

}
