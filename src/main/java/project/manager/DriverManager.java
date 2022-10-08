package project.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;

import static java.lang.System.setProperty;
import static project.properties.TestProperties.getInstance;

public class DriverManager {

    private WebDriver driver;
    private static DriverManager instance = null;
    private final Properties properties = getInstance().getProperties();

    private DriverManager() {
    }

    public static DriverManager getDriverManager() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public WebDriver getWebDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    private void initDriver() {
        setProperty(properties.getProperty("WEB_DRIVER"), properties.getProperty("WEB_DRIVER_PATH"));
        driver = new ChromeDriver();
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
