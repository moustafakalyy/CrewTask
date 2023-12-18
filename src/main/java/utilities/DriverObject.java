package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverObject {
    private WebDriver driver;
    private ConfigFileReader configFileReader;

    public DriverObject() throws Exception {
        configFileReader = new ConfigFileReader();
        String browserName = configFileReader.getBrowser();
        switch (browserName) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.get(configFileReader.getUrl());
                driver.manage().window().maximize();
                break;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.get(configFileReader.getUrl());
                driver.manage().window().maximize();
                break;
            case "Edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.get(configFileReader.getUrl());
                driver.manage().window().maximize();
                break;
            default:
                System.out.println("Browser is not Supported");
        }
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}
