package gov.healthit.chpl.aqa.stepDefinitions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


/**
 * Set Cucumber Options.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/resources/Features",
format = { "json:target/cucumber.json", "html:target/site/cucumber-pretty"},
plugin = {"pretty", "html:target/cucumber-html-report"},
glue = "gov.healthit.chpl.aqa.stepDefinitions",
tags = {},
monochrome = false
)

/**
 * Class RunnerTest definition.
 */
public class RunnerTest {

}
