package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserActions {

    public static void waitUntilWebElementIsVisible(By element, WebDriver driver) throws Exception {
        ConfigFileReader configFileReader = new ConfigFileReader();
        WebDriverWait wait = new WebDriverWait(driver, configFileReader.getImplicitTimeOut());
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void waitUntilWebElementIsNotVisible(By element, WebDriver driver) throws Exception {
        ConfigFileReader configFileReader = new ConfigFileReader();
        WebDriverWait wait = new WebDriverWait(driver, configFileReader.getImplicitTimeOut());
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void waitUntilWebElementIsEnabled(By element, WebDriver driver) throws Exception {
        ConfigFileReader configFileReader = new ConfigFileReader();
        WebDriverWait wait = new WebDriverWait(driver, configFileReader.getImplicitTimeOut());
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void waitUntilWebElementIsPresent(By element, WebDriver driver) throws Exception {
        ConfigFileReader configFileReader = new ConfigFileReader();
        WebDriverWait wait = new WebDriverWait(driver, configFileReader.getImplicitTimeOut());
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(element));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void clickOnWebElement(By element, WebDriver driver) throws Exception {
        BrowserActions.waitUntilWebElementIsVisible(element, driver);
        try {
            driver.findElement(element).click();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("Can not click on WebElement: " + element.toString(), e);
        }
    }

    public static void enterTextInWebElement(By element, WebDriver driver, String text) throws Exception {
        BrowserActions.waitUntilWebElementIsVisible(element, driver);
        try {
            driver.findElement(element).clear();
            driver.findElement(element).sendKeys(text);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("Can not enter text in WebElement: " + element.toString(), e);
        }
    }

    public static void enterTextInWebElementAndThenPressEnter(By element, WebDriver driver, String text) throws Exception {
        BrowserActions.waitUntilWebElementIsVisible(element, driver);
        try {
            driver.findElement(element).clear();
            driver.findElement(element).sendKeys(text);
            driver.findElement(element).sendKeys(Keys.ENTER);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("Can not enter text in WebElement: " + element.toString(), e);
        }
    }

    public static String getWebElementText(By element, WebDriver driver) throws Exception {
        BrowserActions.waitUntilWebElementIsVisible(element, driver);
        try {
            return driver.findElement(element).getText();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("Can not get text from WebElement: " + element.toString(), e);
        }
    }

    public static String getWebElementAttribute(By element, WebDriver driver, String attributeName) throws Exception {
        BrowserActions.waitUntilWebElementIsVisible(element, driver);
        try {
            return driver.findElement(element).getAttribute(attributeName);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("Can not get attribute from WebElement: " + element.toString(), e);
        }
    }

    public static void switchToFrameById(String id, WebDriver driver) throws Exception {
        try {
            driver.switchTo().frame(id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("Can not switch to frame by id: " + id, e);
        }
    }

    public static void switchToMainWindow(WebDriver driver) throws Exception {
        try {
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("Can not switch to default frame", e);
        }
    }

    public static void selectFromDropdownByVisibleText(By element, WebDriver driver, String visibleText) throws Exception {
        BrowserActions.waitUntilWebElementIsVisible(element, driver);
        try {
            Select dropdownElement = new Select(driver.findElement(element));
            dropdownElement.selectByVisibleText(visibleText);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("Can not select " + visibleText + " from dropdown: " + element.toString(), e);
        }
    }

    public static void selectFromDropdownByValue(By element, WebDriver driver, String value) throws Exception {
        BrowserActions.waitUntilWebElementIsVisible(element, driver);
        try {
            Select dropdownElement = new Select(driver.findElement(element));
            dropdownElement.selectByValue(value);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("Can not select " + value + " from dropdown: " + element.toString(), e);
        }
    }

    public static void hoverOverWebElement(By element, WebDriver driver) throws Exception {
        BrowserActions.waitUntilWebElementIsVisible(element, driver);
        try {
            WebElement webElement = driver.findElement(element);
            Actions action = new Actions(driver);
            action.moveToElement(webElement).perform();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("Can not hover over WebElement: " + element.toString(), e);
        }
    }

    public static void scrollToWebElement(By element, WebDriver driver) throws Exception {
        BrowserActions.waitUntilWebElementIsPresent(element, driver);
        try {
            WebElement webElement = driver.findElement(element);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("Can not scroll to WebElement: " + element.toString(), e);
        }
    }

    public static boolean isWebElementPresent(By element, WebDriver driver) throws Exception {
        BrowserActions.waitUntilWebElementIsVisible(element, driver);
        try {
            driver.findElement(element);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isWebElementVisible(By element, WebDriver driver) {
        try {
            ConfigFileReader configFileReader = new ConfigFileReader();
            WebDriverWait wait = new WebDriverWait(driver, configFileReader.getImplicitTimeOut());
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isCheckBoxSelected(By checkBoxElement, WebDriver driver) throws Exception {
        BrowserActions.waitUntilWebElementIsVisible(checkBoxElement, driver);
        try {
            return driver.findElement(checkBoxElement).isSelected();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("Can not determine checkbox status of WebElement: " + checkBoxElement.toString(), e);
        }
    }
}