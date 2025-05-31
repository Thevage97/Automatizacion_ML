package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {
        "steps",
        "hooks"
    },
    plugin = {
        "pretty",
        "html:target/custom-cucumber-reports/cucumber.html",
        "json:target/custom-cucumber-reports/cucumber.json",
        "junit:target/custom-cucumber-reports/cucumber.xml"
    },
    monochrome = true,
    tags = "@Test"
)
public class Runner {
    
}
