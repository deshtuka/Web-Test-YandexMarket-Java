package project.pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.manager.DriverManager;

import java.util.ArrayList;
import java.util.Properties;

import static org.openqa.selenium.support.PageFactory.initElements;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static project.properties.TestProperties.getInstance;

public class BasePage {

    private static final Properties properties = getInstance().getProperties();
    protected final DriverManager driverManager = DriverManager.getDriverManager();
    protected final WebDriver driver = driverManager.getWebDriver();
    protected final JavascriptExecutor js = (JavascriptExecutor) driverManager.getWebDriver();
    protected WebDriverWait wait = new WebDriverWait(
            driverManager.getWebDriver(),
            Integer.parseInt(properties.getProperty("TIME_EXPLICIT_WAIT")),
            Integer.parseInt(properties.getProperty("TIME_EXPLICIT_SLEEP_IN_MILLS")));

    public BasePage() {
        // Инициализация драйвера для всех методов без объявления
        initElements(driverManager.getWebDriver(), this);
    }

    public void openSite(String url) {
        // Открыть сайт
        driverManager.getWebDriver().get(url);
    }

    public void switchToWindow() {
        String oldTab = driver.getWindowHandle();
        ArrayList<String> newTab = new ArrayList<String> (driver.getWindowHandles());
        newTab.remove(oldTab);
        driver.switchTo().window(newTab.get(0));
    }

    protected WebElement waitUntilVisibilityOf(WebElement element) {
        // Явное ожидание - когда элемент станет видимым
        wait.until(visibilityOf(element));
        return element;
    }

    public void enterInput(WebElement element, String value) {
        // Заполнение полей типа Input
        element.clear();
        element.sendKeys(value);
        wait.until(ExpectedConditions.attributeToBe(element, "value", value));
    }

    protected WebElement moveToElement(WebElement element) {
        // Скрол к центру элемента
        js.executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});", element);
        return element;
    }

    protected WebElement waitToBeClickableAndClick(WebElement element) {
        // Ожидание доступности и клик
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        return element;
    }

    public void isDisplayed(String message, WebElement element) {
        // Проверка. Элемент отображается
        Assert.assertTrue(String.format("Элемент '%s' - не отображается", message), element.isDisplayed());
    }

    public void isContainsValue(String textContains, WebElement element) {
        // Проверка. Элемент содержит введенное значение
        Assert.assertEquals("Значение элемента не совпадает", textContains, element.getAttribute("value"));
    }

    public void isSelected(String textElement, WebElement element) {
        // Проверка. Элемент содержит введенное значение
        Assert.assertTrue(String.format("Чекбок '%s' не кликнут!", textElement), element.isSelected());
    }
}
