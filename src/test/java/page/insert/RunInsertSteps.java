package java1.page.insert;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/insert.feature", glue = "page.insert")

public class RunInsertSteps {
}