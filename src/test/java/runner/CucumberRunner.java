package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/scenario"},
        glue = {"project/steps"},
        plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        tags = "@yandex"
)
public class CucumberRunner {
}
