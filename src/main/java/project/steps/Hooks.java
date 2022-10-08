package project.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import project.manager.DriverManager;
import project.manager.InitManager;

public class Hooks {
    /** Универсальная настройка для всех тестов вначале и конце сценария */

    @Before
    public void before() {
        InitManager.initFramework();
    }

    @After
    public void after(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriverManager().getWebDriver();
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "img/png", "Screenshot");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        InitManager.quitFramework();
    }
}
