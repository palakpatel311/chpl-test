package stepDefinitions;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/resources/Features",
format = { "json:target/cucumber.json", "html:target/site/cucumber-pretty"},
plugin = {"pretty", "html:target/cucumber-html-report"},
glue = "src/test/java/stepDefinitions/",
tags = {},
monochrome = false

)
public class runnerTest extends AbstractTestNGCucumberTests {

}
